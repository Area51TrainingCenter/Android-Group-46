package com.area51.clase04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonaAdapter extends BaseAdapter {
    private ArrayList<Persona> lista = new ArrayList<>();

    public void agregar(Persona persona) {
        lista.add(persona);
        notifyDataSetChanged();
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

        //Obtener los datos según la posición
        Persona persona = (Persona) getItem(i);

        //Mapear los componentes
        TextView tvNombre = (TextView) view.findViewById(R.id.tvNombre);
        TextView tvApellido = (TextView) view.findViewById(R.id.tvApellido);
        TextView tvGenero = (TextView) view.findViewById(R.id.tvGenero);

        //Setear los datos en los componentes
        tvNombre.setText(persona.getNombre());
        tvApellido.setText(persona.getApellido());
        tvGenero.setText(persona.getGenero());

        return view;
    }
}
