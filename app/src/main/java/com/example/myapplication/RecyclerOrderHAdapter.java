package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerOrderHAdapter extends RecyclerView.Adapter<RecyclerOrderHAdapter.ViewHolder> {


    ArrayList<Order_Hist_Model> arrOrderHistory;
    Context context;

    public RecyclerOrderHAdapter(ArrayList<Order_Hist_Model> arrOrderHistory, Context context) {
        this.arrOrderHistory = arrOrderHistory;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerOrderHAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_hisory_items,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerOrderHAdapter.ViewHolder holder, int position) {
        holder.dateTxt.setText(arrOrderHistory.get(position).order_Date);
        holder.nameTxt.setText(arrOrderHistory.get(position).order_Name);
        holder.timeTxt.setText(arrOrderHistory.get(position).order_Time);
        holder.priceTxt.setText(arrOrderHistory.get(position).order_Price);
        holder.qtyTxt.setText(arrOrderHistory.get(position).order_Qnt);

        // Declaring a string
        String mString = "View Details";

        // Creating a Spannable String
        // from the above string
        SpannableString mSpannableString = new SpannableString(mString);

        // Setting underline style from
        // position 0 till length of
        // the spannable string
        mSpannableString.setSpan(new UnderlineSpan(), 0, mSpannableString.length(), 0);

        // Displaying this spannable
        // string in TextView
        holder.viewdetails.setText(mSpannableString); // Set the text for the viewdetails TextView

        holder.viewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, String.valueOf(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ViewDetaisActivity.class);
                intent.putExtra("position", holder.getAdapterPosition()); // pass any data you want
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.v("Array size",String.valueOf(arrOrderHistory.size()));
        return arrOrderHistory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateTxt,timeTxt,nameTxt,qtyTxt,priceTxt,viewdetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTxt = itemView.findViewById(R.id.oder_name);
            dateTxt = itemView.findViewById(R.id.oder_date);
            timeTxt = itemView.findViewById(R.id.oder_time);
            qtyTxt = itemView.findViewById(R.id.order_quantity);
            priceTxt = itemView.findViewById(R.id.order_price);
            viewdetails = itemView.findViewById(R.id.view_detailTxtV);
        }
    }
}
