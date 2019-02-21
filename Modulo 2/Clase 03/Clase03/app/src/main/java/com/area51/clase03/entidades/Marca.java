package com.area51.clase03.entidades;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Marca extends RealmObject {
    @PrimaryKey
    private String id;
    private String nombre;

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
}
