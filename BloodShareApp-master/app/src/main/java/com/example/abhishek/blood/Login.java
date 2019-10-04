package com.example.abhishek.blood;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText input_email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        input_email = findViewById(R.id.input_email);
        input_email.setTextColor(R.color.whiteText);

    }
}
