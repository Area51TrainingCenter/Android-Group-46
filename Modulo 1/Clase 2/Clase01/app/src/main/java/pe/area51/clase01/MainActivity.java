package pe.area51.clase01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textoUno, textoDos, textoTres;
    private EditText texto;
    private Button botonUno, botonDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate");

        textoUno = (TextView) findViewById(R.id.tvTexto1);
        textoDos = (TextView) findViewById(R.id.tvTexto2);
        textoTres = (TextView) findViewById(R.id.tvTexto3);
        texto = (EditText) findViewById(R.id.etTexto);
        botonUno = (Button) findViewById(R.id.btnBotonUno);
        botonDos = (Button) findViewById(R.id.btnBotonDos);

        textoUno.setText("Bienvenidos");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");

        botonUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        MainActivity.this,
                        "Mensaje de prueba",
                        Toast.LENGTH_SHORT).show();
            }
        });
        botonDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor = texto.getText().toString();
                Toast.makeText(MainActivity.this,
                        valor,
                        Toast.LENGTH_SHORT).show();

                textoDos.setText(valor);

                //Dialog - AlertDialog
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }
    /*
    onCreate
    onStart
    onResume

    onPause
    onStop

    onDestroy

    onRestart
     */
}
