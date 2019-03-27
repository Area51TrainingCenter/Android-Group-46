package com.area51.clasemvp.net.interactor;

import com.area51.clasemvp.net.callback.RegistroCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;

public interface RegistroInteractor {
    void registro(UsuarioEntidad entidad, RegistroCallback callback);
}
