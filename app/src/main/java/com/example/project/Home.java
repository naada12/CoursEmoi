package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Home extends AppCompatActivity {
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        FloatingActionButton bts=(FloatingActionButton)findViewById(R.id.floatingActionButton2);
        ImageView img=(ImageView) findViewById(R.id.imageView);
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent=new Intent(Home.this,Add_Course.class);
                startActivity(myintent);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent=new Intent(Home.this,Detail.class);
                startActivity(myintent);
            }
        });
    }
}