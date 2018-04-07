package com.example.josoe.coleta.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.josoe.coleta.R;

public class MainActivity extends AppCompatActivity {

    String[] putExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isOnline()) {
            Context context = MainActivity.this;
            Toast.makeText(context, "Device not connected", Toast.LENGTH_LONG).show();
        }
        putExtra = new String[]{"https://www.example.com", "json", "MainActivity"};
    }

    public void onLoginClicked(View view) {
        Toast.makeText(this, "Login clicado", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void catadorClicked(View view) {
        Intent intent = new Intent(this, CatadorMainActivity.class);
        startActivity(intent);
    }


    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
