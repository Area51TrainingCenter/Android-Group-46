package com.area51.clase02;

import android.app.Application;

import com.google.firebase.messaging.FirebaseMessaging;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
    }
}
