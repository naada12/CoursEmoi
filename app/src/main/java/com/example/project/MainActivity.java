package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.database.AppDataBase;

public class MainActivity extends AppCompatActivity {
    Intent myintent;
    public static int iduser;

    public static int getIduser() {
        return iduser;
    }

    public static void setIduser(int iduser) {
        MainActivity.iduser = iduser;
    }



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
                if(email.getText().toString().length()>0 && pass.getText().toString().toString().length()>0){
                if(db.userDao().getUser(email.getText().toString(),pass.getText().toString())!=null){
                MainActivity.setIduser(db.userDao().getUser(email.getText().toString(),pass.getText().toString()).getId());
                myintent=new Intent(MainActivity.this,Home.class);
                myintent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(myintent);}else{
                    Toast.makeText(getApplicationContext(),"Login failed", Toast.LENGTH_LONG).show();
                }}else{
                    Toast.makeText(getApplicationContext(),"Champs null", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}