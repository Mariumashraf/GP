package com.sara.rehabilitation_tool;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Drink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink);

        final MediaPlayer playWater = MediaPlayer.create(Drink.this,R.raw.water);
        Button water = findViewById(R.id.water);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playWater.start();

            }
        });

        final MediaPlayer playMilk = MediaPlayer.create(Drink.this,R.raw.milk);
        Button milk = findViewById(R.id.milk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playMilk.start();

            }
        });

        final MediaPlayer playJuice = MediaPlayer.create(Drink.this,R.raw.juice);
        Button juice = findViewById(R.id.juice);
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playJuice.start();

            }
        });
    }
}
