package com.area51.clase06.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.area51.clase06.R;
import com.area51.clase06.activities.MainActivity;
import com.area51.clase06.activities.MenuActivity;
import com.area51.clase06.adapters.ProductoAdapter;
import com.area51.clase06.modelos.Producto;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {
    private ListView lvLista;
    private ProductoAdapter adapter;

    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        lvLista = (ListView) view.findViewById(R.id.lvLista);


        ArrayList<Producto> lista = ((MenuActivity) getActivity()).obtenerLista();
        adapter = new ProductoAdapter(lista);
        lvLista.setAdapter(adapter);

        return view;
    }

}
