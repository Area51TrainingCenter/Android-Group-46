package com.area51.clase01.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.area51.clase01.R;
import com.area51.clase01.modelos.Marca;
import com.area51.clase01.sqlite.MetodoSQLite;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarMarcaFragment extends Fragment {

    private AppCompatButton btnAgregar;
    private AppCompatEditText etNombre;

    public AgregarMarcaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar_marca, container, false);

        btnAgregar = (AppCompatButton) view.findViewById(R.id.btnAgregar);
        etNombre = (AppCompatEditText) view.findViewById(R.id.etNombre);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();

                if (nombre == null || nombre.equals("")) {
                    etNombre.setError("El campo es requerido");
                    return;
                }

                MetodoSQLite sqLite = new MetodoSQLite(getContext());

                Marca marca = new Marca(nombre);
                long resultado = sqLite.registrarMarca(marca);

                if (resultado == 1) {
                    Toast.makeText(getContext(),
                            "Se registro la marca", Toast.LENGTH_SHORT).show();

                    etNombre.setText("");
                    etNombre.requestFocus();
                } else {
                    Toast.makeText(getContext(),
                            "Ocurrio un error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
