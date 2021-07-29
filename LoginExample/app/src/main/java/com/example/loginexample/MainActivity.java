package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn1,btn2;
EditText login,pass;
String mesg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.email);
        pass= findViewById(R.id.password);
        btn1 = findViewById(R.id.login);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btnreg);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       mesg = "Login Success: "+login.getText()+ "" + pass.getText();
        Toast.makeText(this, mesg, Toast.LENGTH_SHORT).show();
        if(v.getId()==R.id.btnreg){
            Intent intent = new Intent(this, Registration.class);
            startActivity(intent);
        }
    }
}