package com.area51.clasemvp.net.callback;

import com.area51.clasemvp.net.entidad.UsuarioEntidad;

public interface RegistroCallback {
    void onSuccess(UsuarioEntidad respuesta);

    void onError();
}
