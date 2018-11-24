package com.sara.rehabilitation_tool;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Places extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places);

        final MediaPlayer playSalon= MediaPlayer.create(Places.this,R.raw.salon);
        Button salon = findViewById(R.id.salon);
        salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSalon.start();

            }
        });

        final MediaPlayer playSuperMarket= MediaPlayer.create(Places.this,R.raw.supermarket);
        Button superMarket = findViewById(R.id.superMarket);
        superMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSuperMarket.start();

            }
        });

        final MediaPlayer playBathRoom= MediaPlayer.create(Places.this,R.raw.bathroom);
        Button bathRoom = findViewById(R.id.bathRoom);
        bathRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playBathRoom.start();

            }
        });

        final MediaPlayer playBedRoom = MediaPlayer.create(Places.this,R.raw.bedroom);
        Button bedRoom = findViewById(R.id.bedRoom);
        bedRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playBedRoom.start();

            }
        });

        final MediaPlayer playUniversity = MediaPlayer.create(Places.this,R.raw.university);
        Button university = findViewById(R.id.university);
        university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playUniversity.start();

            }
        });

        final MediaPlayer playSchool = MediaPlayer.create(Places.this,R.raw.school);
        Button school= findViewById(R.id.school);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSchool.start();

            }
        });
    }
}
