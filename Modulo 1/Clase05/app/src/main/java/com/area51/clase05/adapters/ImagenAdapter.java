package com.area51.clase05.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.area51.clase05.fragmentos.ImagenFragment;
import com.area51.clase05.modelos.Item;

import java.util.ArrayList;
import java.util.List;

public class ImagenAdapter extends FragmentPagerAdapter {
    private ArrayList<Item> lista;

    public ImagenAdapter(FragmentManager fm, ArrayList<Item> lista) {
        super(fm);
        this.lista = lista;
    }

    @Override
    public Fragment getItem(int i) {
        ImagenFragment imagenFragment = new ImagenFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable("item", lista.get(i));
        imagenFragment.setArguments(bundle);

        return imagenFragment;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
