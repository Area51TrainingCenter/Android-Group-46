
package com.area51.clase07.rest.response;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObtenerSedesResponse {

    @SerializedName("nomServ")
    @Expose
    private String nomServ;
    @SerializedName("codRpta")
    @Expose
    private Integer codRpta;
    @SerializedName("desRpta")
    @Expose
    private String desRpta;
    @SerializedName("dataResulSedes")
    @Expose
    private ArrayList<DataResulSede> dataResulSedes = null;

    public String getNomServ() {
        return nomServ;
    }

    public void setNomServ(String nomServ) {
        this.nomServ = nomServ;
    }

    public Integer getCodRpta() {
        return codRpta;
    }

    public void setCodRpta(Integer codRpta) {
        this.codRpta = codRpta;
    }

    public String getDesRpta() {
        return desRpta;
    }

    public void setDesRpta(String desRpta) {
        this.desRpta = desRpta;
    }

    public ArrayList<DataResulSede> getDataResulSedes() {
        return dataResulSedes;
    }

    public void setDataResulSedes(ArrayList<DataResulSede> dataResulSedes) {
        this.dataResulSedes = dataResulSedes;
    }

}
