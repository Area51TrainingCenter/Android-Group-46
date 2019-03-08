package com.area51.clase07;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.area51.clase07.response.DataResulSede;

import java.util.ArrayList;

public class SedeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<DataResulSede> lista;

    public SedeAdapter(Context context, ArrayList<DataResulSede> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sede, viewGroup, false);
        return new SedeViewHolder(view);
    }

    class SedeViewHolder extends RecyclerView.ViewHolder {
        TextView tvRuc, tvNombre, tvDireccion, tvTelefono;
        ImageView ivUbicacion;

        public SedeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRuc = itemView.findViewById(R.id.tvRuc);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvTelefono = itemView.findViewById(R.id.tvtelefono);
            ivUbicacion = itemView.findViewById(R.id.ivUbicacion);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        SedeViewHolder holder = (SedeViewHolder) viewHolder;

        final DataResulSede data = lista.get(i);

        holder.tvNombre.setText(data.getDesEmpresa());
        holder.tvRuc.setText(data.getDesRuc());
        holder.tvDireccion.setText(data.getDesDireccion());
        holder.tvTelefono.setText(data.getTelFijo());

        if (data.getLatitud() != null &&
                data.getLatitud().length() > 0 &&
                data.getLongitud() != null &&
                data.getLongitud().length() > 0) {
            holder.ivUbicacion.setVisibility(View.VISIBLE);
        } else {
            holder.ivUbicacion.setVisibility(View.GONE);
        }

        holder.ivUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("item", data);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
