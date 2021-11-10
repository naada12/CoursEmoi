package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.telephony.mbms.DownloadRequest;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        PDFView pdf=(PDFView) findViewById(R.id.pdfView);
        pdf.fromUri(Uri.parse(getIntent().getExtras().getString("path"))).load();

    }
}