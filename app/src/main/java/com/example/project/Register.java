package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.database.AppDataBase;
import com.example.project.entity.User;

import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Intent myintent=new Intent(this,MainActivity.class);
        EditText username=(EditText)findViewById(R.id.username);
        EditText email=(EditText)findViewById(R.id.email);
        EditText pass=(EditText)findViewById(R.id.password);
        DatePicker date=(DatePicker)findViewById(R.id.datePicker);
        AppDataBase db=AppDataBase.getAppDatabase(this);

        Button bt=(Button) findViewById(R.id.button3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length()>0 && email.getText().toString().length()>0 &&pass.getText().toString().length()>0 ){
                int y=date.getYear();
                int m=date.getMonth();
                int j=date.getDayOfMonth();
                Date d=new Date();
                Calendar c=Calendar.getInstance();
                c.set(y,m,j);
                d=c.getTime();
                User user=new User(username.getText().toString(),email.getText().toString(),pass.getText().toString(),d.toString());
                db.userDao().insertOne(user);
                startActivity(myintent);}else{
                    Toast.makeText(getApplicationContext(),"Champs null", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

