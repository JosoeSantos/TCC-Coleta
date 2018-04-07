package com.example.josoe.coleta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.josoe.coleta.adapters.ListaEnderecosAdapter;

public class ListaEnderecoActivity extends AppCompatActivity {

    RecyclerView enderecosRecyclerView;
    String[] texto = {"Rua Alvares de azevedo, 400, Bel...", "Rua Alvares de azevedo, 401, Bel...", "Casa de barro"};
    String[] ceps = {"35503-882", "35503-882", "00000-001"};
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_endereco);
        enderecosRecyclerView = findViewById(R.id.rv_enderecos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        enderecosRecyclerView.setLayoutManager(layoutManager);
        enderecosRecyclerView.setHasFixedSize(true);
        ListaEnderecosAdapter adapter = new ListaEnderecosAdapter(texto, ceps);
        enderecosRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_enderecos_menu, menu);
        return true;
    }

    public void onDeleteClicked(View view) {
        if (toast != null) {
            toast.cancel();
        }
        toast.makeText(this, "Delete clicado", Toast.LENGTH_LONG).show();
    }

    public void onAddClicked(View view) {
        if (toast != null) {
            toast.cancel();
        }
        toast.makeText(this, "Add clicado", Toast.LENGTH_LONG).show();

    }
}
