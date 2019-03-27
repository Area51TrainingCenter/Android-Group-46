package com.area51.clasemvp.ui.seguridad.views;

import com.area51.clasemvp.ui.BaseView;
import com.area51.clasemvp.ui.model.Usuario;

public interface RegistroView extends BaseView {
    void onSuccess(Usuario respuesta);

    void onError(String mensaje);
}
