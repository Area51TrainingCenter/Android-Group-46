package com.area51.clase03.fragmentos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.area51.clase03.MetodoSQL;
import com.area51.clase03.R;
import com.area51.clase03.entidades.Marca;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarMarcaFragment extends Fragment {
    private AppCompatEditText etNombre;
    private AppCompatButton btnAgregar;
    private TextInputLayout tilNombre;

    public AgregarMarcaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("Agregar Marca");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar_marca, container, false);

        etNombre = view.findViewById(R.id.etNombre);
        tilNombre = view.findViewById(R.id.tilNombre);
        btnAgregar = view.findViewById(R.id.btnAgregar);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = etNombre.getText().toString();

                if (nombre.equals("")) {
                    tilNombre.setError("El campo es requerido");
                    return;
                } else {
                    tilNombre.setError(null);
                }

                Marca marca = new Marca();
                marca.setNombre(nombre);

                MetodoSQL sql = new MetodoSQL();
                Marca respuesta = sql.guardarModificarMarca(marca);
                if (respuesta != null &&
                        respuesta.getId() != null) {
                    Toast.makeText(getActivity(),
                            "Se registro correcto", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),
                            "Ocurrio un error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
