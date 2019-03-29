package com.area51.clasemvp.ui.core.presenter.impl;

import com.area51.clasemvp.ui.core.presenter.HomePresenter;
import com.area51.clasemvp.ui.core.views.HomeView;

public class HomePresenterImpl implements HomePresenter {
    private HomeView view;

    @Override
    public void addView(HomeView view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void initViews() {

    }
}
