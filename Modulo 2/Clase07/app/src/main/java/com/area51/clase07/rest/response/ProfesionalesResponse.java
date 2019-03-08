
package com.area51.clase07.rest.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfesionalesResponse {

    @SerializedName("nomServ")
    @Expose
    private String nomServ;
    @SerializedName("codRpta")
    @Expose
    private Integer codRpta;
    @SerializedName("desRpta")
    @Expose
    private String desRpta;
    @SerializedName("dataResulConsulProf")
    @Expose
    private ArrayList<DataResulConsulProf> dataResulConsulProf = null;

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

    public ArrayList<DataResulConsulProf> getDataResulConsulProf() {
        return dataResulConsulProf;
    }

    public void setDataResulConsulProf(ArrayList<DataResulConsulProf> dataResulConsulProf) {
        this.dataResulConsulProf = dataResulConsulProf;
    }

}
