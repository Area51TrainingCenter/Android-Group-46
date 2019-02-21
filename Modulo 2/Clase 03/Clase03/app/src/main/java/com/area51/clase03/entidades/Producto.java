package com.area51.clase03.entidades;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Producto extends RealmObject {
    @PrimaryKey
    private String id;
    private String nombre;
    private String color;
    private String modelo;
    private Marca marca;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
