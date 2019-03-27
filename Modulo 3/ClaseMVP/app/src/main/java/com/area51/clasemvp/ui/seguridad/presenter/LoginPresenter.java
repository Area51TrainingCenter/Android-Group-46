package com.area51.clasemvp.ui.seguridad.presenter;

import com.area51.clasemvp.ui.BasePresenter;
import com.area51.clasemvp.ui.seguridad.views.LoginView;

public interface LoginPresenter extends BasePresenter<LoginView> {
    void validarLogin(String usuario, String contrasena);

    void irARegistro();
}
