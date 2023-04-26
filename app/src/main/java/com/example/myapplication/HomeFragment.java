package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    TextView productTextView;
    RecyclerView recyclerView;

    Spinner customer_spinner;

    ArrayList<Recycler_Model> arrProduct = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        productTextView = view.findViewById(R.id.productsTextvw);

        // Declaring a string
        String mString = "Products";

        // Creating a Spannable String
        // from the above string
        SpannableString mSpannableString = new SpannableString(mString);

        // Setting underline style from
        // position 0 till length of
        // the spannable string
        mSpannableString.setSpan(new UnderlineSpan(), 0, mSpannableString.length(), 0);

        // Displaying this spannable
        // string in TextView
        productTextView.setText(mSpannableString);

        customer_spinner = view.findViewById(R.id.customer_spinner);
        // Set up the dropdown (Spinner)
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(view.getContext(),
                R.layout.spinner_customer_name,
                new String[]{"Narendra Sahu", "Jaga Sahu", "Mukundan","Array"});

       customer_spinner.setAdapter(spinnerAdapter);

        //Recycler View
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrProduct.add(new Recycler_Model("Ice Cake","Rs 500",1));
        arrProduct.add(new Recycler_Model("Red Velvet","Rs 500",1));


        RecyclerProductAdapter recyclerProductAdapter = new RecyclerProductAdapter(getContext(),arrProduct);

        recyclerView.setAdapter(recyclerProductAdapter);




        return view;
    }
}