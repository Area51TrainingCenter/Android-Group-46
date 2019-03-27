package com.area51.clasemvp.ui.seguridad.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.area51.clasemvp.R;
import com.area51.clasemvp.ui.BaseActivity;
import com.area51.clasemvp.ui.model.Usuario;
import com.area51.clasemvp.ui.seguridad.presenter.RegistroPresenter;
import com.area51.clasemvp.ui.seguridad.presenter.RegistroPresenterImpl;
import com.area51.clasemvp.ui.seguridad.views.RegistroView;

public class RegistroActivity extends BaseActivity implements RegistroView {
    private RegistroPresenter presenter;
    private EditText etUsuario, etNombre, etApellido, etContrasena, etRepContrasena;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        presenter = new RegistroPresenterImpl();
        presenter.addView(this);
        presenter.initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.removeView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = etUsuario.getText().toString();
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String contrasena = etContrasena.getText().toString();
                String repContrasena = etRepContrasena.getText().toString();

                presenter.registrar(usuario, nombre, apellido, contrasena);

            }
        });
    }

    @Override
    public void init() {
        etNombre = findViewById(R.id.etNombre);
        etContrasena = findViewById(R.id.etContrasena);
        etUsuario = findViewById(R.id.etUsuario);
        etApellido = findViewById(R.id.etApellido);
        etRepContrasena = findViewById(R.id.etRepContrasena);
        btnRegistro = findViewById(R.id.btnRegistro);
    }

    @Override
    public void onSuccess(Usuario respuesta) {
        finish();
        Toast.makeText(this, "Se registro el usuario", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
