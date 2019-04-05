package com.area51.claseserviciopost;

import android.app.Application;
import android.content.Intent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration =
                new RealmConfiguration.Builder()
                        .name("clase_servicio_post.realm")
                        .schemaVersion(1)
                        .build();
        Realm.setDefaultConfiguration(configuration);

        Intent intent = new Intent(this, InternetBroadcast.class);
        sendBroadcast(intent);
    }
}
