package com.area51.claseserviciopost;

import io.realm.RealmResults;

public interface UsuarioInterfaz {
    void registrar(UsuarioEntity entity);

    RealmResults<UsuarioEntity> listar();

    void eliminarPorId(String id);
}
