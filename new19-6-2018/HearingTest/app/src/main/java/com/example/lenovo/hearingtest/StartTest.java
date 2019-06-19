package com.example.lenovo.hearingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);

        Button Start = (Button) findViewById(R.id.startt);
        Button results = (Button) findViewById(R.id.results);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(StartTest.this,TestProctoring.class);
                startActivity(intent1);

            }
        });

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(StartTest.this,TestLookup.class);
                startActivity(intent1);

            }
        });
    }
}
