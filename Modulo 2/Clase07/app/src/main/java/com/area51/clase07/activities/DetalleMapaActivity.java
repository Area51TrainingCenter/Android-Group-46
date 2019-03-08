package com.area51.clase07.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.area51.clase07.R;
import com.area51.clase07.rest.response.DataResulSede;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class DetalleMapaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mapa);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                ArrayList<DataResulSede> lista =
                        getIntent()
                                .getParcelableArrayListExtra("lista");
                for (DataResulSede item : lista) {
                    if (item.getLatitud() != null &&
                            item.getLatitud().length() > 0 &&
                            item.getLongitud() != null &&
                            item.getLongitud().length() > 0) {

                        googleMap.addMarker(new MarkerOptions()
                                .position(new LatLng(
                                        Double.parseDouble(item.getLatitud()),
                                        Double.parseDouble(item.getLongitud())))
                                .title(item.getDesRuc())
                                .snippet(item.getDesEmpresa())
                                .icon(BitmapDescriptorFactory.defaultMarker()));
                        googleMap.moveCamera(
                                CameraUpdateFactory.newLatLngZoom(
                                        new LatLng(
                                                Double.parseDouble(item.getLatitud()),
                                                Double.parseDouble(item.getLongitud()
                                                )), 10)
                        );
                    }
                }
            }
        });
    }
}
