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

public class Register extends AppCompatActivity implements View.OnClickListener {
EditText fullName,phone,email,password;
Button register;
FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullName=findViewById(R.id.txtFullname);
        phone=findViewById(R.id.txtPhone);
        email=findViewById(R.id.txtEmail);
        password=findViewById(R.id.txtPassword);
        register=findViewById(R.id.btnRegister);
        register.setOnClickListener(this);

        fAuth=FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        String vEmail = email.getText().toString().trim();
        String vPhone = phone.getText().toString().trim();
        String vPass = password.getText().toString().trim();
        String vFullname = fullName.getText().toString().trim();
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
        fAuth.createUserWithEmailAndPassword(vEmail,vPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "User created Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(Register.this, "Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}