package com.area51.clasemvp.net.interactor.impl;

import com.area51.clasemvp.net.callback.UsuarioCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.net.interactor.UsuarioInteractor;

import io.realm.Realm;
import io.realm.RealmResults;

public class UsuarioInteractorImpl implements UsuarioInteractor {

    @Override
    public void obtenerUsuarios(UsuarioCallback callback) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<UsuarioEntidad> resultado =
                realm.where(UsuarioEntidad.class).findAll();
        if (resultado == null) {
            callback.onError();
        } else {
            callback.onSuccess(resultado);
        }
    }
}
