package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView cards= (ImageView) findViewById(R.id.c);
        ImageView practice = (ImageView) findViewById(R.id.speechvrifecation);


        //Cards
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent1);

            }
        });
        //SPEECH VRIFECATION
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent12 = new Intent(Main2Activity.this,PRACTICING.class);
                startActivity(intent12);

            }
        });
    }


}
