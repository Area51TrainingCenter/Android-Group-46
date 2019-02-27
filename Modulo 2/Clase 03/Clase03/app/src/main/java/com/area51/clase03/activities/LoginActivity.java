package com.area51.clase03.activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;

import com.area51.clase03.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout tilUsuario, tilContrasena;
    private AppCompatEditText etUsuario, etContrasena;
    private TextView tvRegistrarAhora;
    private AppCompatButton btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilUsuario = findViewById(R.id.tilUsuario);
        tilContrasena = findViewById(R.id.tilContrasena);
        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        tvRegistrarAhora = findViewById(R.id.tvRegistrar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tvRegistrarAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(LoginActivity.this,
                                RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
