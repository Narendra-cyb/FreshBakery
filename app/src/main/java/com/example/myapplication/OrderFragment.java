package com.example.myapplication;

import android.app.DatePickerDialog;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class OrderFragment extends Fragment {

    RecyclerView order_recyclerView;
    private TextInputEditText fromDateEditText;
    private TextInputEditText toDateEditText;
    TextView order_Detail_TxtVw;

    ArrayList<Order_Hist_Model> arrOrder_Histoy = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_order, container, false);


        fromDateEditText = view.findViewById(R.id.from_date_edit_text);
        toDateEditText = view.findViewById(R.id.to_date_edit_text);
        order_Detail_TxtVw = view.findViewById(R.id.view_detailTxtV);
//        // Declaring a string
//        String mString = "View Details";
//
//        // Creating a Spannable String
//        // from the above string
//        SpannableString mSpannableString = new SpannableString(mString);
//
//        // Setting underline style from
//        // position 0 till length of
//        // the spannable string
//        mSpannableString.setSpan(new UnderlineSpan(), 0, mSpannableString.length(), 0);
//
//        // Displaying this spannable
//        // string in TextView
//        order_Detail_TxtVw.setText(mSpannableString);
//
        fromDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(fromDateEditText);
            }
        });

        toDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(toDateEditText);
            }
        });

        order_recyclerView = view.findViewById(R.id.order_recyclerView);
        order_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        arrOrder_Histoy.add(new Order_Hist_Model("30.04.2022","9:00 A.M","SAI BAKERY","Qty-3","Rs 5000"));
        arrOrder_Histoy.add(new Order_Hist_Model("30.04.2022","9:00 A.M","SAI narendra","Qty-3","Rs 5000"));
        arrOrder_Histoy.add(new Order_Hist_Model("30.04.2022","9:00 A.M","SAI BAKERY","Qty-3","Rs 5000"));

        RecyclerOrderHAdapter recyclerOrderHAdapter = new RecyclerOrderHAdapter(arrOrder_Histoy,getContext());

        order_recyclerView.setAdapter(recyclerOrderHAdapter);

        return view;
    }

    private void showDatePickerDialog(final TextInputEditText editText) {
        // Get the current date to set as the default date in the dialog
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Create the date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Format the selected date as a string and set it in the EditText
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                        calendar.set(year, month, dayOfMonth);
                        String formattedDate = sdf.format(calendar.getTime());
                        editText.setText(formattedDate);
                    }
                }, year, month, dayOfMonth);

        // Show the dialog
        datePickerDialog.show();
    }


}