package com.area51.clase04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/*
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
*/
public class MainActivity extends AppCompatActivity {
    /*
    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.etApellido)
    EditText etApellido;
    @BindView(R.id.spGenero)
    Spinner spGenero;
    @BindView(R.id.lvLista)
    ListView lvLista;
*/
    EditText etNombre;
    EditText etApellido;
    Spinner spGenero;
    ListView lvLista;
    Button btnRegistrar;
    private PersonaAdapter adapter;
    private int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        spGenero = (Spinner) findViewById(R.id.spGenero);
        lvLista = (ListView) findViewById(R.id.lvLista);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        adapter = new PersonaAdapter();
        lvLista.setAdapter(adapter);

        //GridView ViewPager
        ArrayAdapter arrayAdapter =
                new ArrayAdapter(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        getResources().getStringArray(R.array.generos));
        spGenero.setAdapter(arrayAdapter);

        btnRegistrar.setTag(false);

    }
/*
    @OnClick(R.id.btnRegistrar)
    public void onViewClicked() {

    }
    */

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtenemos los valores
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String genero = spGenero.getSelectedItem().toString();

                //Validamos que los campos esten llenos
                //Mostramos mensaje en caso haya error
                if (nombre.equals("")) {
                    Toast.makeText(MainActivity.this, "Completar campo de nombre",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                if (apellido.equals("")) {
                    Toast.makeText(MainActivity.this, "Completar campo de apellido",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                //Guardamos datos en objeto
                Persona persona = new Persona();
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setGenero(genero);

                if ((boolean) btnRegistrar.getTag()) {
                    //Actualizar true

                    adapter.actualizarDato(persona, posicion);

                    Toast.makeText(MainActivity.this,
                            "Se actualizo correcto",
                            Toast.LENGTH_SHORT).show();

                    limpiarDatos();

                    btnRegistrar.setTag(false);
                    posicion = 0;
                    btnRegistrar.setText("Registrar");

                } else {
                    //Registrar false

                    //Mostrarmos mensaje de confirmación
                    Toast.makeText(MainActivity.this, "Se registro.",
                            Toast.LENGTH_SHORT).show();

                    //Mostramos en la lista
                    adapter.agregar(persona);
                }
            }
        });
    }

    public void limpiarDatos() {
        etNombre.setText("");
        etApellido.setText("");
        spGenero.setSelection(0);

        etNombre.requestFocus();
    }

    public void cargarDatos(Persona persona, int posicion) {
        etNombre.setText(persona.getNombre());
        etApellido.setText(persona.getApellido());

        String[] datoGenero = getResources().getStringArray(R.array.generos);
        for (int i = 0; i < datoGenero.length; i++) {
            if (datoGenero[i].equals(persona.getGenero()))
                spGenero.setSelection(i);
        }

        btnRegistrar.setTag(true);
        btnRegistrar.setText("Actualizar");

        this.posicion = posicion;
    }
}
