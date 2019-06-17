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

public class FRUIT extends AppCompatActivity {
    private static final String TAG = "FRUIT";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);


        ImageView orange = (ImageView) findViewById(R.id.orange);
        ImageView watermelon = (ImageView) findViewById(R.id.watermelon);
        ImageView apple = (ImageView) findViewById(R.id.apple);
        ImageView guava = (ImageView) findViewById(R.id.guava);
        ImageView peach= (ImageView) findViewById(R.id.peach);
        ImageView grape =(ImageView) findViewById(R.id.grape);
        ImageView Strawberries=(ImageView) findViewById(R.id.Strawberries);
        ImageView pear= (ImageView) findViewById(R.id.pear);
        ImageView mango =(ImageView) findViewById(R.id.mango);
        ImageView banana=(ImageView) findViewById(R.id.banana);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);




        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //ORANGE

        final MediaPlayer orangeplayer= MediaPlayer.create(FRUIT.this,R.raw.orangeee);
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orangeplayer.start();
                globalv.addmImageUrls(R.drawable.orangez);
                globalv.addmNames("برتقال");
                globalv.addMrecords(R.raw.orangeee);
                initRecyclerView();



            }
        });

        //WATERMELON
        final MediaPlayer watermelonplayer = MediaPlayer.create(FRUIT.this,R.raw.watermelonnn);
        watermelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watermelonplayer.start();
                globalv.addmImageUrls(R.drawable.watermelonz);
                globalv.addmNames("بطيخ");
                globalv.addMrecords(R.raw.watermelonnn);
                initRecyclerView();



            }
        });

        //APPLE

        final MediaPlayer appleplayer= MediaPlayer.create(FRUIT.this,R.raw.appleee);
        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appleplayer.start();
                globalv.addmImageUrls(R.drawable.appleee);
                globalv.addmNames("تفاح");
                globalv.addMrecords(R.raw.appleee);
                initRecyclerView();



            }
        });

        //GUAVA
        final MediaPlayer guavaplayer = MediaPlayer.create(FRUIT.this,R.raw.guavaaa);
        guava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guavaplayer.start();
                globalv.addmImageUrls(R.drawable.guavaz);
                globalv.addmNames("جوافة");
                globalv.addMrecords(R.raw.guavaaa);
                initRecyclerView();



            }
        });

        //PEACH

        final MediaPlayer peachplayer= MediaPlayer.create(FRUIT.this,R.raw.peachhh);
        peach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peachplayer.start();
                globalv.addmImageUrls(R.drawable.peachz);
                globalv.addmNames("خوخ");
                globalv.addMrecords(R.raw.peachhh);
                initRecyclerView();



            }
        });

        //GRAPE
        final MediaPlayer grapeplayer = MediaPlayer.create(FRUIT.this,R.raw.gripsss);
        grape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grapeplayer.start();
                globalv.addmImageUrls(R.drawable.grapesz);
                globalv.addmNames("عنب");
                globalv.addMrecords(R.raw.gripsss);
                initRecyclerView();



            }
        });

        //STRAWABERRIES

        final MediaPlayer strawplayer= MediaPlayer.create(FRUIT.this,R.raw.stroparyyy);
        Strawberries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strawplayer.start();
                globalv.addmImageUrls(R.drawable.strawberryz);
                globalv.addmNames("فراولة");
                globalv.addMrecords(R.raw.stroparyyy);
                initRecyclerView();



            }
        });

        //PEAR
        final MediaPlayer pearplayer = MediaPlayer.create(FRUIT.this,R.raw.kometraaa);
        pear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pearplayer.start();
                globalv.addmImageUrls(R.drawable.pearz);
                globalv.addmNames("كمثرى");
                globalv.addMrecords(R.raw.kometraaa);
                initRecyclerView();



            }
        });

        //MANGO

        final MediaPlayer mangoplayer= MediaPlayer.create(FRUIT.this,R.raw.mangooo);
        mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mangoplayer.start();
                globalv.addmImageUrls(R.drawable.mangoz);
                globalv.addmNames("مانجو");
                globalv.addMrecords(R.raw.mangooo);
                initRecyclerView();



            }
        });

        //BANANA
        final MediaPlayer bananaplayer = MediaPlayer.create(FRUIT.this,R.raw.bananaaa);
        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bananaplayer.start();
                globalv.addmImageUrls(R.drawable.bananaaa);
                globalv.addmNames("موز");
                globalv.addMrecords(R.raw.bananaaa);
                initRecyclerView();



            }
        });

        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(FRUIT.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(FRUIT.this,FOODS.class);
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
