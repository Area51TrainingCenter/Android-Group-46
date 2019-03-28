package com.area51.clasemvp.ui.seguridad.presenter.impl;

import com.area51.clasemvp.net.callback.LoginCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.net.interactor.LoginInteractor;
import com.area51.clasemvp.net.interactor.impl.LoginInteractorImpl;
import com.area51.clasemvp.net.mapper.UsuarioMapper;
import com.area51.clasemvp.ui.seguridad.presenter.LoginPresenter;
import com.area51.clasemvp.ui.seguridad.views.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginCallback {
    private LoginView view;
    private LoginInteractor interactor;

    @Override
    public void addView(LoginView view) {
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void initViews() {
        view.init();
    }

    @Override
    public void validarLogin(String usuario, String contrasena) {
        interactor.validarLogin(usuario, contrasena, this);
    }

    @Override
    public void irARegistro() {
        view.irARegistro();
    }

    @Override
    public void onError() {
        view.onError("Usuario y/o contraseña invalidos");
    }

    @Override
    public void onSuccess(UsuarioEntidad entidad) {
        view.onSuccess(UsuarioMapper.convert(entidad));
    }
}
