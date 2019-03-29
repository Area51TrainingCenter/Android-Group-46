package com.area51.clasemvp.ui.core.views;

import com.area51.clasemvp.ui.BaseView;
import com.area51.clasemvp.ui.model.Usuario;

import java.util.ArrayList;

public interface UsuarioView extends BaseView {
    void onError(String mensaje);

    void onSuccess(ArrayList<Usuario> convert);
}
