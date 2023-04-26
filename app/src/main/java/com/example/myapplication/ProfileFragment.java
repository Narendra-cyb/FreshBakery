package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;


public class ProfileFragment extends Fragment {

    private TextInputEditText editText1, editText2, editText3,editText4;
    private Button editButton, updateButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        editText1 = view.findViewById(R.id.edit_text_1);
        editText2 = view.findViewById(R.id.edit_text_2);
        editText3 = view.findViewById(R.id.edit_text_3);
        editText4 = view.findViewById(R.id.edit_text_4);


        editButton = view.findViewById(R.id.edit_button);
        updateButton = view.findViewById(R.id.update_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setEnabled(true);
                editText2.setEnabled(true);
                editText4.setEnabled(true);
                editText3.setEnabled(true);
                updateButton.setVisibility(View.VISIBLE);
            }
        });


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();

                // Save the updated values to a database or server
                // ...

                editText1.setText(text1);
                editText2.setText(text2);
                editText3.setText(text3);

                editText1.setEnabled(false);
                editText2.setEnabled(false);
                editText3.setEnabled(false);
                editText4.setEnabled(false);
                updateButton.setVisibility(View.INVISIBLE);
            }
        });

        return view;
    }
}
