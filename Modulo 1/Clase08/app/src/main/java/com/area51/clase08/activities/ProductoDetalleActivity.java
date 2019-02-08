package com.area51.clase08.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.area51.clase08.R;
import com.area51.clase08.modelos.Producto;
import com.facebook.drawee.view.SimpleDraweeView;

public class ProductoDetalleActivity extends AppCompatActivity {
    private TextView tvTitulo, tvDescripcion, tvMonto, tvMontoAnterior;
    private SimpleDraweeView sdvImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detalle);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvMontoAnterior = (TextView) findViewById(R.id.tvPrecioAnterior);
        tvMonto = (TextView) findViewById(R.id.tvPrecioActual);
        sdvImagen = (SimpleDraweeView) findViewById(R.id.sdvImagen);

        Producto producto = getIntent().getParcelableExtra("item");
        tvTitulo.setText(producto.getNombre());
        tvDescripcion.setText(producto.getDescripcion());
        tvMonto.setText("S/ " + producto.getPrecio());
        tvMontoAnterior.setText("S/ " + producto.getPrecioAnterior());
        sdvImagen.setImageURI(Uri.parse(producto.getImagen()));
    }

}
