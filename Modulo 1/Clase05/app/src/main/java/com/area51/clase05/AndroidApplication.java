package com.area51.clase05;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Inicializamos la librería de FrescoLib en toda la aplicación
        Fresco.initialize(this);
    }
}
