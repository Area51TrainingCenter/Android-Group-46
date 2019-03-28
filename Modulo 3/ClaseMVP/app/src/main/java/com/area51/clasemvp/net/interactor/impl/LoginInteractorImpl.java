package com.area51.clasemvp.net.interactor.impl;

import com.area51.clasemvp.net.callback.LoginCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.net.interactor.LoginInteractor;

import io.realm.Realm;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void validarLogin(String usuario, String contrasena, LoginCallback callback) {

        Realm realm = Realm.getDefaultInstance();
        UsuarioEntidad usuarioEntidad =
                realm.where(UsuarioEntidad.class)
                        .equalTo("usuario", usuario)
                        .equalTo("contrasena", contrasena)
                        .findFirst();
        if (usuarioEntidad == null) {
            callback.onError();
        } else {
            callback.onSuccess(usuarioEntidad);
        }
    }
}
