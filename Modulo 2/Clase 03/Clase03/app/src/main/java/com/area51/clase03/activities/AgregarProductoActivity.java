package com.area51.clase03.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.area51.clase03.MetodoSQL;
import com.area51.clase03.R;
import com.area51.clase03.entidades.Marca;
import com.area51.clase03.entidades.Producto;

import java.util.ArrayList;

import io.realm.RealmResults;

public class AgregarProductoActivity extends AppCompatActivity {
    private AppCompatSpinner spMarca;
    private AppCompatEditText etNombre, etModelo, etColor;
    private AppCompatButton btnAgregar;
    private RealmResults<Marca> marcas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Agregar Producto");

        spMarca = findViewById(R.id.spMarca);
        etNombre = findViewById(R.id.etNombre);
        etModelo = findViewById(R.id.etModelo);
        etColor = findViewById(R.id.etColor);
        btnAgregar = findViewById(R.id.btnAgregar);

        MetodoSQL sql = new MetodoSQL();
        marcas = sql.obtenerMarcas();

        ArrayList<String> lista = new ArrayList<>();
        for (Marca item : marcas) {
            lista.add(item.getNombre());
        }
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                lista
        );
        spMarca.setAdapter(adapter);
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

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String marca = spMarca.getSelectedItem().toString();
                String nombre = etNombre.getText().toString();
                String modelo = etModelo.getText().toString();
                String color = etColor.getText().toString();

                Producto producto = new Producto();
                producto.setColor(color);
                producto.setModelo(modelo);
                producto.setNombre(nombre);
                for (Marca item : marcas) {
                    if (item.getNombre().equals(marca)) {
                        producto.setMarca(item);
                        break;
                    }
                }

                MetodoSQL sql = new MetodoSQL();
                Producto resultado = sql.guardarModificarProducto(producto);
                if (resultado != null && resultado.getId() != null) {
                    Toast.makeText(AgregarProductoActivity.this,
                            "Se registro", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AgregarProductoActivity.this,
                            "Ocurrio un error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
