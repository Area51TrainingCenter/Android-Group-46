package com.area51.clase06.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.area51.clase06.R;

public class MainActivity extends AppCompatActivity {
    private Button btnCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCargar = (Button) findViewById(R.id.btnCargar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(MainActivity.this,
                                MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
