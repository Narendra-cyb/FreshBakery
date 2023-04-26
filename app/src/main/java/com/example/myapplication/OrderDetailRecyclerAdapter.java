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

public class OrderDetailRecyclerAdapter extends RecyclerView.Adapter<OrderDetailRecyclerAdapter.ViewHolder> {


    ArrayList<Order_Hist_Model> arrOrderHistory;
    Context context;

    public OrderDetailRecyclerAdapter(ArrayList<Order_Hist_Model> arrOrderHistory, Context context) {
        this.arrOrderHistory = arrOrderHistory;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderDetailRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_details_item,parent,false);

       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailRecyclerAdapter.ViewHolder holder, int position) {
        holder.nameTxt.setText(arrOrderHistory.get(position).order_Name);
        holder.qtyTxt.setText(arrOrderHistory.get(position).order_Qnt);
        holder.priceTxt.setText(arrOrderHistory.get(position).order_Price);


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

            nameTxt = itemView.findViewById(R.id.detail_name);
            qtyTxt = itemView.findViewById(R.id.detail_quantity);
            priceTxt = itemView.findViewById(R.id.detail_price);
        }
    }
}
