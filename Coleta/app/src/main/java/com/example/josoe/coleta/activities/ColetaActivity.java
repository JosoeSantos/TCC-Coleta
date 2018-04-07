package com.example.josoe.coleta.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.josoe.coleta.R;

public class ColetaActivity extends AppCompatActivity {

    GridView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coleta);
    }

    public void buscarCatador(View view) {
        Intent intent = new Intent(this, BuscaActivity.class);
        startActivity(intent);
    }
}
