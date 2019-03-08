
package com.area51.clase07.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataResulConsulProf {

    @SerializedName("nombreCompleto")
    @Expose
    private String nombreCompleto;
    @SerializedName("celular")
    @Expose
    private String celular;
    @SerializedName("codPersona")
    @Expose
    private Integer codPersona;
    @SerializedName("numCole")
    @Expose
    private Object numCole;
    @SerializedName("pathFile")
    @Expose
    private String pathFile;
    @SerializedName("flgFileCargado")
    @Expose
    private String flgFileCargado;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Object getNumCole() {
        return numCole;
    }

    public void setNumCole(Object numCole) {
        this.numCole = numCole;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getFlgFileCargado() {
        return flgFileCargado;
    }

    public void setFlgFileCargado(String flgFileCargado) {
        this.flgFileCargado = flgFileCargado;
    }

}
