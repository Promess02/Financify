package mikolaj.michalczyk.finance.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mikolaj.michalczyk.finance.ChartActivity;
import mikolaj.michalczyk.finance.MainActivity;
import mikolaj.michalczyk.finance.model.Quote;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import mikolaj.michalczyk.finance.R;
import mikolaj.michalczyk.finance.model.Stock;
import mikolaj.michalczyk.finance.model.StockList;

public class StockAdapter extends RecyclerView.Adapter<StockViewHolder> {

    private StockList stockList;
    private final Context context;
    private final OnStockClickListener onStockClickListener;

    public interface OnStockClickListener {
        void onStockClick(Quote quote);
    }

    public StockAdapter(Context context, OnStockClickListener onStockClickListener) {
        this.context = context;
        this.onStockClickListener = onStockClickListener;
    }

    public void setStockList(StockList stockList) {
        this.stockList = stockList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stock_card, parent, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        Quote stock = stockList.getQuotes().get(position);
        holder.exchange.setText(stock.getExchange());
        holder.shortname.setText(stock.getShortname());
        holder.symbol.setText(stock.getSymbol());
        holder.longname.setText(stock.getLongname());
        holder.chooseBtn.setOnClickListener(v -> onStockClickListener.onStockClick(stock));
    }

    @Override
    public int getItemCount() {
        return stockList != null ? stockList.getQuotes().size() : 0;
    }

}
