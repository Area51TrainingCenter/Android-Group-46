package com.area51.clase03_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaDosActivity extends AppCompatActivity {
    private TextView texto;
    private Button volver, continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_dos);

        texto = (TextView) findViewById(R.id.tvTexto);
        volver = (Button) findViewById(R.id.btnVolver);
        continuar = (Button) findViewById(R.id.btnContinuar);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String genero = getIntent().getStringExtra("genero");

        texto.setText("Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nGenero: " + genero);
    }

    @Override
    protected void onResume() {
        super.onResume();

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

                //finish();
            }
        });
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =
                        new Intent(
                                PantallaDosActivity.this,
                                PantallaTresActivity.class);
                startActivity(intent);

            }
        });
    }
}
