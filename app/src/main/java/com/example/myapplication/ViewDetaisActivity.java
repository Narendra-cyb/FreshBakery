package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ViewDetaisActivity extends AppCompatActivity {


    RecyclerView detail_recyclerview;
    ArrayList<Order_Hist_Model> arrDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detais);


        // Add back button in Toolbar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

// Set toolbar click listener to navigate back
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




        detail_recyclerview = findViewById(R.id.detail_recyclerview);

        detail_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        arrDetails.add(new Order_Hist_Model("30.04.2022","9:00 A.M","SAI BAKERY","Qty-1","Rs 2500"));
        arrDetails.add(new Order_Hist_Model("30.04.2022","9:00 A.M","SAI BAKERY","Qty-1","Rs 2500"));
        OrderDetailRecyclerAdapter recyclerOrderHAdapter = new OrderDetailRecyclerAdapter(arrDetails,this);

        detail_recyclerview.setAdapter(recyclerOrderHAdapter);
    }
}
