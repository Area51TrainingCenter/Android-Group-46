package com.area51.clasemvp.net.callback;

import com.area51.clasemvp.net.entidad.UsuarioEntidad;

import io.realm.RealmResults;

public interface UsuarioCallback {
    void onError();

    void onSuccess(RealmResults<UsuarioEntidad> resultado);
}
