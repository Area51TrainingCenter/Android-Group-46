package com.area51.clase01.db

import android.content.ContentValues
import io.realm.Realm
import io.realm.RealmResults
import java.lang.Exception
import java.util.*

class MetodoSQLImpl : MetodoSQL {
    override fun validarUsuario(usuario: String, contrasenia: String): Usuario? {
        val realm = Realm.getDefaultInstance()
        return realm.where(Usuario::class.java)
            .equalTo("usuario", usuario)
            .equalTo("contrasenia", contrasenia)
            .findFirst()
    }

    override fun registro(usuario: String, nombre: String, apellido: String, contrasenia: String): Usuario? {
        val realm = Realm.getDefaultInstance()
        var usuarioRetorno: Usuario? = null
        try {
            realm.beginTransaction()
            val obj = Usuario()
            obj.id = UUID.randomUUID().toString()
            obj.usuario = usuario
            obj.nombre = nombre
            obj.apellido = apellido
            obj.contrasenia = contrasenia
            usuarioRetorno = realm.copyToRealmOrUpdate(obj)

            realm.commitTransaction()
        } catch (ex: Exception) {
            realm.cancelTransaction()
        }
        return usuarioRetorno
    }

    override fun listar(): RealmResults<Usuario> {
        val realm = Realm.getDefaultInstance()
        return realm.where(Usuario::class.java).findAll()
    }

}