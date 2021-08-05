package com.iforbihar.sqlliteex;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Helper helper;
    EditText name,contact;
    TextView tv;
    Button save,fetch;
    GridView allrecordsview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper=new Helper(this,"Employeedb",null,1);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv_message);
        name=findViewById(R.id.edt_name);
        contact=findViewById(R.id.edt_contact);
        save=findViewById(R.id.btnsave);
        save.setOnClickListener(this);
        allrecordsview=findViewById(R.id.mylist);
        fetch=findViewById(R.id.btnfetch);
        fetch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsave:
                String msg=helper.onSave(name.getText().toString(),contact.getText().toString());
                tv.setText(msg);
                clearText();
                break;
            case R.id.btnfetch:
                Cursor cursor=helper.fetchAllData();
                loadCursorDataToGridView(cursor);
                break;
        }
    }

    private void loadCursorDataToGridView(Cursor cursor) {
        cursor.moveToFirst();
        if (cursor!=null&&cursor.getColumnCount()>0){
            ArrayList data=new ArrayList();
            while (cursor.moveToNext()){
                data.add(cursor.getString(0));
                data.add(cursor.getString(1));
            }
            ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
            allrecordsview.setAdapter(adapter);
        }else{
            tv.setText("No record available to display");
        }
    }
    private void clearText(){
        name.setText("");
        contact.setText("");
    }
}