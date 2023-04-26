package com.example.myapplication;

import android.widget.TextView;

public class Recycler_Model {
    String name,price;
    int spinnerSelection;

    public Recycler_Model(String name, String price, int spinnerSelection) {
        this.name = name;
        this.price = price;
        this.spinnerSelection = spinnerSelection;
    }
}
