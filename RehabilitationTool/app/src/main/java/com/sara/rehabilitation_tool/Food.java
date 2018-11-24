package com.sara.rehabilitation_tool;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        final MediaPlayer playRice = MediaPlayer.create(Food.this,R.raw.rice);
        Button rice = findViewById(R.id.rice);
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playRice.start();

            }
        });

        final MediaPlayer playPotato = MediaPlayer.create(Food.this,R.raw.potato);
        Button potato = findViewById(R.id.potato);
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPotato.start();

            }
        });

        final MediaPlayer playEgg = MediaPlayer.create(Food.this,R.raw.egg);
        Button egg = findViewById(R.id.egg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playEgg.start();

            }
        });

    }
}
