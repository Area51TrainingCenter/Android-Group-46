package com.area51.clasemvp.net.interactor;

import com.area51.clasemvp.net.callback.RegistroCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;

import io.realm.Realm;

public class RegistroInteractorImpl implements RegistroInteractor {
    @Override
    public void registro(UsuarioEntidad entidad, RegistroCallback callback) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            UsuarioEntidad respuesta = realm.copyToRealm(entidad);

            realm.commitTransaction();
            callback.onSuccess(respuesta);
        } catch (Exception e) {
            realm.cancelTransaction();
            callback.onError();
        }
    }
}
