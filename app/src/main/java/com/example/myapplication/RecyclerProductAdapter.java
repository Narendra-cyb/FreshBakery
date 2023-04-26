package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerProductAdapter extends RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder> {

    ArrayList<Recycler_Model> arrProducts;
    Context context;

    public RecyclerProductAdapter(Context context, ArrayList<Recycler_Model> arrProducts) {
        this.arrProducts = arrProducts;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemName.setText(arrProducts.get(position).name);
        holder.itemPrice.setText(arrProducts.get(position).price);

        // Set up the dropdown (Spinner)
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(holder.itemView.getContext(),
                R.layout.spinner_layout,
                new String[]{"1", "2", "3"});
        holder.itemQuantity.setAdapter(spinnerAdapter);

        // Add an OnItemSelectedListener to the spinner
        holder.itemQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Handle spinner selection events here
                String selectedOption = adapterView.getItemAtPosition(i).toString();
                Log.d("TAG", "Selected option: " + selectedOption);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle case where nothing is selected
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName, itemPrice;
        Spinner itemQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemQuantity = itemView.findViewById(R.id.item_quantity);
        }
    }
}
