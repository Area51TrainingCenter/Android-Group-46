
package com.area51.clase07.rest.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataResulSede implements Parcelable {

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
    private String latitud;
    @SerializedName("longitud")
    @Expose
    private String longitud;
    @SerializedName("desDistrito")
    @Expose
    private String desDistrito;
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

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDesDistrito() {
        return desDistrito;
    }

    public void setDesDistrito(String desDistrito) {
        this.desDistrito = desDistrito;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.codEmpresa);
        dest.writeString(this.desEmpresa);
        dest.writeString(this.desCorta);
        dest.writeString(this.desRuc);
        dest.writeString(this.desDireccion);
        dest.writeString(this.telFijo);
        dest.writeString(this.telMovil);
        dest.writeString(this.codUbigeo);
        dest.writeString(this.latitud);
        dest.writeString(this.longitud);
        dest.writeString(this.desDistrito);
        dest.writeString(this.horario);
    }

    public DataResulSede() {
    }

    protected DataResulSede(Parcel in) {
        this.codEmpresa = (Integer) in.readValue(Integer.class.getClassLoader());
        this.desEmpresa = in.readString();
        this.desCorta = in.readString();
        this.desRuc = in.readString();
        this.desDireccion = in.readString();
        this.telFijo = in.readString();
        this.telMovil = in.readString();
        this.codUbigeo = in.readString();
        this.latitud = in.readString();
        this.longitud = in.readString();
        this.desDistrito = in.readString();
        this.horario = in.readString();
    }

    public static final Creator<DataResulSede> CREATOR = new Creator<DataResulSede>() {
        @Override
        public DataResulSede createFromParcel(Parcel source) {
            return new DataResulSede(source);
        }

        @Override
        public DataResulSede[] newArray(int size) {
            return new DataResulSede[size];
        }
    };
}
