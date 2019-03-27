package com.area51.clasemvp.ui;

import com.area51.clasemvp.ui.seguridad.views.LoginView;

public interface BasePresenter<T> {
    void addView(T view);

    void removeView();

    void initViews();

}
