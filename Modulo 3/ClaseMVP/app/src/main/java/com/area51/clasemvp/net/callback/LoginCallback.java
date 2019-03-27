package com.area51.clasemvp.net.callback;

import com.area51.clasemvp.net.entidad.UsuarioEntidad;

public interface LoginCallback {
    void onError();

    void onSuccess(UsuarioEntidad entidad);
}
