package com.example.josoe.coleta.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.josoe.coleta.R;

public class LoadingActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_actvity);
        Intent intent = getIntent();
        String[] ntencions = intent.getStringArrayExtra("OQBuscar");
        //fazer alguma coisa com esse Array

    }

    public void getJSON() {
        //alguma função para buscar JSON
    }


}
