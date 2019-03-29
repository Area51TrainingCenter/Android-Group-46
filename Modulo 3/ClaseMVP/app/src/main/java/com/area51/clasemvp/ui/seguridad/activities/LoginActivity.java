package com.area51.clasemvp.ui.seguridad.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.area51.clasemvp.ui.BaseActivity;
import com.area51.clasemvp.R;
import com.area51.clasemvp.ui.core.activities.HomeActivity;
import com.area51.clasemvp.ui.model.Usuario;
import com.area51.clasemvp.ui.seguridad.presenter.LoginPresenter;
import com.area51.clasemvp.ui.seguridad.presenter.impl.LoginPresenterImpl;
import com.area51.clasemvp.ui.seguridad.views.LoginView;

public class LoginActivity extends BaseActivity implements LoginView {
    private EditText etUsuario, etContrasena;
    private Button btnLogin;
    private LoginPresenter presenter;
    private TextView tvRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenterImpl();
        presenter.addView(this);
        presenter.initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = etUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();

                presenter.validarLogin(usuario, contrasena);

            }
        });

        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.irARegistro();

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.removeView();
    }

    @Override
    public void init() {
        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegistro = findViewById(R.id.tvRegistro);
    }

    @Override
    public void onError(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(Usuario usuario) {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Usuario existe", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void irARegistro() {
        Intent intent = new Intent(
                LoginActivity.this, RegistroActivity.class);
        startActivity(intent);
    }
}
