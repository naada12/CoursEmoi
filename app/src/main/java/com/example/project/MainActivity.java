package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.database.AppDataBase;

public class MainActivity extends AppCompatActivity {
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myintent=new Intent(this,Register.class);
        AppDataBase db=AppDataBase.getAppDatabase(this);
        EditText email=(EditText)findViewById(R.id.usernamelog);
        EditText pass=(EditText)findViewById(R.id.passlog);
        Button bt=(Button) findViewById(R.id.button2);
        Button bt1=(Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent=new Intent(MainActivity.this,Register.class);
                startActivity(myintent);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.userDao().getUser(email.getText().toString(),pass.getText().toString())!=null){
                myintent=new Intent(MainActivity.this,Home.class);
                startActivity(myintent);}

            }
        });
    }

}