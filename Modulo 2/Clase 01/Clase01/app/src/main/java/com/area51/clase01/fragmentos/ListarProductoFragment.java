package com.area51.clase01.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.area51.clase01.R;
import com.area51.clase01.adapter.ProductoAdapter;
import com.area51.clase01.modelos.Producto;
import com.area51.clase01.sqlite.MetodoSQLite;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarProductoFragment extends Fragment {
    private ProductoAdapter adapter;
    private ArrayList<Producto> lista;
    private RecyclerView rvProductos;

    public ListarProductoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_producto, container, false);

        rvProductos = (RecyclerView) view.findViewById(R.id.rvProductos);

        MetodoSQLite sqLite = new MetodoSQLite(getContext());
        lista = sqLite.obtenerProductos();

        adapter = new ProductoAdapter(lista, getContext());
        rvProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvProductos.setAdapter(adapter);

        return view;
    }

}
