package com.test.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class doctor_auth extends AppCompatActivity {
    EditText t1,t2;
    FirebaseAuth mAuth;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_auth);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        t1=(EditText)findViewById(R.id.email_login);
        t2=(EditText)findViewById(R.id.pwd_login);
        bar=(ProgressBar)findViewById(R.id.progressBar);
        mAuth=FirebaseAuth.getInstance();

    }

    public void check_goto_doctor_home(View view)

    {
        bar.setVisibility(view.VISIBLE);
        String email=t1.getText().toString();
        String password=t2.getText().toString();


        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(doctor_auth.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            bar.setVisibility(view.INVISIBLE);
                            Intent intent=new Intent(doctor_auth.this,Doctor_home_page.class);
                            startActivity(intent);
                            Toast.makeText(doctor_auth.this,"Login complete",Toast.LENGTH_LONG).show();

                        } else {
                            bar.setVisibility(view.INVISIBLE);
                            t1.setText("");
                            t1.setText("");
                            Toast.makeText(doctor_auth.this,"invalid/failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }
}