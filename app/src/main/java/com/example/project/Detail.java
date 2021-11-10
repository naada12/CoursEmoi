package com.example.project;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.database.AppDataBase;
import com.example.project.entity.Cour;

import java.io.File;
import java.security.Permission;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    Cour cour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent intent=new Intent(this,Payment.class);
        AppDataBase db=AppDataBase.getAppDatabase(this);
        cour=db.courDao().getCourbyId(getIntent().getExtras().getInt("var"));

        Button btn=(Button) findViewById(R.id.button5);


        if(cour.isAch() && cour.getId_user()==MainActivity.getIduser()){
            btn.setText("View Course");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(),db.courDao().getCourbyId(getIntent().getExtras().getInt("var")).getCour(), Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Intent.ACTION_VIEW);
                        Uri uri = Uri.parse(cour.getCour());
                        //intent.setDataAndType(uri, "application/pdf");
                   // intent.putExtra(Intent.EXTRA_TITLE,new File(cour.getCour()));
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);


                    intent.setData(uri);

                        try
                        {
                            startActivity(intent);
                        }
                        catch(ActivityNotFoundException e)
                        {
e.printStackTrace();
                        }
                }
            });

        }else{
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra("id",cour.getId());
                    intent.putExtra("titre",cour.getTitre());
                    intent.putExtra("price",cour.getPrix());
                    startActivity(intent);

                }
            });
        }
        ImageView img=(ImageView) findViewById(R.id.imageView2);
        TextView titre=(TextView) findViewById(R.id.textView6);
        TextView desc=(TextView) findViewById(R.id.tvdesc);
        titre.setText(cour.getTitre());
        img.setImageURI(Uri.parse(cour.getResume()));
        desc.setText(cour.getDesc());


    }
}
