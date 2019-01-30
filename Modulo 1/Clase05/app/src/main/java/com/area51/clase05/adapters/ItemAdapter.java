package com.area51.clase05.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.area51.clase05.R;
import com.area51.clase05.activities.ImagenActivity;
import com.area51.clase05.modelos.Item;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    private List<Item> lista;

    public ItemAdapter(@NonNull Context context,
                       int resource,
                       @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.lista = objects;
    }

    @NonNull
    @Override
    public View getView(final int position,
                        @Nullable View convertView,
                        @NonNull final ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        SimpleDraweeView sdvImagen =
                (SimpleDraweeView) convertView.findViewById(R.id.sdvImagen);
        TextView tvNombre =
                (TextView) convertView.findViewById(R.id.tvNombre);
        FrameLayout contenedor =
                (FrameLayout) convertView.findViewById(R.id.contenedor);

        //Obtenemos los datos de la lista según la posición
        Item item = getItem(position);
        if (item != null) {
            tvNombre.setText(item.getNombre());
            sdvImagen.setImageURI(Uri.parse(item.getImagen()));

            contenedor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent =
                            new Intent(parent.getContext(),
                                    ImagenActivity.class);
                    ArrayList<Item> itemArrayList = new ArrayList<>();
                    itemArrayList.addAll(lista);
                    intent.putParcelableArrayListExtra("lista", itemArrayList);
                    intent.putExtra("posicion", position);
                    parent.getContext().startActivity(intent);

                }
            });
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Nullable
    @Override
    public Item getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
