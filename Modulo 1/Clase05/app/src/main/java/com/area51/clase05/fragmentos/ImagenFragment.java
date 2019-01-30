package com.area51.clase05.fragmentos;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.area51.clase05.R;
import com.area51.clase05.modelos.Item;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagenFragment extends Fragment {
    private TextView tvNombre;
    private SimpleDraweeView sdvImagen;

    public ImagenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imagen, container, false);

        tvNombre = view.findViewById(R.id.tvNombre);
        sdvImagen = view.findViewById(R.id.sdvImagen);

        Bundle bundle = getArguments();

        Item item = bundle.getParcelable("item");

        tvNombre.setText(item.getNombre());
        sdvImagen.setImageURI(Uri.parse(item.getImagen()));

        return view;
    }

}
