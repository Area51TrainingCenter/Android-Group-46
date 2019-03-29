package com.area51.clasemvp.net.interactor;

import com.area51.clasemvp.net.callback.UsuarioCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.ui.model.Usuario;

import io.realm.RealmResults;

public interface UsuarioInteractor {
    void obtenerUsuarios(UsuarioCallback callback);
}
