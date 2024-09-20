package com.test.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class release_notice extends AppCompatActivity {
    EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_notice);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void insert_data(View view)
    {
        t1=(EditText)findViewById(R.id.t1);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("release_notice");
        node.setValue(t1.getText().toString());
        t1.setText(" ");
        Toast.makeText(getApplicationContext(),"Released",Toast.LENGTH_LONG).show();

    }

}