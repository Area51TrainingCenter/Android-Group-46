package com.area51.clase06.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.area51.clase06.R;
import com.area51.clase06.modelos.Foto;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class FotoAdapter extends ArrayAdapter<Foto> {
    private ArrayList<Foto> lista;

    public FotoAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Foto> objects) {
        super(context, resource, objects);
        this.lista = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grilla, parent, false);

        SimpleDraweeView sdvImagen = (SimpleDraweeView)
                convertView.findViewById(R.id.sdvImagen);
        TextView tvTitulo = (TextView)
                convertView.findViewById(R.id.tvTitulo);

        Foto foto = getItem(position);

        sdvImagen.setImageURI(Uri.parse(foto.getImagen()));
        tvTitulo.setText(foto.getTitulo());

        return convertView;
    }

    @Nullable
    @Override
    public Foto getItem(int position) {
        return lista.get(position);
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
