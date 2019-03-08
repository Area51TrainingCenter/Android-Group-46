package com.area51.clase07.rest;

import com.area51.clase07.rest.response.ObtenerSedesResponse;
import com.area51.clase07.rest.response.ProfesionalesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MetodoWS {

    @GET("sedes?desempresa=")
    Call<ObtenerSedesResponse> obtenerSedes();

    @GET("consProfesionalesSedes")
    Call<ProfesionalesResponse> obtenerProfesionales(
            @Query("codempresa") String codempresa,
            @Query("codubigeo") String codubigeo);
}
