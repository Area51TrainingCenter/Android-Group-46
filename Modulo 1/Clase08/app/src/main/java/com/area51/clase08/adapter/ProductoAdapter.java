package com.area51.clase08.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.area51.clase08.R;
import com.area51.clase08.activities.ProductoDetalleActivity;
import com.area51.clase08.modelos.Producto;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> lista;

    public ProductoAdapter(Context context, ArrayList<Producto> lista) {
        this.context = context;
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
        view = LayoutInflater.from(context)
                .inflate(R.layout.item, viewGroup, false);

        final Producto producto = (Producto) getItem(i);

        SimpleDraweeView sdvImagen =
                (SimpleDraweeView) view.findViewById(R.id.sdvImagen);
        TextView tvTitulo =
                (TextView) view.findViewById(R.id.tvTitulo);
        TextView tvPrecioActual =
                (TextView) view.findViewById(R.id.tvPrecioActual);
        TextView tvPrecioAnterior =
                (TextView) view.findViewById(R.id.tvPrecioAnterior);
        LinearLayout contenedor =
                (LinearLayout) view.findViewById(R.id.contenedor);

        sdvImagen.setImageURI(Uri.parse(producto.getImagen()));
        tvTitulo.setText(producto.getNombre());
        tvPrecioAnterior.setText("S/ " + producto.getPrecioAnterior());
        tvPrecioActual.setText("S/ " + producto.getPrecio());

        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ProductoDetalleActivity.class);
                intent.putExtra("item", producto);
                context.startActivity(intent);

            }
        });

        return view;
    }
}
