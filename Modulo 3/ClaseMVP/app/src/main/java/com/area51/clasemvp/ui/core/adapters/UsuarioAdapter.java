package com.area51.clasemvp.ui.core.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.area51.clasemvp.R;
import com.area51.clasemvp.ui.model.Usuario;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Usuario> lista;
    private Context context;

    public UsuarioAdapter(ArrayList<Usuario> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsuario, tvNombre;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsuario = itemView.findViewById(R.id.tvUsuario);
            tvNombre = itemView.findViewById(R.id.tvNombre);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_usuario, viewGroup, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        UsuarioViewHolder holder = (UsuarioViewHolder) viewHolder;

        Usuario usuario = lista.get(i);
        if (usuario != null) {
            holder.tvUsuario.setText(usuario.getUsuario());
            holder.tvNombre.setText(usuario.getNombre());
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
