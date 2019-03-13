package com.area51.clase01

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

open class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .schemaVersion(1)
            .name("kotlin")
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }
}