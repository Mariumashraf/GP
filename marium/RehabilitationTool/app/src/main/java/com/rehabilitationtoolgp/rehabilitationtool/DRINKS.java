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

public class DRINKS extends AppCompatActivity {
    private static final String TAG = "DRINKS";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);


        Button juice = (Button) findViewById(R.id.juice);
        Button water = (Button) findViewById(R.id.water);
        Button milk = (Button) findViewById(R.id.milk);
        Button back = (Button) findViewById(R.id.back);
        Button play = (Button) findViewById(R.id.playall);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //JUICE
        final MediaPlayer juiceplayer = MediaPlayer.create(DRINKS.this,R.raw.juiceee);
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                juiceplayer.start();
                globalv.addmImageUrls(R.drawable.juiceee);
                globalv.addmNames("عصير");
                globalv.addMrecords(R.raw.juiceee);
                initRecyclerView();

            }
        });

        //WATER
        final MediaPlayer waterplayer = MediaPlayer.create(DRINKS.this,R.raw.waterrr);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterplayer.start();
                globalv.addmImageUrls(R.drawable.waterrr);
                globalv.addmNames("ماء");
                globalv.addMrecords(R.raw.waterrr);
                initRecyclerView();

            }
        });

        //MILK
        final MediaPlayer milkplayer = MediaPlayer.create(DRINKS.this,R.raw.milkkk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                milkplayer.start();
                globalv.addmImageUrls(R.drawable.milkkk);
                globalv.addmNames("لبن");
                globalv.addMrecords(R.raw.milkkk);
                initRecyclerView();



            }
        });


        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(DRINKS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(DRINKS.this,MainActivity.class);
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

