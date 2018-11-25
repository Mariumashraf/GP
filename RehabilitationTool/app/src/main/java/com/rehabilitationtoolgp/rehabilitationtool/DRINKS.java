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
    // private ArrayList<String> mNames = new ArrayList<>();
    //private ArrayList<Integer> mImageUrls = new ArrayList<>();
    //private ArrayList<Integer> mrecords = new ArrayList<>();
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
        final MediaPlayer mediaPlayer24 = MediaPlayer.create(DRINKS.this,R.raw.juice);
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer24.start();
                globalv.addmImageUrls(R.drawable.juice);
                globalv.addmNames("عصير");
                globalv.addMrecords(R.raw.juice);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer25 = MediaPlayer.create(DRINKS.this,R.raw.water);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer25.start();
                globalv.addmImageUrls(R.drawable.water2);
                globalv.addmNames("ماء");
                globalv.addMrecords(R.raw.water);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer26 = MediaPlayer.create(DRINKS.this,R.raw.milk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer26.start();
                globalv.addmImageUrls(R.drawable.milk1);
                globalv.addmNames("لبن");
                globalv.addMrecords(R.raw.milk);
                initRecyclerView();



            }
        });
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

