package com.example.williamwinters.teacherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class QrGenActivity extends AppCompatActivity {

    String createFromThisCode;
    BarcodeView qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_qr_gen);

        Bundle bundle = getIntent().getExtras();

        createFromThisCode = bundle.getString("qr");

        qrCode = new BarcodeView(QrGenActivity.this, createFromThisCode);

        setContentView(qrCode);
    }
}
