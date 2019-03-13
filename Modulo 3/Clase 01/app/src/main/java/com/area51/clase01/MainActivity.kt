package com.area51.clase01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.area51.clase01.db.MetodoSQLImpl
import kotlinx.android.synthetic.main.activity_main.*

//public class MainActivity extends AppCompatActivity{}
class MainActivity : AppCompatActivity() {

    //public void onCreate(Bundle savedInstanceState)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        btnInicio.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val contrasenia = etContrasenia.text.toString()

            if (usuario.isBlank()) {
                etUsuario.error = "Campo requerido"
                return@setOnClickListener
            } else {
                etUsuario.setText("")
            }
            if (contrasenia.isBlank()) {
                etContrasenia.error = "Campo requerido"
                return@setOnClickListener
            } else {
                etContrasenia.setText("")
            }

            val sql = MetodoSQLImpl()
            val respuesta = sql.validarUsuario(usuario, contrasenia)
            if (respuesta == null) {
                Toast.makeText(
                    this, "Usuario y/o contraseña incorrecto",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(
                    this, HomeActivity::class.java
                )
                startActivity(intent)
            }
        }

        tvRegistrarse.setOnClickListener {
            val intent = Intent(
                this,
                RegistroActivity::class.java
            )
            startActivity(intent)
        }
    }
}
