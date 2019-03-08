package com.area51.clase07.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.area51.clase07.R;
import com.area51.clase07.rest.response.DataResulConsulProf;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class ProfesionalAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<DataResulConsulProf> lista;

    public ProfesionalAdapter(Context context, ArrayList<DataResulConsulProf> lista) {
        this.context = context;
        this.lista = lista;
    }

    class ProfesionalViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sdvImagen;
        private TextView tvNombre;
        private TextView tvNumero;

        public ProfesionalViewHolder(@NonNull View itemView) {
            super(itemView);
            sdvImagen = itemView.findViewById(R.id.sdvImagen);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNumero = itemView.findViewById(R.id.tvCelular);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_profesional, viewGroup, false);
        return new ProfesionalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ProfesionalViewHolder holder = (ProfesionalViewHolder) viewHolder;

        DataResulConsulProf data = lista.get(i);
        holder.tvNombre.setText(data.getNombreCompleto());
        holder.tvNumero.setText(data.getCelular());
        if (data.getPathFile() != null &&
                data.getPathFile().length() > 0)
            holder.sdvImagen.setImageURI(Uri.parse(data.getPathFile()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
