package com.ps.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText email,password;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.txtEmail);
        password=findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnRegister);
        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String vEmail = email.getText().toString();
        String vPass = password.getText().toString();
        if(TextUtils.isEmpty(vEmail)){
            email.setError("Email is required");
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(vEmail).matches()){
            email.setError("Invalid email");
            return;
        }
        if(TextUtils.isEmpty(vPass)){
            password.setError("Password is required");
            return;
        }
        if(vPass.length()<6){
            password.setError("Password must have atleast 6 characters");
            return;
        }

        fAuth.signInWithEmailAndPassword(vEmail,vPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "User login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(Login.this, "Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
    public void register(View view) {
        startActivity(new Intent(getApplicationContext(),Register.class));
        finish();
    }
}