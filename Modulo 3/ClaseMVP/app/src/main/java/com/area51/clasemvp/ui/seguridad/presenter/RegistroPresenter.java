package com.area51.clasemvp.ui.seguridad.presenter;

import com.area51.clasemvp.ui.BasePresenter;
import com.area51.clasemvp.ui.seguridad.views.RegistroView;

public interface RegistroPresenter extends BasePresenter<RegistroView> {
    void registrar(String usuario, String nombre, String apellido, String contrasena);
}
