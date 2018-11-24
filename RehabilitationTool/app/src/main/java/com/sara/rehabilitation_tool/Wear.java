package com.sara.rehabilitation_tool;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Wear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wear);

        final MediaPlayer playPants = MediaPlayer.create(Wear.this,R.raw.pants);
        Button pants = findViewById(R.id.pants);
        pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPants.start();

            }
        });

        final MediaPlayer playBlouse = MediaPlayer.create(Wear.this,R.raw.blouse);
        Button blouse = findViewById(R.id.blouse);
        blouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playBlouse.start();

            }
        });

        final MediaPlayer playSuit = MediaPlayer.create(Wear.this,R.raw.suit);
        Button suit = findViewById(R.id.suit);
        suit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSuit.start();

            }
        });

        final MediaPlayer playSkirt = MediaPlayer.create(Wear.this,R.raw.skirt);
        Button skirt = findViewById(R.id.skirt);
        skirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSkirt.start();

            }
        });

        final MediaPlayer playTShirt = MediaPlayer.create(Wear.this,R.raw.tshirt);
        Button tShirt = findViewById(R.id.tshirt);
        tShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playTShirt.start();

            }
        });

        final MediaPlayer playDress = MediaPlayer.create(Wear.this,R.raw.dress);
        Button dress = findViewById(R.id.dress);
        dress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playDress.start();

            }
        });
    }
}
