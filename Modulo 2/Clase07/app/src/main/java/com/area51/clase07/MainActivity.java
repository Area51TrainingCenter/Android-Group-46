package com.area51.clase07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.area51.clase07.response.ObtenerSedesResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMapa = findViewById(R.id.btnUbicacion);

        MetodoWS metodoWS = HelperWS.obtenerConfiguracion()
                .create(MetodoWS.class);

        Call<ObtenerSedesResponse> call =
                metodoWS.obtenerSedes();
        call.enqueue(new Callback<ObtenerSedesResponse>() {
            @Override
            public void onResponse(Call<ObtenerSedesResponse> call,
                                   Response<ObtenerSedesResponse> response) {

                //response.headers();
                ObtenerSedesResponse resultado = response.body();
                Log.d("WebService", new Gson().toJson(resultado));
            }

            @Override
            public void onFailure(Call<ObtenerSedesResponse> call,
                                  Throwable t) {
                if ((HttpException) t != null) {
                    switch (((HttpException) t).code()) {
                        case 400:
                            Log.d("", "onError: BAD REQUEST");
                        case 401:
                            Log.d("", "onError: NOT AUTHORIZED");
                        case 403:
                            Log.d("", "onError: FORBIDDEN");
                        case 404:
                            Log.d("", "onError: NOT FOUND");
                        case 500:
                            Log.d("", "onError: INTERNAL SERVER ERROR");
                        case 502:
                            Log.d("", "onError: BAD GATEWAY");
                    }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(MainActivity.this,
                                MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
