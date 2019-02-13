package com.area51.clase01.fragmentos;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.clase01.R;
import com.area51.clase01.modelos.Marca;
import com.area51.clase01.modelos.Producto;
import com.area51.clase01.sqlite.MetodoSQLite;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarProductoFragment extends Fragment {
    private AppCompatSpinner spMarca;
    private AppCompatEditText etModelo, etColor, etNombre;
    private TextInputLayout tilModelo, tilColor, tilNombre;
    private AppCompatButton btnAgregar;
    ArrayList<Marca> listaMarca;

    public AgregarProductoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar_producto, container, false);

        spMarca = (AppCompatSpinner) view.findViewById(R.id.spMarca);
        etModelo = (AppCompatEditText) view.findViewById(R.id.etModelo);
        etColor = (AppCompatEditText) view.findViewById(R.id.etColor);
        tilNombre = (TextInputLayout) view.findViewById(R.id.etNombre);
        tilModelo = (TextInputLayout) view.findViewById(R.id.tilModelo);
        tilColor = (TextInputLayout) view.findViewById(R.id.tilColor);
        etNombre = (AppCompatEditText) view.findViewById(R.id.tilNombre);
        btnAgregar = (AppCompatButton) view.findViewById(R.id.btnAgregar);

        MetodoSQLite sqLite = new MetodoSQLite(getContext());
        listaMarca = sqLite.obtenerMarcas();
        ArrayList<String> marcaTexto = new ArrayList<>();
        marcaTexto.add("Seleccione");
        for (Marca item : listaMarca) {
            marcaTexto.add(item.getId() + " - " + item.getNombre());
        }
        ArrayAdapter adapter = new ArrayAdapter(
                getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                marcaTexto
        );
        spMarca.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();
                String modelo = etModelo.getText().toString();
                String color = etColor.getText().toString();
                String marca = spMarca.getSelectedItem().toString();

                if (marca.equals("Seleccione")) {
                    Toast.makeText(getContext(),
                            "El campo es requerido", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (nombre.equals("")) {
                    tilNombre.setError("El campo es requerido");
                    return;
                } else {
                    tilNombre.setError(null);
                }

                if (modelo.equals("")) {
                    tilModelo.setError("El campo es requerido");
                    return;
                } else {
                    tilModelo.setError(null);
                }
                if (color.equals("")) {
                    tilColor.setError("El campo es requerido");
                    return;
                } else {
                    tilColor.setError(null);
                }

                MetodoSQLite sqLite = new MetodoSQLite(getContext());
                Producto producto = new Producto();
                producto.setNombre(nombre);
                producto.setModelo(modelo);
                producto.setColor(color);
                producto.setIdMarca(obtenerId(marca));

                sqLite.registrarProducto(producto);
                Toast.makeText(getContext(),
                        "Se registro", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int obtenerId(String nombreMarca) {
        for (Marca item : listaMarca) {
            if (item.getNombre().equals(nombreMarca)) {
                return item.getId();
            }
        }
        return 0;
    }
}
