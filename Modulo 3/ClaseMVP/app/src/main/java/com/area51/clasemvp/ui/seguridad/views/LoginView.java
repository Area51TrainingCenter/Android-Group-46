package com.area51.clasemvp.ui.seguridad.views;

import com.area51.clasemvp.ui.BaseView;
import com.area51.clasemvp.ui.model.Usuario;

public interface LoginView extends BaseView {
    void onError(String mensaje);

    void onSuccess(Usuario usuario);

    void irARegistro();
}
