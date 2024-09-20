package com.test.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    EditText t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    public void process(View view)
    {


        
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat simple=new SimpleDateFormat("hh:mm:ss a");
        String timex=simple.format(cal.getTime());




        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);

        String name=t1.getText().toString().trim();
        String address=t2.getText().toString().trim();
        String phone=t3.getText().toString().trim();
        String age=t4.getText().toString().trim();
        dataget obj =new dataget(name,address,age,phone);

        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("patients");

        node.child(timex).setValue(obj);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        Toast.makeText(getApplicationContext(),"Data submited sucessfully",Toast.LENGTH_SHORT).show();

    }
}