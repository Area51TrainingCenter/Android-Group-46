package com.area51.clasemvp.ui.core.presenter.impl;

import com.area51.clasemvp.net.callback.UsuarioCallback;
import com.area51.clasemvp.net.entidad.UsuarioEntidad;
import com.area51.clasemvp.net.interactor.UsuarioInteractor;
import com.area51.clasemvp.net.interactor.impl.UsuarioInteractorImpl;
import com.area51.clasemvp.net.mapper.UsuarioMapper;
import com.area51.clasemvp.ui.core.presenter.UsuarioPresenter;
import com.area51.clasemvp.ui.core.views.UsuarioView;

import io.realm.RealmResults;

public class UsuarioPresenterImpl implements UsuarioPresenter, UsuarioCallback {
    private UsuarioView view;
    private UsuarioInteractor interactor;

    @Override
    public void addView(UsuarioView view) {
        this.view = view;
        interactor = new UsuarioInteractorImpl();
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
    public void cargarDatos() {
        interactor.obtenerUsuarios(this);
    }

    @Override
    public void onError() {
        view.onError("Ocurrio un error");
    }

    @Override
    public void onSuccess(RealmResults<UsuarioEntidad> resultado) {
        view.onSuccess(UsuarioMapper.convert(resultado));
    }
}
