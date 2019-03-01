package com.area51.clase03.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.area51.clase03.MetodoSQL;
import com.area51.clase03.R;
import com.area51.clase03.entidades.Usuario;

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

                String usuario = etUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();

                MetodoSQL metodoSQL = new MetodoSQL();
                Usuario resultado = metodoSQL.validarUsuario(usuario, contrasena);
                if (resultado != null) {

                    //Crear sesión
                    SharedPreferences.Editor editor =
                            getSharedPreferences("clase_android", MODE_PRIVATE).edit();
                    editor.putString("id", resultado.getId());
                    editor.putString("nombre", resultado.getNombre());
                    editor.putString("apellido", resultado.getApellido());
                    editor.putString("edad", resultado.getEdad());
                    editor.putString("genero", resultado.getGenero());
                    editor.putBoolean("administrador", resultado.isAdministrador());
                    editor.apply();

                    Intent intent =
                            new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginActivity.this,
                            "Usuario y/o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }

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
