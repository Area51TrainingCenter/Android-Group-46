package com.area51.clase07.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.area51.clase07.R;
import com.area51.clase07.adapter.ProfesionalAdapter;
import com.area51.clase07.rest.HelperWS;
import com.area51.clase07.rest.MetodoWS;
import com.area51.clase07.rest.response.DataResulSede;
import com.area51.clase07.rest.response.ProfesionalesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfesionalActivity extends AppCompatActivity {
    private TextView tvNombre, tvRuc, tvDireccion, tvTelefono;
    private RecyclerView rvDatos;
    private ProfesionalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesional);

        tvDireccion = findViewById(R.id.tvDireccion);
        tvRuc = findViewById(R.id.tvRuc);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvNombre = findViewById(R.id.tvNombre);
        rvDatos = findViewById(R.id.rvDatos);

        DataResulSede data = getIntent().getParcelableExtra("item");
        if (data != null) {
            tvNombre.setText(data.getDesEmpresa());
            tvTelefono.setText(data.getTelMovil());
            tvRuc.setText(data.getDesRuc());
            tvDireccion.setText(data.getDesDireccion());

            MetodoWS metodoWS = HelperWS.obtenerConfiguracion()
                    .create(MetodoWS.class);
            Call<ProfesionalesResponse> call =
                    metodoWS.obtenerProfesionales(
                            String.valueOf(data.getCodEmpresa()),
                            data.getCodUbigeo());
            call.enqueue(new Callback<ProfesionalesResponse>() {
                @Override
                public void onResponse(Call<ProfesionalesResponse> call, Response<ProfesionalesResponse> response) {
                    ProfesionalesResponse respuesta = response.body();

                    adapter = new ProfesionalAdapter(
                            ProfesionalActivity.this,
                            respuesta.getDataResulConsulProf());
                    rvDatos.setLayoutManager(new LinearLayoutManager(
                            ProfesionalActivity.this));
                    rvDatos.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<ProfesionalesResponse> call, Throwable t) {

                }
            });

        }
    }
}
