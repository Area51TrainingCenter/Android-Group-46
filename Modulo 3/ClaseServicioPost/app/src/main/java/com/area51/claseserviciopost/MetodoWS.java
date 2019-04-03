package com.area51.claseserviciopost;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MetodoWS {

    @POST("mantenimientoUsuario")
    //@FormUrlEncoded
    Call<UsuarioResponse> registrarUsuario(@Query("codpersona") String codpersona,
                                           @Query("tipodoc") String tipodoc,
                                           @Query("numdoc") String numdoc,
                                           @Query("pass") String pass,
                                           @Query("prinombre") String prinombre,
                                           @Query("segnombre") String segnombre,
                                           @Query("apepaterno") String apepaterno,
                                           @Query("apematerno") String apematerno,
                                           @Query("flgsexo") String flgsexo,
                                           @Query("fecnaci") String fecnaci,
                                           @Query("telfijo") String telfijo,
                                           @Query("telcel") String telcel,
                                           @Query("emailprin") String emailprin,
                                           @Query("desdire") String desdire,
                                           @Query("flgpubli") String flgpubli,
                                           @Query("maqip") String maqip,
                                           @Query("opcion") String opcion,
                                           @Query("origen") String origen);
}
