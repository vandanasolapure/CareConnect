package com.test.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class insert_data extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);



    }
    public void AddRecord(View view)
        {
            Calendar cal=Calendar.getInstance();
            SimpleDateFormat simple=new SimpleDateFormat("dd-MMM-yyyy");
            String timex=simple.format(cal.getTime());

            dphelp db=new dphelp(this);
            String res=db.addRecord(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),timex);
            Toast.makeText(this,res,Toast.LENGTH_LONG).show();

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

        }
        public void get_data(View view)
        {
            startActivity(new Intent(this,search_records.class));
        }
}