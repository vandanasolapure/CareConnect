package com.test.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class clinic_status extends AppCompatActivity {
    //EditText t1;
    Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_status);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sw=(Switch)findViewById(R.id.switch1);
        SharedPreferences sp=getSharedPreferences("save",MODE_PRIVATE);
        sw.setChecked(sp.getBoolean("value",true));





        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw.isChecked())
                {
                    SharedPreferences.Editor editor=getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    sw.setChecked(true);


                    //String st=sw.getText().toString();
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                     DatabaseReference node=db.getReference("status");
                     node.setValue(sw.getTextOn().toString());
                     //t1.setText(" ");
                    //sw.setTextOn("Open");
                    //sw.setChecked(true);
                     Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();


                }
                else
                {

                    SharedPreferences.Editor editor=getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    sw.setChecked(false);

                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("status");
                    node.setValue(sw.getTextOff().toString());
                    //t1.setText(" ");
                    //sw.setTextOff("Close");
                   // sw.setChecked(false);
                    Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();

                }
            }
        });







    }
   // public void update_status(View view)
  //  {
       // t1=(EditText)findViewById(R.id.t1);
      //  FirebaseDatabase db=FirebaseDatabase.getInstance();
       // DatabaseReference node=db.getReference("status");
       // node.setValue(t1.getText().toString());
       // t1.setText(" ");
      //  Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();

   //  }
}