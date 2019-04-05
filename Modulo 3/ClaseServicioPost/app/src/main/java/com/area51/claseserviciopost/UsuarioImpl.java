package com.area51.claseserviciopost;

import io.realm.Realm;
import io.realm.RealmResults;

public class UsuarioImpl implements UsuarioInterfaz {
    @Override
    public void registrar(UsuarioEntity entity) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            realm.copyToRealm(entity);

            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    @Override
    public RealmResults<UsuarioEntity> listar() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(UsuarioEntity.class).findAll();
    }

    @Override
    public void eliminarPorId(String id) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            UsuarioEntity entity = realm.where(UsuarioEntity.class)
                    .equalTo("id", id)
                    .findFirst();
            if (entity != null) {
                entity.deleteFromRealm();
            }
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }
}
