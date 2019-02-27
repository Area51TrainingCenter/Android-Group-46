package com.area51.clase03.activities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.area51.clase03.R;
import com.area51.clase03.entidades.Marca;

public class RegistroActivity extends AppCompatActivity {
    private TextInputLayout tilUsuario, tilNombre, tilApellido, tilContrasena,
            tilRepetirContrasena;
    private AppCompatEditText etUsuario, etNombre, etApellido, etContrasena, etRepetirContrasena;
    private RadioButton rbMasculino, rbFemenino;
    private AppCompatCheckBox cbAdministrador;
    private AppCompatButton btnRegistro;
    private Spinner spEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tilUsuario = findViewById(R.id.tilUsuario);
        tilNombre = findViewById(R.id.tilNombre);
        tilApellido = findViewById(R.id.tilApellido);
        tilContrasena = findViewById(R.id.tilContrasena);
        tilRepetirContrasena = findViewById(R.id.tilRepContrasena);
        etUsuario = findViewById(R.id.etUsuario);
        etNombre = findViewById(R.id.etNombre);
        etContrasena = findViewById(R.id.etContrasena);
        etRepetirContrasena = findViewById(R.id.etRepContrasena);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        cbAdministrador = findViewById(R.id.cbAdministrador);
        btnRegistro = findViewById(R.id.btnRegistrar);
        spEdad = findViewById(R.id.spEdad);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = etUsuario.getText().toString();
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String edad = spEdad.getSelectedItem().toString();
                String genero = rbMasculino.isChecked() ? "Masculino" :
                        (rbFemenino.isChecked() ? "Femenino" : "");
                String contrasena = etContrasena.getText().toString();
                String repContrasena = etRepetirContrasena.getText().toString();
                boolean administrador = cbAdministrador.isChecked();



            }
        });
    }
}
