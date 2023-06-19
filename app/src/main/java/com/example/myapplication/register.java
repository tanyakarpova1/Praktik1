package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void onCancel_click(View v) { finish(); }

    public void onOk_click(View v)
    {
        EditText txt_user = findViewById(R.id.reg_user);
        EditText txt_password = findViewById(R.id.reg_password);

        String args = "?name=" + txt_user.getText().toString()
                +"&secret=" + txt_password.getText().toString();

        new ApiCall(this, "PUT", "account" + args)
        {
            public void on_ready(String result) {finish();}

            public void on_fail()
            {

            }
        };
    }
}
