package com.area51.clase03;

import com.area51.clase03.entidades.Marca;
import com.area51.clase03.entidades.Producto;
import com.area51.clase03.entidades.Usuario;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MetodoSQL {

    public Usuario guardarModificarUsuario(Usuario usuario) {
        Usuario result = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            if (usuario.getId() == null)
                usuario.setId(UUID.randomUUID().toString());
            result = realm.copyToRealmOrUpdate(usuario);
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return result;
    }

    public Usuario validarUsuario(String usuario, String contrasena) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Usuario.class)
                .equalTo("usuario", usuario)
                .equalTo("contrasena", contrasena)
                .findFirst();
    }

    public Marca guardarModificarMarca(Marca marca) {
        Marca result = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            if (marca.getId() == null)
                marca.setId(UUID.randomUUID().toString());
            result = realm.copyToRealmOrUpdate(marca);
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
        return result;
    }

    public Producto guardarModificarProducto(Producto producto) {
        Producto result = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            if (producto.getId() == null)
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


    public RealmResults<Marca> obtenerMarcas() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Marca.class).findAll();
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
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

}
