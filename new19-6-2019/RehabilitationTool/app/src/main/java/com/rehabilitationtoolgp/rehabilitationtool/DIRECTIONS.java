package com.rehabilitationtoolgp.rehabilitationtool;

import android.annotation.SuppressLint;
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

public class DIRECTIONS extends AppCompatActivity {
    private static final String TAG = "DIRECTIONS";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_directions);

        ImageView above = (ImageView) findViewById(R.id.above);
        ImageView below = (ImageView) findViewById(R.id.below);
        ImageView beside = (ImageView) findViewById(R.id.beside);
        ImageView around = (ImageView) findViewById(R.id.around);
        ImageView between = (ImageView) findViewById(R.id.between);
        ImageView inside = (ImageView) findViewById(R.id.inside);
        ImageView right = (ImageView) findViewById(R.id.right);
        ImageView left = (ImageView) findViewById(R.id.left);
        ImageView along = (ImageView) findViewById(R.id.along);
        ImageView outside = (ImageView) findViewById(R.id.outside);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);



        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();
        final MediaPlayer alongplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.straight);
        along.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alongplayer.start();
                globalv.addmImageUrls(R.drawable.alatol);
                globalv.addmNames("على طول");
                globalv.addMrecords(R.raw.straight);
                initRecyclerView();

            }
        });
        final MediaPlayer outplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.out);
        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outplayer.start();
                globalv.addmImageUrls(R.drawable.outside);
                globalv.addmNames("خارج");
                globalv.addMrecords(R.raw.out);
                initRecyclerView();

            }
        });


        //ABOVE
        final MediaPlayer aboveplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.uppp);
        above.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboveplayer.start();
                globalv.addmImageUrls(R.drawable.up);
                globalv.addmNames("فوق");
                globalv.addMrecords(R.raw.uppp);
                initRecyclerView();

            }
        });

        //BELOW
        final MediaPlayer belowplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.underrr);
        below.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                belowplayer.start();
                globalv.addmImageUrls(R.drawable.down);
                globalv.addmNames("تحت");
                globalv.addMrecords(R.raw.underrr);
                initRecyclerView();

            }
        });


        //BESIDE
        final MediaPlayer besideplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.beganppp);
        beside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                besideplayer.start();
                globalv.addmImageUrls(R.drawable.ganb);
                globalv.addmNames("بجانب");
                globalv.addMrecords(R.raw.beganppp);
                initRecyclerView();

            }
        });

        //AROUND
        final MediaPlayer aroundplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.arounddd );
        around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aroundplayer.start();
                globalv.addmImageUrls(R.drawable.around);
                globalv.addmNames("حول");
                globalv.addMrecords(R.raw.arounddd );
                initRecyclerView();

            }
        });


        //BETWEEN
        final MediaPlayer betweenplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.betweennn );
        between.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betweenplayer.start();
                globalv.addmImageUrls(R.drawable.middle);
                globalv.addmNames("بين");
                globalv.addMrecords(R.raw.betweennn);
                initRecyclerView();

            }
        });

        //INSIDE
        final MediaPlayer insideplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.insideee );
        inside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insideplayer.start();
                globalv.addmImageUrls(R.drawable.inside);
                globalv.addmNames("داخل");
                globalv.addMrecords(R.raw.insideee);
                initRecyclerView();

            }
        });


        //RIGHT
        final MediaPlayer rightplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.righttt);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightplayer.start();
                globalv.addmImageUrls(R.drawable.right);
                globalv.addmNames("يمين");
                globalv.addMrecords(R.raw.righttt);
                initRecyclerView();

            }
        });

        //LEFT
        final MediaPlayer leftplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.lefttt);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftplayer.start();
                globalv.addmImageUrls(R.drawable.left);
                globalv.addmNames("شمال");
                globalv.addMrecords(R.raw.lefttt);
                initRecyclerView();

            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(DIRECTIONS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(DIRECTIONS.this,MainActivity.class);
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
    public static void CleanUpMemory(){
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
