package com.area51.clase01.db

import io.realm.RealmResults

interface MetodoSQL {
    fun validarUsuario(
        usuario: String,
        contrasenia: String
    ): Usuario?

    fun registro(
        usuario: String,
        nombre: String,
        apellido: String,
        contrasenia: String
    ): Usuario?

    fun listar(): RealmResults<Usuario>
}