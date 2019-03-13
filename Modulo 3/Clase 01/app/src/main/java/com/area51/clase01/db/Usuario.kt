package com.area51.clase01.db

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Usuario(
    @PrimaryKey
    var id: String? = null,
    var usuario: String? = null,
    var nombre: String? = null,
    var apellido: String? = null,
    var contrasenia: String? = null
) : RealmObject()