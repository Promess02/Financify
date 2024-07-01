package mikolaj.michalczyk.finance;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import mikolaj.michalczyk.finance.API.ApiService;
import mikolaj.michalczyk.finance.model.ChartResponse;
import mikolaj.michalczyk.finance.model.Meta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChartActivity extends AppCompatActivity {
    private LineChart lineChart;
    private ApiService apiService;
    private Button detailBtn;
    private Button refreshBtn;
    private Button volumeBtn;
    private String symbol;
    private TextView currency;
    private String interval;
    private String range;
    private String region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        symbol = getIntent().getStringExtra(Tags.SYMBOL_TAG);
        interval = getIntent().getStringExtra(Tags.INTERVAL_TAG);
        range = getIntent().getStringExtra(Tags.RANGE_TAG);
        region = getIntent().getStringExtra(Tags.REGION_TAG);
        Log.d("ChartActivity", "Received stock symbol: " + symbol); // Log received symbol

        TextView stockSymbol = findViewById(R.id.stockSymbol);
        stockSymbol.setText(symbol);
        detailBtn = findViewById(R.id.DetailsBtn);
        refreshBtn = findViewById(R.id.RefreshBtn);
        volumeBtn = findViewById(R.id.VolumeChartBtn);
        currency = findViewById(R.id.CurrencyTextView);
        lineChart = findViewById(R.id.lineChart);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apidojo-yahoo-finance-v1.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
        fetchChartData(symbol);
        initRefreshBtn();
    }

    private void fetchChartData(String symbol) {
        Log.d("ChartActivity", "Fetching chart data for symbol: " + symbol); // Log fetch start
        apiService.getChart(interval, region, symbol, range, Secret.API_KEY)
                .enqueue(new Callback<>() {
                    @Override
                    public void onResponse(@NonNull Call<ChartResponse> call, @NonNull Response<ChartResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("ChartActivity", "Received successful response: " + response.body()); // Log success
                            displayChart(response.body());
                            currency.setText(response.body().getChart().getResult().get(0).getMeta().getCurrency());
                            initDetailBtn(response.body());
                            initVolumeBtn(response.body());
                        } else {
                            Log.e("ChartActivity", "Unsuccessful response: " + response.code()); // Log error
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ChartResponse> call, @NonNull Throwable t) {
                        Log.e("ChartActivity", "Error fetching chart data", t); // Log exception
                        Toast.makeText(ChartActivity.this, "Error fetching chart. Check internet connection", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initDetailBtn(ChartResponse chartResponse){
        detailBtn.setOnClickListener(view -> {
            Meta meta = chartResponse.getChart().getResult().get(0).getMeta();
            detailBtn.setOnClickListener(view2 -> {
                // Inflate the dialog layout
                Dialog dialog = new Dialog(this);
                View dialogView = getLayoutInflater().inflate(R.layout.stock_details, null);
                dialog.setContentView(dialogView);

                // Find the TextViews and set the values from chartResponse
                TextView currencyTextView = dialogView.findViewById(R.id.CurrencyTextView);
                currencyTextView.setText(meta.getCurrency());
                TextView regularMarketPriceTextView = dialogView.findViewById(R.id.RegularMarketPrice);
                regularMarketPriceTextView.setText(String.valueOf(meta.getRegularMarketPrice()));
                TextView fiftyTwoWeekHighTextView = dialogView.findViewById(R.id.FiftyTwoWeekHigh);
                fiftyTwoWeekHighTextView.setText(String.valueOf(meta.getFiftyTwoWeekHigh()));
                TextView fiftyTwoWeekLowTextView = dialogView.findViewById(R.id.FiftyTwoWeekLow);
                fiftyTwoWeekLowTextView.setText(String.valueOf(meta.getFiftyTwoWeekLow()));
                TextView regularMarketDayHighTextView = dialogView.findViewById(R.id.RegularMarketDayHigh);
                regularMarketDayHighTextView.setText(String.valueOf(meta.getRegularMarketDayHigh()));
                TextView regularMarketDayLowTextView = dialogView.findViewById(R.id.RegularMarketDayLow);
                regularMarketDayLowTextView.setText(String.valueOf(meta.getRegularMarketDayLow()));
                TextView regularMarketVolumeTextView = dialogView.findViewById(R.id.RegularMarketVolume);
                regularMarketVolumeTextView.setText(String.valueOf(meta.getRegularMarketVolume()));

                // Find the close button and set a click listener
                ImageView closeButton = dialogView.findViewById(R.id.closeButton);
                closeButton.setOnClickListener(v -> dialog.dismiss());

                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                dialog.show();
            });
        });
    }

    private void initRefreshBtn(){
        refreshBtn.setOnClickListener(view -> fetchChartData(symbol));
    }

    private void initVolumeBtn(ChartResponse chartResponse){
        List<Entry> entries = new ArrayList<>();
        volumeBtn.setOnClickListener(view -> {
            if (chartResponse.getChart() != null &&
                    chartResponse.getChart().getResult() != null &&
                    !chartResponse.getChart().getResult().isEmpty() &&
                    chartResponse.getChart().getResult().get(0).getTimestamp() != null &&
                    chartResponse.getChart().getResult().get(0).getIndicators() != null &&
                    chartResponse.getChart().getResult().get(0).getIndicators().getQuote() != null &&
                    !chartResponse.getChart().getResult().get(0).getIndicators().getQuote().isEmpty() &&
                    chartResponse.getChart().getResult().get(0).getIndicators().getQuote().get(0).getVolume() != null) {

                Dialog dialog = new Dialog(this);
                View dialogView = getLayoutInflater().inflate(R.layout.volume_details, null);
                dialog.setContentView(dialogView);
                List<Long> timestamps = chartResponse.getChart().getResult().get(0).getTimestamp();
                List<Double> volume = chartResponse.getChart().getResult().get(0).getIndicators().getQuote().get(0).getVolume();
                LineChart lineChartVolume = dialogView.findViewById(R.id.lineChartVolume);
                TextView symbolView = dialogView.findViewById(R.id.stockName);
                symbolView.setText(symbol);

                SimpleDateFormat dateFormat;
                if (interval.equals("15m") || interval.equals("30m") || interval.equals("60m")) {
                    dateFormat = new SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault());
                } else {
                    dateFormat = new SimpleDateFormat("MMM dd", Locale.getDefault());
                }

                // Convert timestamps to more readable format (e.g., month-year)
                List<String> xAxisLabels = new ArrayList<>();
                for (Long timestamp : timestamps) {
                    xAxisLabels.add(dateFormat.format(new Date(timestamp * 1000))); // Convert seconds to milliseconds
                }

                for (int i = 0; i < timestamps.size(); i++) {
                    entries.add(new Entry(i, volume.get(i).floatValue())); // Use index for x-axis
                }

                LineDataSet dataSet = new LineDataSet(entries, "Stock Volume");
                LineData lineData = new LineData(dataSet);

                // Customize chart appearance
                XAxis xAxis = lineChartVolume.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setGranularity(1f); // Only show whole numbers on x-axis
                xAxis.setLabelRotationAngle(-45f); // Rotate labels for better readability

                YAxis yAxisLeft = lineChartVolume.getAxisLeft();
                yAxisLeft.setGranularity(10f); // Set y-axis granularity

                lineChartVolume.getDescription().setEnabled(false); // Hide description
                lineChartVolume.getLegend().setEnabled(false); // Hide legend

                lineChartVolume.setData(lineData);
                lineChartVolume.invalidate();

                // Find the close button and set a click listener
                Button closeButton = dialogView.findViewById(R.id.OkBtn);
                closeButton.setOnClickListener(v -> dialog.dismiss());

                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();
            } else {
                Log.e("ChartActivity", "Invalid or incomplete chart data received.");
                Toast.makeText(ChartActivity.this, "Invalid or incomplete chart data received.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayChart(ChartResponse chartResponse) {
        List<Entry> entries = new ArrayList<>();

        if (chartResponse.getChart() != null &&
                chartResponse.getChart().getResult() != null &&
                !chartResponse.getChart().getResult().isEmpty() &&
                chartResponse.getChart().getResult().get(0).getTimestamp() != null &&
                chartResponse.getChart().getResult().get(0).getIndicators() != null &&
                chartResponse.getChart().getResult().get(0).getIndicators().getQuote() != null &&
                !chartResponse.getChart().getResult().get(0).getIndicators().getQuote().isEmpty() &&
                chartResponse.getChart().getResult().get(0).getIndicators().getQuote().get(0).getClose() != null) {

            List<Long> timestamps = chartResponse.getChart().getResult().get(0).getTimestamp();
            List<Double> closes = chartResponse.getChart().getResult().get(0).getIndicators().getQuote().get(0).getClose();

            SimpleDateFormat dateFormat;
            if (interval.equals("15m") || interval.equals("30m") || interval.equals("60m")) {
                dateFormat = new SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault());
            } else {
                dateFormat = new SimpleDateFormat("MMM dd", Locale.getDefault());
            }

            // Convert timestamps to more readable format (e.g., month-year)
            List<String> xAxisLabels = new ArrayList<>();
            for (Long timestamp : timestamps) {
                xAxisLabels.add(dateFormat.format(new Date(timestamp * 1000))); // Convert seconds to milliseconds
            }

            for (int i = 0; i < timestamps.size(); i++) {
                entries.add(new Entry(i, closes.get(i).floatValue())); // Use index for x-axis
            }

            LineDataSet dataSet = new LineDataSet(entries, "Stock Prices");
            LineData lineData = new LineData(dataSet);

            // Customize chart appearance
            XAxis xAxis = lineChart.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setGranularity(1f); // Only show whole numbers on x-axis
            xAxis.setLabelRotationAngle(-45f); // Rotate labels for better readability

            YAxis yAxisLeft = lineChart.getAxisLeft();
            yAxisLeft.setGranularity(10f); // Set y-axis granularity

            lineChart.getDescription().setEnabled(false); // Hide description
            lineChart.getLegend().setEnabled(false); // Hide legend

            lineChart.setData(lineData);
            lineChart.invalidate();
        } else {
            Log.e("ChartActivity", "Invalid or incomplete chart data received.");
            Toast.makeText(ChartActivity.this, "Invalid or incomplete chart data received.", Toast.LENGTH_SHORT).show();
        }
    }
}
