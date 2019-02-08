package com.area51.clase08.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable {
    private String imagen;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Double precioAnterior;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(Double precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imagen);
        dest.writeString(this.nombre);
        dest.writeString(this.descripcion);
        dest.writeValue(this.precio);
        dest.writeValue(this.precioAnterior);
    }

    public Producto() {
    }

    protected Producto(Parcel in) {
        this.imagen = in.readString();
        this.nombre = in.readString();
        this.descripcion = in.readString();
        this.precio = (Double) in.readValue(Double.class.getClassLoader());
        this.precioAnterior = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<Producto> CREATOR = new Parcelable.Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel source) {
            return new Producto(source);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };
}
