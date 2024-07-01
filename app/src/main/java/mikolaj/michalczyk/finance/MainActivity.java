package mikolaj.michalczyk.finance;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import mikolaj.michalczyk.finance.API.ApiService;
import mikolaj.michalczyk.finance.adapter.StockAdapter;
import mikolaj.michalczyk.finance.model.Quote;
import mikolaj.michalczyk.finance.model.StockList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
    private RecyclerView stockRecyclerView;
    private StockAdapter stockAdapter;
    private Spinner spinnerInterval;
    private Spinner spinnerRegion;
    private Spinner spinnerRange;
    private Button buttonSelect;
    private final String[] INTERVAL_OPTIONS = {"15m", "30m", "60m", "1d", "1wk", "1mo"};
    private final String[] REGION_OPTIONS = {"US", "BR", "AU", "CA", "FR", "DE", "HK", "IN", "IT", "ES", "GB", "SG"};
    private final String[] RANGE_OPTIONS = {"1d", "5d", "1mo", "3mo", "6mo", "1y", "2y", "5y", "10y", "ytd"};

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://apidojo-yahoo-finance-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final ApiService apiService = retrofit.create(ApiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        stockRecyclerView = findViewById(R.id.stockRecyclerView);

        stockAdapter = new StockAdapter(this, this::initChooseScreen);
        stockRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stockRecyclerView.setAdapter(stockAdapter); // Set adapter here

        searchButton.setOnClickListener(view -> {
            String stockSymbol = searchEditText.getText().toString().trim();
            Log.d("MAIN", "onSearchButtonClicked: " + stockSymbol);
            fetchStockInfo("US", stockSymbol);
            hideKeyboard(getCurrentFocus());
        });
    }

    private void fetchStockInfo(String region, String query) {
        Call<StockList> call = apiService.getStockInfo(region, query, Secret.API_KEY);
        Log.d("MAIN", "Sending request for region: " + region + ", query: " + query); // Log request
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<StockList> call, @NonNull Response<StockList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("MAIN", "Received successful response: " + response.body()); // Log success
                    StockList stockList = response.body();
                    stockAdapter.setStockList(stockList); // Update the adapter
                } else {
                    // Handle unsuccessful response (e.g., API errors)
                    Log.e("MAIN", "Unsuccessful response: " + response.code());

                    Log.e("MAIN", "Error body: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<StockList> call, @NonNull Throwable t) {
                // Handle network errors or other failures
                Log.e("MAIN", "Error fetching stock info", t);
                Toast.makeText(MainActivity.this, "Error fetching stock info. Check internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void hideKeyboard(View view){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if(view!=null)
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    private void initChooseScreen(Quote stock){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.chart_input); // Make sure this matches the XML filename

        spinnerInterval = dialog.findViewById(R.id.spinnerInterval);
        spinnerRegion = dialog.findViewById(R.id.spinnerRegion);
        spinnerRange = dialog.findViewById(R.id.spinnerRange);
        buttonSelect = dialog.findViewById(R.id.buttonSelect);

        ArrayAdapter<String> intervalAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, INTERVAL_OPTIONS);
        intervalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInterval.setAdapter(intervalAdapter);

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, REGION_OPTIONS);
        regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(regionAdapter);

        ArrayAdapter<String> rangeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, RANGE_OPTIONS);
        rangeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRange.setAdapter(rangeAdapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validateSelection();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                buttonSelect.setEnabled(false);
            }
        };

        spinnerInterval.setOnItemSelectedListener(itemSelectedListener);
        spinnerRegion.setOnItemSelectedListener(itemSelectedListener);
        spinnerRange.setOnItemSelectedListener(itemSelectedListener);

        buttonSelect.setOnClickListener(v -> {
            String selectedInterval = spinnerInterval.getSelectedItem().toString();
            String selectedRegion = spinnerRegion.getSelectedItem().toString();
            String selectedRange = spinnerRange.getSelectedItem().toString();

            if (!isValidSelection(selectedInterval, selectedRange)) {
                Toast.makeText(MainActivity.this, "Invalid selection: interval must be less than the range.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, ChartActivity.class);
            intent.putExtra(Tags.SYMBOL_TAG, stock.getSymbol());
            intent.putExtra(Tags.INTERVAL_TAG, selectedInterval); // Corrected line
            intent.putExtra(Tags.REGION_TAG, selectedRegion);
            intent.putExtra(Tags.RANGE_TAG, selectedRange);
            startActivity(intent);

            dialog.dismiss();
        });

        dialog.show();

    }

    private void validateSelection() {
        boolean isIntervalSelected = spinnerInterval.getSelectedItem() != null;
        boolean isRegionSelected = spinnerRegion.getSelectedItem() != null;
        boolean isRangeSelected = spinnerRange.getSelectedItem() != null;

        buttonSelect.setEnabled(isIntervalSelected && isRegionSelected && isRangeSelected);
    }

    private boolean isValidSelection(String interval, String range) {
        double intervalIndex = getValue(interval);
        double rangeIndex = getValue(range);
        return intervalIndex < rangeIndex;
    }

    private double getValue(String value) {

            switch (value){
                case "15m" -> {
                    return 0.25d;
                }
                case "30m" -> {
                    return 0.5d;
                }
                case "60m" -> {
                    return 1d;
                }
                case "1d" -> {
                    return 24d;
                }
                case "5d" -> {
                    return 24*5d;
                }
                case "1wk" -> {
                    return 24*7d;
                }
                case "1mo" -> {
                    return 30*24d;
                }
                default -> {
                    return 32*24d;
                }
            }
    }


}