package com.area51.clase04;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
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
    public View getView(final int posicion, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

        //Obtener los datos según la posición
        final Persona persona = (Persona) getItem(posicion);

        //Mapear los componentes
        TextView tvNombre = (TextView) view.findViewById(R.id.tvNombre);
        TextView tvApellido = (TextView) view.findViewById(R.id.tvApellido);
        TextView tvGenero = (TextView) view.findViewById(R.id.tvGenero);
        LinearLayout contenedor = (LinearLayout) view.findViewById(R.id.contenedor);

        //Setear los datos en los componentes
        tvNombre.setText(persona.getNombre());
        tvApellido.setText(persona.getApellido());
        tvGenero.setText(persona.getGenero());

        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(viewGroup.getContext());
                builder.setTitle("Acción a realizar");
                builder.setMessage("Seleccione una");
                builder.setPositiveButton(
                        "Actualizar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                ((MainActivity) viewGroup.getContext()).cargarDatos(persona, posicion);

                            }
                        }
                );
                builder.setNegativeButton(
                        "Eliminar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                cargarEliminar(persona, posicion, viewGroup.getContext());

                            }
                        }
                );
                builder.show();

            }
        });

        return view;
    }

    private void cargarEliminar(final Persona persona, int posicion, final Context context) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(context);
        builder.setTitle("Advertencia");
        builder.setMessage("Está seguro de eliminar?");
        builder.setPositiveButton(
                "Aceptar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //Acá removemos del listado
                        lista.remove(persona);
                        //Actualizar la lista
                        notifyDataSetChanged();
                        //((MainActivity)context).limpiarDatos();

                    }
                }
        );
        builder.setNegativeButton(
                "Cancelar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }
        );
        builder.show();
    }

    public void actualizarDato(Persona persona, int posicion) {
        lista.get(posicion).setNombre(persona.getNombre());
        lista.get(posicion).setApellido(persona.getApellido());
        lista.get(posicion).setGenero(persona.getGenero());

        notifyDataSetChanged();
    }
}
