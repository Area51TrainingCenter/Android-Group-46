package com.area51.clase02;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    private Button btnGenerarToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerarToken = findViewById(R.id.btnGenerarToken);
    }

    private final String TAG = "MainActivity";

    @Override
    protected void onResume() {
        super.onResume();

        btnGenerarToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Crashlytics.getInstance().crash();

                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "getInstanceId failed", task.getException());
                                    return;
                                }

                                // Get new Instance ID token
                                String token = task.getResult().getToken();


                                Log.d(TAG, token);
                                Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
