package com.area51.clase03.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.area51.clase03.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        TimerTask task =
                new TimerTask() {
                    @Override
                    public void run() {

                        Intent intent = null;

                        //Validación de que se va a hacer después de finalizado el tiempo
                        SharedPreferences preferences =
                                getSharedPreferences("clase_android", MODE_PRIVATE);
                        if (preferences.contains("id")) {
                            intent =
                                    new Intent(SplashActivity.this,
                                            MenuActivity.class);
                            String nombre = preferences.getString("nombre", "");

                            intent.putExtra("v_nombre", nombre);
                            intent.putExtra("v_apellido", preferences.getString("apellido", ""));
                            intent.putExtra("v_edad", preferences.getString("edad", ""));
                            intent.putExtra("v_genero", preferences.getString("genero", ""));
                            intent.putExtra("v_administrador",
                                    preferences.getBoolean("administrador", false));
                        } else {
                            intent =
                                    new Intent(SplashActivity.this,
                                            LoginActivity.class);
                        }
                        startActivity(intent);
                        finish();

                    }
                };
        Timer timer = new Timer();
        timer.schedule(task, 2000);

    }

}
