package com.area51.clasemvp.ui.core.presenter;

import com.area51.clasemvp.ui.BasePresenter;
import com.area51.clasemvp.ui.core.views.UsuarioView;

public interface UsuarioPresenter extends BasePresenter<UsuarioView> {
    void cargarDatos();
}
