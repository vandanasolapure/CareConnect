package com.test.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class patients_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void gotoregister(View view)
    {
        new dphelp(this);
        startActivity(new Intent(this,MainActivity.class));

    }
    public void Gotocheckstatus(View view)
    {
        new dphelp(this);
        startActivity(new Intent(this,check_status.class));

    }

    public void gotonotics(View view)
    {
        new dphelp(this);
        startActivity(new Intent(this,check_notics.class));

    }
    public void address(View view)
    {
        new dphelp(this);
        startActivity(new Intent(this,clinic_location.class));

    }


    public void e_call(View view)
    {
        final Intent i =new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:9075342087"));
        startActivity(i);

    }
}