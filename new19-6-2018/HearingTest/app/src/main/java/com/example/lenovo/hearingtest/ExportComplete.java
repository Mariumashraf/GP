package com.example.lenovo.hearingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExportComplete extends AppCompatActivity {

    public void gotoMain(View view){
        Intent intent = new Intent(this, StartTest.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_complete);
    }
}
