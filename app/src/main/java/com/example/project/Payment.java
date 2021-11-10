package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.database.AppDataBase;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent intent=new Intent(this,Detail.class);
        TextView name=(TextView)findViewById(R.id.textView11);
        TextView price=(TextView)findViewById(R.id.textView12);
        name.setText(getIntent().getExtras().getString("titre"));
        price.setText(getIntent().getExtras().getString("price"));
        Button buy=(Button) findViewById(R.id.button6);
        AppDataBase db=AppDataBase.getAppDatabase(this);
        int idc=getIntent().getExtras().getInt("id");
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.courDao().by_Cour(MainActivity.getIduser(),idc);
                intent.putExtra("var",idc);
                startActivity(intent);
            }
        });
    }
}