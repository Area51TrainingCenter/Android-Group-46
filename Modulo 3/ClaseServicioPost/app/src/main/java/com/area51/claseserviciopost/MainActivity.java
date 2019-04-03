package com.area51.claseserviciopost;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etCodPersona,
            etTipDoc,
            etNumDoc,
            etPass,
            etPrimerNombre,
            etSegundoNombre,
            etApellidoPaterno,
            etApellidoMaterno,
            etFlagSexo,
            etFecNac,
            etTelFijo,
            etTelCel,
            etEmail,
            etDesDirec,
            etFlagPubli,
            etMaqId,
            etOpcion,
            etOrigen;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodPersona = findViewById(R.id.etCodPersona);
        etTipDoc = findViewById(R.id.etTipoDocumento);
        etNumDoc = findViewById(R.id.etNumeroDocumento);
        etPass = findViewById(R.id.etPass);
        etPrimerNombre = findViewById(R.id.etPrimerNombre);
        etSegundoNombre = findViewById(R.id.etSegundoNombre);
        etApellidoPaterno = findViewById(R.id.etApellidoPaterno);
        etApellidoMaterno = findViewById(R.id.etApellidoMaterno);
        etFlagSexo = findViewById(R.id.etFlagSexo);
        etFecNac = findViewById(R.id.etFecNac);
        etTelFijo = findViewById(R.id.etTelefonoFijo);
        etTelCel = findViewById(R.id.etTelefonoCel);
        etEmail = findViewById(R.id.etCorreo);
        etDesDirec = findViewById(R.id.etDesDire);
        etFlagPubli = findViewById(R.id.etFlagPubli);
        etMaqId = findViewById(R.id.etMaqId);
        etOpcion = findViewById(R.id.etOpcion);
        etOrigen = findViewById(R.id.etOrigen);
        btnAgregar = findViewById(R.id.btnGuardar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConnectivityManager manager =
                        (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo info = manager.getActiveNetworkInfo();
                if (info != null) {
                    if (info.isConnected()) {
                        //Tiene Internet
                        String codPersona = etCodPersona.getText().toString();
                        String tipoDocumento = etTipDoc.getText().toString();
                        String numeroDocumento = etNumDoc.getText().toString();
                        String pass = etPass.getText().toString();
                        String primerNombre = etPrimerNombre.getText().toString();
                        String segundoNombre = etSegundoNombre.getText().toString();
                        String apellidoPaterno = etApellidoPaterno.getText().toString();
                        String apellidoMaterno = etApellidoMaterno.getText().toString();
                        String flagSexo = etFlagSexo.getText().toString();
                        String fecNac = etFecNac.getText().toString();
                        String telFijo = etTelFijo.getText().toString();
                        String telCel = etTelCel.getText().toString();
                        String email = etEmail.getText().toString();
                        String desDire = etDesDirec.getText().toString();
                        String flagPubli = etFlagPubli.getText().toString();
                        String maqId = etMaqId.getText().toString();
                        String opcion = etOpcion.getText().toString();
                        String origen = etOrigen.getText().toString();

                        MetodoWS metodoWS = Configuracion
                                .obtenerConfiguracion().create(MetodoWS.class);
                        Call<UsuarioResponse> call = metodoWS.registrarUsuario(
                                codPersona,
                                tipoDocumento,
                                numeroDocumento,
                                pass,
                                primerNombre,
                                segundoNombre,
                                apellidoPaterno,
                                apellidoMaterno,
                                flagSexo,
                                fecNac,
                                telFijo,
                                telCel,
                                email,
                                desDire,
                                flagPubli,
                                maqId,
                                opcion,
                                origen
                        );
                        call.enqueue(new Callback<UsuarioResponse>() {
                            @Override
                            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                                UsuarioResponse respuesta = response.body();
                                Toast.makeText(MainActivity.this,
                                        respuesta.getDesRpta(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

                            }
                        });
                    } else {
                        //No tiene internet
                    }
                }
            }
        });
    }
}
