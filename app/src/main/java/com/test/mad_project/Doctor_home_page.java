package com.test.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Doctor_home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void start(View view)
    {
        new dphelp(this);
        startActivity(new Intent(this,insert_data.class));

    }
    public void set_status(View view)
    {
        startActivity(new Intent(this,clinic_status.class));
    }
    public void release_notice(View view)
    {
        startActivity(new Intent(this,release_notice.class));
    }

    public void gotocheckregister(View view) {

        startActivity(new Intent(this,check_registerd_patients.class));

    }
    public void invite(View view) {

        startActivity(new Intent(this,invite.class));

    }

}