package com.area51.clase03_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, apellido;
    private RadioButton masculino, femenino;
    private CheckBox terminos;
    private Button procesar, siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
        masculino = (RadioButton) findViewById(R.id.rbMasculino);
        femenino = (RadioButton) findViewById(R.id.rbFemenino);
        terminos = (CheckBox) findViewById(R.id.cbTerminos);
        procesar = (Button) findViewById(R.id.btnProcesar);
        siguiente = (Button) findViewById(R.id.btnSiguiente);
    }

    @Override
    protected void onResume() {
        super.onResume();

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Se indica en que activity estamos y a que activity vamos
                Intent intent =
                        new Intent(MainActivity.this,
                                PantallaDosActivity.class);

                String valorNombre = nombre.getText().toString();
                String valorApellido = apellido.getText().toString();
                String genero = masculino.isChecked() ? "Masculino" :
                        (femenino.isChecked() ? "Femenino" : "");

                //Agregamos los datos que vamos a enviar a la siguiente pantalla
                intent.putExtra("nombre", valorNombre);
                intent.putExtra("apellido", valorApellido);
                intent.putExtra("genero", genero);

                startActivity(intent);

            }
        });

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valorNombre = nombre.getText().toString();
                String valorApellido = apellido.getText().toString();
                String genero = masculino.isChecked() ? "Masculino" :
                        (femenino.isChecked() ? "Femenino" : "");
                boolean valorTermino = terminos.isChecked();

                if (!valorNombre.equals("") &&
                        !valorApellido.equals("") &&
                        !genero.equals("") &&
                        valorTermino) {
                    //Caso positivo
                    Toast.makeText(MainActivity.this,
                            "Nombre: " + valorNombre +
                                    "\nApellido: " + valorApellido +
                                    "\nGenero: " + genero +
                                    "\nTérminos: " + valorTermino,
                            Toast.LENGTH_LONG).show();
                } else {
                    //Caso negativo
                    Toast.makeText(MainActivity.this,
                            "Debe de completar todos los datos",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
