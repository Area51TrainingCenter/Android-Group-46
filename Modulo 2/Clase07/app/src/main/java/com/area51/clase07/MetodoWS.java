package com.area51.clase07;

import com.area51.clase07.response.ObtenerSedesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MetodoWS {

    @GET("sedes?desempresa=")
    Call<ObtenerSedesResponse> obtenerSedes();
}
