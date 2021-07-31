package com.iforbihar.intentex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.edt_number);
        btn = findViewById(R.id.btncall);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String number = edt.getText().toString();
        Intent call = new Intent();
        call.setAction(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:"+number));
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                    123);

        }
        startActivity(call);

    }
}