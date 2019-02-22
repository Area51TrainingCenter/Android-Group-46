package com.area51.clase03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.area51.clase03.R;
import com.area51.clase03.entidades.Producto;

import java.util.ArrayList;

import io.realm.RealmResults;

public class ProductoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Producto> lista;
    private Context context;

    public ProductoAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_producto, viewGroup, false);
        return new ProductoViewHolder(view);
    }

    class ProductoViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvMarca, tvNombre, tvModelo, tvColor;
        CardView card;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMarca = itemView.findViewById(R.id.tvMarca);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvModelo = itemView.findViewById(R.id.tvModelo);
            tvColor = itemView.findViewById(R.id.tvColor);
            card = itemView.findViewById(R.id.contenedor);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ProductoViewHolder holder = (ProductoViewHolder) viewHolder;

        Producto producto = lista.get(i);
        holder.tvMarca.setText(producto.getMarca().getNombre());
        holder.tvNombre.setText(producto.getNombre());
        holder.tvModelo.setText(producto.getModelo());
        holder.tvColor.setText(producto.getColor());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void agregar(RealmResults<Producto> datos) {
        if (datos != null) {
            lista.clear();
            lista.addAll(datos);
            notifyDataSetChanged();
        }
    }
}
