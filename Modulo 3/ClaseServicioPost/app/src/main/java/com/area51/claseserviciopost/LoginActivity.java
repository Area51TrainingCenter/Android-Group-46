package com.area51.claseserviciopost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsuario;
    private EditText etContrasena;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = etUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();

                MetodoWS metodoWS = Configuracion.obtenerConfiguracion()
                        .create(MetodoWS.class);
                Call<LoginResponse> call = metodoWS.validarLogin(
                        "2", usuario, contrasena
                );
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call,
                                           Response<LoginResponse> response) {
                        LoginResponse resultado = response.body();
                        Toast.makeText(LoginActivity.this,
                                resultado.getDesRpta(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this,
                                "error->" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
