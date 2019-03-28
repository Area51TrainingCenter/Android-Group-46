package com.area51.clasemvp.ui.seguridad.presenter.impl;

import com.area51.clasemvp.net.callback.RegistroCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.net.interactor.RegistroInteractor;
import com.area51.clasemvp.net.interactor.impl.RegistroInteractorImpl;
import com.area51.clasemvp.net.mapper.UsuarioMapper;
import com.area51.clasemvp.ui.model.Usuario;
import com.area51.clasemvp.ui.seguridad.presenter.RegistroPresenter;
import com.area51.clasemvp.ui.seguridad.views.RegistroView;

public class RegistroPresenterImpl implements RegistroPresenter, RegistroCallback {
    private RegistroView view;
    private RegistroInteractor interactor;

    @Override
    public void registrar(String usuario, String nombre, String apellido, String contrasena) {
        Usuario obj = new Usuario();
        obj.setUsuario(usuario);
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setContrasena(contrasena);
        interactor.registro(UsuarioMapper.convert(obj), this);
    }

    @Override
    public void addView(RegistroView view) {
        this.view = view;
        interactor = new RegistroInteractorImpl();
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
    public void onSuccess(UsuarioEntidad respuesta) {
        view.onSuccess(UsuarioMapper.convert(respuesta));
    }

    @Override
    public void onError() {
        view.onError("Ocurrio un error");
    }
}
