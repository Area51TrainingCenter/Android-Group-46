
package com.area51.clase07.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataResulSede {

    @SerializedName("codEmpresa")
    @Expose
    private Integer codEmpresa;
    @SerializedName("desEmpresa")
    @Expose
    private String desEmpresa;
    @SerializedName("desCorta")
    @Expose
    private String desCorta;
    @SerializedName("desRuc")
    @Expose
    private String desRuc;
    @SerializedName("desDireccion")
    @Expose
    private String desDireccion;
    @SerializedName("telFijo")
    @Expose
    private String telFijo;
    @SerializedName("telMovil")
    @Expose
    private String telMovil;
    @SerializedName("codUbigeo")
    @Expose
    private String codUbigeo;
    @SerializedName("latitud")
    @Expose
    private Object latitud;
    @SerializedName("longitud")
    @Expose
    private Object longitud;
    @SerializedName("desDistrito")
    @Expose
    private Object desDistrito;
    @SerializedName("horario")
    @Expose
    private String horario;

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getDesEmpresa() {
        return desEmpresa;
    }

    public void setDesEmpresa(String desEmpresa) {
        this.desEmpresa = desEmpresa;
    }

    public String getDesCorta() {
        return desCorta;
    }

    public void setDesCorta(String desCorta) {
        this.desCorta = desCorta;
    }

    public String getDesRuc() {
        return desRuc;
    }

    public void setDesRuc(String desRuc) {
        this.desRuc = desRuc;
    }

    public String getDesDireccion() {
        return desDireccion;
    }

    public void setDesDireccion(String desDireccion) {
        this.desDireccion = desDireccion;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public String getCodUbigeo() {
        return codUbigeo;
    }

    public void setCodUbigeo(String codUbigeo) {
        this.codUbigeo = codUbigeo;
    }

    public Object getLatitud() {
        return latitud;
    }

    public void setLatitud(Object latitud) {
        this.latitud = latitud;
    }

    public Object getLongitud() {
        return longitud;
    }

    public void setLongitud(Object longitud) {
        this.longitud = longitud;
    }

    public Object getDesDistrito() {
        return desDistrito;
    }

    public void setDesDistrito(Object desDistrito) {
        this.desDistrito = desDistrito;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}
