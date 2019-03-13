package com.area51.clase01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.area51.clase01.db.MetodoSQLImpl
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onResume() {
        super.onResume()

        btnRegistrar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val contrasenia = etContrasenia.text.toString()
            val repContrasenia = etRepContrasenia.text.toString()

            if (usuario.isBlank()) {
                etUsuario.error = "Campo requerido"
                return@setOnClickListener
            } else {
                etUsuario.setText("")
            }
            if (apellido.isBlank()) {
                etApellido.error = "Campo requerido"
                return@setOnClickListener
            } else {
                etApellido.setText("")
            }
            if (contrasenia.isBlank()) {
                etContrasenia.error = "Campo requerido"
                return@setOnClickListener
            } else {
                etContrasenia.setText("")
            }
            if (repContrasenia.isBlank()) {
                etRepContrasenia.error = "Campo requerido"
                return@setOnClickListener
            } else {
                etRepContrasenia.setText("")
            }

            val sql = MetodoSQLImpl()
            val respuesta = sql
                    .registro(usuario, nombre, apellido, contrasenia)
            if (respuesta == null) {
                Toast.makeText(this,
                        "Ocurrio un error",
                        Toast.LENGTH_SHORT)
                        .show()
            } else {
                finish()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
