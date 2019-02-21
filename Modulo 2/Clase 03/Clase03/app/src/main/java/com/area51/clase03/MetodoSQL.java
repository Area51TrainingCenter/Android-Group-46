package com.area51.clase03;

import com.area51.clase03.entidades.Producto;

import java.util.ArrayList;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MetodoSQL {

    public Producto guardarProducto(Producto producto) {
        Producto result = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            if (producto.getId() != null && !producto.getId().equals(""))
                producto.setId(UUID.randomUUID().toString());
            result = realm.copyToRealmOrUpdate(producto);
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return result;
    }

    public RealmResults<Producto> obtenerProductos() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Producto.class).findAll();
    }

    public void eliminar(String id) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            Producto producto = realm.where(Producto.class)
                    .equalTo("id", id)
                    .findFirst();
            if (producto != null) {
                producto.deleteFromRealm();
                realm.commitTransaction();
            }
        }catch (Exception e){
            realm.cancelTransaction();
        }
    }

}
