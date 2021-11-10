package com.example.project;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project.database.AppDataBase;
import com.example.project.entity.Cour;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class Add_Course extends AppCompatActivity {
    private ImageView selectedImg;
    static final int RESULT_LOAD_IMG = 1;
    static  final int PICKFILE_REQUEST_CODE=2;
    String path,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_course);
        Intent myintent=new Intent(this,Home.class);
        AppDataBase db=AppDataBase.getAppDatabase(this);
        EditText titre=(EditText) findViewById(R.id.titre);
        EditText desc=(EditText)findViewById(R.id.desc);
        EditText prix=(EditText)findViewById(R.id.price);
        selectedImg=(ImageView)findViewById(R.id.imageView3);
        Button uploadres=(Button)findViewById(R.id.UploadBtn);
        Button uploadcour=(Button)findViewById(R.id.uploadBtn1);
        Button btn=(Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titre.getText().toString().length() > 0 && desc.getText().toString().length() > 0 && path.length() > 0 && res.length() > 0) {
                    Cour cour = new Cour(titre.getText().toString(), desc.getText().toString(), Float.parseFloat(prix.getText().toString()), res, path);
                    db.courDao().insertOne(cour);
                    startActivity(myintent);

                }
            }
        });
        uploadres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });

        uploadcour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent file = new Intent(Intent.ACTION_GET_CONTENT);
                file.setType("application/pdf");
                startActivityForResult(file, PICKFILE_REQUEST_CODE);
            }
        });

    }
    @SuppressLint("Range")
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if(resultCode==RESULT_OK){
        if (reqCode == RESULT_LOAD_IMG) {
            try {
                final Uri imageUri = data.getData();
                res=imageUri.toString();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                selectedImg.setImageBitmap(selectedImage);
                Toast.makeText(getApplicationContext(),imageUri.getPath(), Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Une erreur s'est produite", Toast.LENGTH_LONG).show();

            }
        }else if(reqCode==PICKFILE_REQUEST_CODE){

            Uri uri = data.getData();

            path = uri.toString();

            Cursor cursor = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();

            Toast.makeText(getApplicationContext(),cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)), Toast.LENGTH_LONG).show();
            /*
            Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
            pdfOpenintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pdfOpenintent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            pdfOpenintent.setDataAndType(data.getData(), "application/pdf");
            try {
                startActivity(pdfOpenintent);
            }
            catch (ActivityNotFoundException e) {
e.printStackTrace();
            }*/

        }
        }else  {
            Toast.makeText(getApplicationContext(),"Vous n'avez pas choisi d'image", Toast.LENGTH_LONG).show();

        }
    }
}
