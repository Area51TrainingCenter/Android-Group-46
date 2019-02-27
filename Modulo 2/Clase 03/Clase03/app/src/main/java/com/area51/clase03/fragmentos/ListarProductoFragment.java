package com.area51.clase03.fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.area51.clase03.MetodoSQL;
import com.area51.clase03.R;
import com.area51.clase03.activities.AgregarProductoActivity;
import com.area51.clase03.activities.MenuActivity;
import com.area51.clase03.adapter.ProductoAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarProductoFragment extends Fragment {
    private ProductoAdapter adapter;
    private RecyclerView rvProductos;
    private FloatingActionButton fab;

    public ListarProductoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("Listar Productos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_producto, container, false);

        rvProductos = view.findViewById(R.id.rvProductos);
        fab = view.findViewById(R.id.fab);

        adapter = new ProductoAdapter(getContext());
        rvProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvProductos.setAdapter(adapter);

        return view;
    }
    //Job Scheduled
    //Service
    //Broadcast Receiver
    @Override
    public void onStart() {
        super.onStart();

        MetodoSQL sql = new MetodoSQL();
        adapter.agregar(sql.obtenerProductos());
    }

    @Override
    public void onResume() {
        super.onResume();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =
                        new Intent(getActivity(), AgregarProductoActivity.class);
                startActivity(intent);

            }
        });
    }
}
