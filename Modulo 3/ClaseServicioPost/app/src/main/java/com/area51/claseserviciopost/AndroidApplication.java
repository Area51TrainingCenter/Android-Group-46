package com.area51.claseserviciopost;

import android.app.Application;
import android.content.Intent;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Intent intent = new Intent(this, InternetBroadcast.class);
        sendBroadcast(intent);
    }
}
