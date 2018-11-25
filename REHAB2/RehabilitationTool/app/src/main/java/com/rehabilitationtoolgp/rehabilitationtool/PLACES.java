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

public class PLACES extends AppCompatActivity {
    private static final String TAG = "PLACES";
    // private ArrayList<String> mNames = new ArrayList<>();
    //private ArrayList<Integer> mImageUrls = new ArrayList<>();
    //private ArrayList<Integer> mrecords = new ArrayList<>();
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        Button bedroom = (Button) findViewById(R.id.bedroom);
        Button bathroom = (Button) findViewById(R.id.bathroom);
        Button livingroom= (Button) findViewById(R.id.livingroom);
        Button school = (Button) findViewById(R.id.school);
        Button university = (Button) findViewById(R.id.university);
        Button supermarket = (Button) findViewById(R.id.supermarket);

        Button back = (Button) findViewById(R.id.back);

        Button play = (Button) findViewById(R.id.playall);
        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();
        final MediaPlayer mediaPlayer18 = MediaPlayer.create(PLACES.this,R.raw.bedroom);
        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer18.start();
                globalv.addmImageUrls(R.drawable.bed);
                globalv.addmNames("غرفة النوم");
                globalv.addMrecords(R.raw.bedroom);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer19 = MediaPlayer.create(PLACES.this,R.raw.bathroom);
        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer19.start();
                globalv.addmImageUrls(R.drawable.bathroom);
                globalv.addmNames("حمام");
                globalv.addMrecords(R.raw.bathroom);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer20 = MediaPlayer.create(PLACES.this,R.raw.livingroom);
        livingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer20.start();
                globalv.addmImageUrls(R.drawable.livingroom);
                globalv.addmNames("الصالة");
                globalv.addMrecords(R.raw.livingroom);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer21 = MediaPlayer.create(PLACES.this,R.raw.school);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer21.start();
                globalv.addmImageUrls(R.drawable.school);
                globalv.addmNames("مدرسة");
                globalv.addMrecords(R.raw.school);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer22 = MediaPlayer.create(PLACES.this,R.raw.supermarket);
        supermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer22.start();
                globalv.addmImageUrls(R.drawable.supermarket3);
                globalv.addmNames("سوبرماركت");
                globalv.addMrecords(R.raw.supermarket);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer23 = MediaPlayer.create(PLACES.this,R.raw.university);
        university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer23.start();
                globalv.addmImageUrls(R.drawable.university2);
                globalv.addmNames("جامعة");
                globalv.addMrecords(R.raw.university);
                initRecyclerView();



            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(PLACES.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(PLACES.this,MainActivity.class);
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

