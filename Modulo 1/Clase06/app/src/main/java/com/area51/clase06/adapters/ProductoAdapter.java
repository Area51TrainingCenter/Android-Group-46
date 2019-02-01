package com.area51.clase06.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.area51.clase06.R;
import com.area51.clase06.modelos.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private ArrayList<Producto> lista;

    public ProductoAdapter(ArrayList<Producto> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

        TextView tvMarca = (TextView) view.findViewById(R.id.tvMarca);
        TextView tvModelo = (TextView) view.findViewById(R.id.tvModelo);
        TextView tvAnio = (TextView) view.findViewById(R.id.tvAnio);

        Producto producto = (Producto) getItem(i);
        tvAnio.setText(producto.getAnio());
        tvMarca.setText(producto.getMarca());
        tvModelo.setText(producto.getModelo());

        return view;
    }
}
