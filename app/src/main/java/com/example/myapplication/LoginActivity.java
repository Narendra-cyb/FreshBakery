package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout userLayout, passLayout;
    TextInputEditText userEditText, passwordEditText;
    AppCompatButton submit;

    private static final String CORRECT_USERNAME = "bakery";
    private static final String CORRECT_PASSWORD = "bakery";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        userLayout = findViewById(R.id.username_layout);
        passLayout = findViewById(R.id.password_layout);

        userEditText = findViewById(R.id.username_edt);
        passwordEditText = findViewById(R.id.password_edt);

        submit = findViewById(R.id.login_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                    // Correct username and password, proceed to the main activity
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Incorrect username and/or password, show an error message
                    Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                    passwordEditText.setError("Password is wrong");
                }
            }
        });
    }
}
