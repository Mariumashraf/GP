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

public class FAMILY extends AppCompatActivity {
    private static final String TAG = "FAMILY";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


        Button sister = (Button) findViewById(R.id.sister);
        Button brother= (Button) findViewById(R.id.brother);
        Button father = (Button) findViewById(R.id.father);
        Button mother = (Button) findViewById(R.id.mother);
        Button grandfather = (Button) findViewById(R.id.grandfather);
        Button grandmother = (Button) findViewById(R.id.grandmother);
        Button play = (Button) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //SISTER
        final MediaPlayer sisterplayer =MediaPlayer.create(FAMILY.this, R.raw.sisterrr);
        sister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sisterplayer.start();
                globalv.addmImageUrls(R.drawable.sisterrr);
                globalv.addmNames("أختى");
                globalv.addMrecords(R.raw.sisterrr);
                initRecyclerView();

            }
        });


        //BROTHER
        final MediaPlayer brotherplayer =MediaPlayer.create(FAMILY.this, R.raw.brotherrr );
        brother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brotherplayer.start();
                globalv.addmImageUrls(R.drawable.sonnnn);
                globalv.addmNames("أخويا");
                globalv.addMrecords(R.raw.brotherrr);
                initRecyclerView();

            }
        });


        //FATHER
        final MediaPlayer fatherplayer =MediaPlayer.create(FAMILY.this, R.raw.fatherrr );
        father.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fatherplayer.start();
                globalv.addmImageUrls(R.drawable.papaaa);
                globalv.addmNames("بابا");
                globalv.addMrecords(R.raw.fatherrr);
                initRecyclerView();

            }
        });


        //MOTHER
        final MediaPlayer motherplayer =MediaPlayer.create(FAMILY.this, R.raw.motherrr);
        mother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motherplayer.start();
                globalv.addmImageUrls(R.drawable.mamaaa);
                globalv.addmNames("ماما");
                globalv.addMrecords(R.raw.motherrr);
                initRecyclerView();

            }
        });


        //GRANDFATHER
        final MediaPlayer grandfplayer =MediaPlayer.create(FAMILY.this, R.raw.grandpaaa);
        grandfather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grandfplayer.start();
                globalv.addmImageUrls(R.drawable.grandpaaa);
                globalv.addmNames("جدو");
                globalv.addMrecords(R.raw.grandpaaa);
                initRecyclerView();

            }
        });


        //GRANDMOTHER
        final MediaPlayer grandmplayer =MediaPlayer.create(FAMILY.this, R.raw.grandmaaa);
        grandmother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grandmplayer.start();
                globalv.addmImageUrls(R.drawable.grandmaaa);
                globalv.addmNames("جدتى");
                globalv.addMrecords(R.raw.grandmaaa);
                initRecyclerView();

            }
        });


        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(FAMILY.this, globalv.getMrecords().get(i));
                    mediaPlay.start();
                    try {
                        Thread.sleep(1000);
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

                Intent intent1 = new Intent(FAMILY.this,MainActivity.class);
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
