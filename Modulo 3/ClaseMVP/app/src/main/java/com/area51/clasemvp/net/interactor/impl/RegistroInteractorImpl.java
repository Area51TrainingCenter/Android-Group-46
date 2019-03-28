package com.area51.clasemvp.net.interactor.impl;

import com.area51.clasemvp.net.callback.RegistroCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.net.interactor.RegistroInteractor;

import java.util.UUID;

import io.realm.Realm;

public class RegistroInteractorImpl implements RegistroInteractor {
    @Override
    public void registro(UsuarioEntidad entidad, RegistroCallback callback) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            entidad.setId(UUID.randomUUID().toString());
            UsuarioEntidad respuesta = realm.copyToRealm(entidad);

            realm.commitTransaction();
            callback.onSuccess(respuesta);
        } catch (Exception e) {
            realm.cancelTransaction();
            callback.onError();
        }
    }
}
