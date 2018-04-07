package com.example.josoe.coleta.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.josoe.coleta.R;

public class CatadorMainActivity extends AppCompatActivity {
    boolean registrando;

    Button loginButton;
    EditText confirmeEditText;
    EditText nomeEditText;
    EditText ongEditText;
    EditText telefoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catador_main);
        loginButton = findViewById(R.id.buttonLogin);
        confirmeEditText = findViewById(R.id.confirme_edit_text);
        nomeEditText = findViewById(R.id.nome_edit_text);
        ongEditText = findViewById(R.id.ong_edit_text);
        telefoneEditText = findViewById(R.id.telefone_edit_text);
        registrando = false;
    }

    public void onRegisterClicked(View view) {
        if (!registrando) {
            loginButton.setVisibility(View.GONE);
            confirmeEditText.setVisibility(View.VISIBLE);
            nomeEditText.setVisibility(View.VISIBLE);
            ongEditText.setVisibility(View.VISIBLE);
            telefoneEditText.setVisibility(View.VISIBLE);
            registrando = true;
        }
    }
}
