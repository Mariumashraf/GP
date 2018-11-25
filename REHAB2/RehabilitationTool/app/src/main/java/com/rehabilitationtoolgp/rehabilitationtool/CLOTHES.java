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

public class CLOTHES extends AppCompatActivity {
    private static final String TAG = "CLOTHES";
    // private ArrayList<String> mNames = new ArrayList<>();
    //private ArrayList<Integer> mImageUrls = new ArrayList<>();
    //private ArrayList<Integer> mrecords = new ArrayList<>();
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        Button dress = (Button) findViewById(R.id.dress);
        Button tshirt = (Button) findViewById(R.id.tshirt);
        Button shirt= (Button) findViewById(R.id.shirt);
        Button trousers = (Button) findViewById(R.id.trousers);
        Button skrit = (Button) findViewById(R.id.skirt);
        Button suit = (Button) findViewById(R.id.suit);

        Button back = (Button) findViewById(R.id.back);

        Button play = (Button) findViewById(R.id.playall);
        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();
        final MediaPlayer mediaPlayer12 = MediaPlayer.create(CLOTHES.this,R.raw.dress);
        dress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer12.start();
                globalv.addmImageUrls(R.drawable.dress);
                globalv.addmNames("فستان");
                globalv.addMrecords(R.raw.dress);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer13 = MediaPlayer.create(CLOTHES.this,R.raw.tshirt);
        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer13.start();
                globalv.addmImageUrls(R.drawable.tshirt);
                globalv.addmNames("تيشيرت");
                globalv.addMrecords(R.raw.tshirt);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer14 = MediaPlayer.create(CLOTHES.this,R.raw.blouse);
        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer14.start();
                globalv.addmImageUrls(R.drawable.blouse);
                globalv.addmNames("بلوزة");
                globalv.addMrecords(R.raw.blouse);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer15 = MediaPlayer.create(CLOTHES.this,R.raw.suit);
        suit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer15.start();
                globalv.addmImageUrls(R.drawable.suit);
                globalv.addmNames("بدلة");
                globalv.addMrecords(R.raw.suit);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer16 = MediaPlayer.create(CLOTHES.this,R.raw.pants);
        trousers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer16.start();
                globalv.addmImageUrls(R.drawable.pant);
                globalv.addmNames("بنطلون");
                globalv.addMrecords(R.raw.pants);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer17 = MediaPlayer.create(CLOTHES.this,R.raw.skirt);
        skrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer17.start();
                globalv.addmImageUrls(R.drawable.skirt);
                globalv.addmNames("جيبة");
                globalv.addMrecords(R.raw.skirt);
                initRecyclerView();



            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(CLOTHES.this, globalv.getMrecords().get(i));
                    mediaPlay.start();
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                    }
                }
            }



        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(CLOTHES.this,MainActivity.class);
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
