package com.example.bibesh.firebasenotification;


import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowToken = (Button) findViewById(R.id.showToken);
//        btnShowToken.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //GET THE TOKEN
//                String token = FirebaseInstanceId.getInstance().getToken();
//                Log.v(TAG, "Token:" + token);
//
//            }
//        });
        System.out.println("MainActivity.onCreate: " + FirebaseInstanceId.getInstance().getToken());
    }
}