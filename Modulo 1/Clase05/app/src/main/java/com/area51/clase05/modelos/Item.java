package com.area51.clase05.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String imagen, nombre;

    public Item(String nombre, String imagen) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imagen);
        dest.writeString(this.nombre);
    }

    protected Item(Parcel in) {
        this.imagen = in.readString();
        this.nombre = in.readString();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
