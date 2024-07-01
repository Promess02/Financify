package mikolaj.michalczyk.finance.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import mikolaj.michalczyk.finance.R;

class StockViewHolder extends RecyclerView.ViewHolder {

    final TextView exchange;
    final TextView shortname;
    final TextView symbol;
    final TextView longname;
    final Button chooseBtn;

    public StockViewHolder(@NonNull View itemView) {
        super(itemView);
        exchange = itemView.findViewById(R.id.exchange);
        shortname = itemView.findViewById(R.id.shortname);
        symbol = itemView.findViewById(R.id.symbol);
        longname = itemView.findViewById(R.id.longname);
        chooseBtn = itemView.findViewById(R.id.chooseBtn);
    }
}