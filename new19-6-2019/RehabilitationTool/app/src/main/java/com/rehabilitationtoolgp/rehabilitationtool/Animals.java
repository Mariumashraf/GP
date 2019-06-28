package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Animals extends AppCompatActivity {

    private static final String TAG = "Animals";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        ImageView cat = (ImageView) findViewById(R.id.cat);
        ImageView dog = (ImageView) findViewById(R.id.dog);
        ImageView bird = (ImageView) findViewById(R.id.bird);
        ImageView samak = (ImageView) findViewById(R.id.samka);
        ImageView insect = (ImageView) findViewById(R.id.insect);
        Button back = (Button) findViewById(R.id.back);
        ImageButton play = (ImageButton) findViewById(R.id.playall);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        final MediaPlayer catplayer = MediaPlayer.create(Animals.this,R.raw.cat);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catplayer.start();
                globalv.addmImageUrls(R.drawable.cat);
                globalv.addmNames("قطة");
                globalv.addMrecords(R.raw.cat);
                initRecyclerView();

            }
        });


        final MediaPlayer dogplayer = MediaPlayer.create(Animals.this,R.raw.dog);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogplayer.start();
                globalv.addmImageUrls(R.drawable.dog);
                globalv.addmNames("كلب");
                globalv.addMrecords(R.raw.dog);
                initRecyclerView();

            }
        });


        final MediaPlayer birdplayer = MediaPlayer.create(Animals.this,R.raw.bird);
        bird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birdplayer.start();
                globalv.addmImageUrls(R.drawable.bird);
                globalv.addmNames("عصفورة");
                globalv.addMrecords(R.raw.bird);
                initRecyclerView();

            }
        });


        final MediaPlayer samkplayer = MediaPlayer.create(Animals.this,R.raw.fish);
        samak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                samkplayer.start();
                globalv.addmImageUrls(R.drawable.fish);
                globalv.addmNames("سمكة");
                globalv.addMrecords(R.raw.fish);
                initRecyclerView();

            }
        });

        final MediaPlayer insectplayer = MediaPlayer.create(Animals.this,R.raw.insect);
        insect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insectplayer.start();
                globalv.addmImageUrls(R.drawable.insect);
                globalv.addmNames("حشرات");
                globalv.addMrecords(R.raw.insect);
                initRecyclerView();

            }
        });



        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(Animals.this, globalv.getMrecords().get(i));
                    mediaPlay.start();
                    try {
                        Thread.sleep(700);
                    } catch(InterruptedException e) {
                    }
                }
            }



        });


        //BACK

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(Animals.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,  globalv.getmNames(), globalv.getmImageUrls(),globalv.getMrecords());
        recyclerView.setAdapter(adapter);
    }
}
