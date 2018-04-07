package com.example.josoe.coleta.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.josoe.coleta.ListaEnderecoActivity;
import com.example.josoe.coleta.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClicked(View view) {
        Context context = LoginActivity.this;
        Intent intent = new Intent(context, ListaEnderecoActivity.class);
        startActivity(intent);
    }
}
