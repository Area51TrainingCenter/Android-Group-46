package com.area51.clase05.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.area51.clase05.R;
import com.area51.clase05.adapters.ImagenAdapter;
import com.area51.clase05.modelos.Item;

import java.util.ArrayList;

public class ImagenActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ImagenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        viewPager = (ViewPager) findViewById(R.id.vpImagenes);

        //Obtenemos la lista enviada desde el activity anterior
        ArrayList<Item> lista =
                getIntent().getParcelableArrayListExtra("lista");
        adapter = new ImagenAdapter(getSupportFragmentManager(), lista);
        viewPager.setAdapter(adapter);
    }
}
