package com.area51.clase01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.area51.clase01.R;
import com.area51.clase01.modelos.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Producto> lista = null;
    private Context context;

    public ProductoAdapter(ArrayList<Producto> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    class ProductoViewHolder extends
            RecyclerView.ViewHolder {

        AppCompatTextView tvNombre, tvMarca, tvModelo, tvColor;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = (AppCompatTextView) itemView.findViewById(R.id.tvNombre);
            tvMarca = (AppCompatTextView) itemView.findViewById(R.id.tvMarca);
            tvModelo = (AppCompatTextView) itemView.findViewById(R.id.tvModelo);
            tvColor = (AppCompatTextView) itemView.findViewById(R.id.tvColor);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_producto, viewGroup, false);

        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Producto producto = lista.get(i);

        ProductoViewHolder holder = (ProductoViewHolder) viewHolder;
        holder.tvNombre.setText(producto.getNombre());
        holder.tvMarca.setText(producto.getMarca());
        holder.tvModelo.setText(producto.getModelo());
        holder.tvColor.setText(producto.getColor());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
