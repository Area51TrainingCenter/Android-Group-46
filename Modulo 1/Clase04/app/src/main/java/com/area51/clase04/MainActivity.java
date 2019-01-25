package com.area51.clase04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.etNombre)
    EditText etNombre;
    @BindView(R.id.etApellido)
    EditText etApellido;
    @BindView(R.id.spGenero)
    Spinner spGenero;
    @BindView(R.id.lvLista)
    ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegistrar)
    public void onViewClicked() {
        //Obtenemos los valores

        //Validamos que los campos esten llenos

        //Mostramos mensaje en caso haya error

        //Guardamos datos en objeto

        //Mostrarmos mensaje de confirmación

        //Mostramos en la lista
    }
}
