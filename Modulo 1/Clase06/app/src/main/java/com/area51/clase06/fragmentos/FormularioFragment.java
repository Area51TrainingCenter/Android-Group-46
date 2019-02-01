package com.area51.clase06.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.area51.clase06.R;
import com.area51.clase06.activities.MenuActivity;
import com.area51.clase06.modelos.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment extends Fragment {

    private EditText etMarca, etModelo, etAnio;
    private Button btnGuardar;


    public FormularioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);

        etMarca = (EditText) view.findViewById(R.id.etMarca);
        etModelo = (EditText) view.findViewById(R.id.etModelo);
        etAnio = (EditText) view.findViewById(R.id.etAnio);
        btnGuardar = (Button) view.findViewById(R.id.btnGuardar);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = etMarca.getText().toString();
                String modelo = etModelo.getText().toString();
                String anio = etAnio.getText().toString();

                Producto producto = new Producto();
                producto.setAnio(anio);
                producto.setMarca(marca);
                producto.setModelo(modelo);

                ((MenuActivity) getActivity()).agregarDato(producto);

                Toast.makeText(getActivity(),
                        "Se registro correcto", Toast.LENGTH_SHORT).show();

                etMarca.setText("");
                etModelo.setText("");
                etAnio.setText("");
                etMarca.requestFocus();
            }
        });
    }
}
