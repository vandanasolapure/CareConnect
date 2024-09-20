package com.test.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.view.View;


import android.os.Bundle;
import android.widget.ImageButton;

public class login_or_registration extends AppCompatActivity {
    public ImageButton b1;
    public ImageButton b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_registration);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        b2=(ImageButton) findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login_or_registration.this,doctor_auth.class);
                startActivity(intent);
            }
        });







        b1=(ImageButton) findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login_or_registration.this,patients_home.class);
                startActivity(intent);
            }
        });

    }
}