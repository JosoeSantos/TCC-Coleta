package com.example.josoe.tcc;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.josoe.tcc.utilites.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    ProgressBar myProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void setLoginCommon(View view) {
        setContentView(R.layout.fragment_login_usuario_comum);
    }

    public void startMapsActivity(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public class BuscaCepClass extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... params) {
            myProgress.setVisibility(View.VISIBLE);
            URL searchUrl = params[0];
            String githubSearchResults = null;
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String result) {
            myProgress.setVisibility(View.INVISIBLE);
            if (result != null && !result.equals("")) {
                moontaEndereco(result);
            } else {
                showErrorMessage();
            }
        }
    }

    void showErrorMessage() {
        Context context = LoginActivity.this;
        Toast.makeText(context, "Erro ao busar cep, tente novamente", Toast.LENGTH_LONG);
    }

    void moontaEndereco(String json) {
        JSONObject jsonObject = null;
        String resultado = "";
        try {
            jsonObject = new JSONObject(json);
            resultado += jsonObject.getString("logradouro");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
