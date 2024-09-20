package com.test.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class invite extends AppCompatActivity {
    EditText phone,txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        txt=(EditText)findViewById(R.id.sms);
        phone=(EditText)findViewById(R.id.phone_number);

    }

    public void send(View view) {

        int permissioncheck= ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permissioncheck== PackageManager.PERMISSION_GRANTED)
        {
            Mysms();
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);


        }


    }
    private void  Mysms()
    {
         String phone_number=phone.getText().toString().trim();
         String message=txt.getText().toString().trim();
         if (!phone.getText().toString().equals("")||!txt.getText().toString().equals("")) {
             SmsManager smsManager = SmsManager.getDefault();
             smsManager.sendTextMessage(phone_number, null, message, null, null);
             Toast.makeText(this,"send ok",Toast.LENGTH_LONG).show();
         }
         else
         {
             Toast.makeText(this,"send ok",Toast.LENGTH_LONG).show();

         }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 0:
                if(grantResults.length>=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    Mysms();
                }
                else
                {
                    Toast.makeText(this,"allow sms permission",Toast.LENGTH_LONG).show();
                }

        }


    }
}