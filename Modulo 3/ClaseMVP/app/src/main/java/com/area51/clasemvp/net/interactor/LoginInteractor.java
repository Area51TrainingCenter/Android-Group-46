package com.area51.clasemvp.net.interactor;

import com.area51.clasemvp.net.callback.LoginCallback;

public interface LoginInteractor {
    void validarLogin(String usuario, String contrasena, LoginCallback callback);
}
