package com.area51.claseserviciopost;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configuracion {
    public static Retrofit obtenerConfiguracion() {
        return new Retrofit.Builder()
                .baseUrl("http://207.180.220.115/WSMYDENT/rest/services/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
