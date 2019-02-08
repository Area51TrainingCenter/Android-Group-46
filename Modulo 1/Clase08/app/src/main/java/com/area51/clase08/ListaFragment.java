package com.area51.clase08;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.area51.clase08.adapter.ProductoAdapter;
import com.area51.clase08.modelos.Producto;

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
        View view = inflater.inflate(R.layout.fragment_lista,
                container, false);

        lvLista = (ListView) view.findViewById(R.id.lvLista);

        ArrayList<Producto> lista = new ArrayList<>();
        Producto producto1 = new Producto();
        producto1.setNombre("Plumón");
        producto1.setDescripcion("Plumón azul");
        producto1.setPrecio(10.0);
        producto1.setPrecioAnterior(12.0);
        producto1.setImagen("https://http2.mlstatic.com/plumon-para-retoque-de-pavon-negro-brillante-birchwood-15111-D_NQ_NP_995501-MLM20356508380_072015-F.jpg");
        lista.add(producto1);

        Producto producto2 = new Producto();
        producto2.setNombre("Borrador");
        producto2.setDescripcion("Borrador dos colores");
        producto2.setPrecio(5.0);
        producto2.setPrecioAnterior(2.0);
        producto2.setImagen("http://cdn.shopify.com/s/files/1/1045/5226/products/Pelikan-borrador_bicolor_grande.jpg?v=1479764589");
        lista.add(producto2);

        adapter = new ProductoAdapter(getContext(), lista);
        lvLista.setAdapter(adapter);

        return view;
    }

}
