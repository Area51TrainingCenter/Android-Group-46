package com.area51.clase05.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.area51.clase05.R;
import com.area51.clase05.adapters.ItemAdapter;
import com.area51.clase05.modelos.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        List<Item> lista = new ArrayList<>();
        lista.add(new Item("Imagen 1", "https://www.fundacion-affinity.org/sites/default/files/el-gato-necesita-tener-acceso-al-exterior.jpg"));
        lista.add(new Item("Imagen 2", "https://cdn1.royalcanin.es/wp-content/uploads/2017/01/gatos-de-interior.jpg"));
        lista.add(new Item("Imagen 3", "https://fotos01.diarioinformacion.com/mmp/2018/11/21/690x278/perro.jpg"));
        lista.add(new Item("Imagen 4", "https://cdn.tn.com.ar/sites/default/files/styles/1366x765/public/2018/07/25/perro.jpg"));

        adapter = new ItemAdapter(this, R.layout.item, lista);
        gridView.setAdapter(adapter);
    }
}
