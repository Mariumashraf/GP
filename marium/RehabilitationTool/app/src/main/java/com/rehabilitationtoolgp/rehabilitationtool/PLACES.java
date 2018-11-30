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
        Button kitchen = (Button) findViewById(R.id.kitchen);
        Button company = (Button) findViewById(R.id.company);
        Button back = (Button) findViewById(R.id.back);
        Button play = (Button) findViewById(R.id.playall);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //KITCHEN
        final MediaPlayer kitchenplayer = MediaPlayer.create(PLACES.this,R.raw.kitchennn);
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kitchenplayer.start();
                globalv.addmImageUrls(R.drawable.kitchenn);
                globalv.addmNames("المطبخ");
                globalv.addMrecords(R.raw.kitchennn);
                initRecyclerView();



            }
        });

        //COMPANY
        final MediaPlayer companyplayer = MediaPlayer.create(PLACES.this,R.raw.companyyyy);
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyplayer.start();
                globalv.addmImageUrls(R.drawable.company);
                globalv.addmNames("الشركة");
                globalv.addMrecords(R.raw.companyyyy);
                initRecyclerView();



            }
        });

        //BEDROOM
        final MediaPlayer bedplayer = MediaPlayer.create(PLACES.this,R.raw.bedroommm);
        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bedplayer.start();
                globalv.addmImageUrls(R.drawable.bedroommm);
                globalv.addmNames("اوضة النوم");
                globalv.addMrecords(R.raw.bedroommm);
                initRecyclerView();



            }
        });

        //BATHROOM
        final MediaPlayer pathplayer = MediaPlayer.create(PLACES.this,R.raw.bathroommm);
        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathplayer.start();
                globalv.addmImageUrls(R.drawable.bathroommm);
                globalv.addmNames("الحمام");
                globalv.addMrecords(R.raw.bathroommm);
                initRecyclerView();



            }
        });


        //LIVINGROOM
        final MediaPlayer livingplayer = MediaPlayer.create(PLACES.this,R.raw.salonnn);
        livingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                livingplayer.start();
                globalv.addmImageUrls(R.drawable.livingroommm);
                globalv.addmNames("الصالة");
                globalv.addMrecords(R.raw.salonnn);
                initRecyclerView();



            }
        });


        //SCHOOL
        final MediaPlayer schoolplayer = MediaPlayer.create(PLACES.this,R.raw.schoolll);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schoolplayer.start();
                globalv.addmImageUrls(R.drawable.schooll);
                globalv.addmNames("المدرسة");
                globalv.addMrecords(R.raw.schoolll);
                initRecyclerView();



            }
        });

        //SUPERMARKET
        final MediaPlayer superplayer = MediaPlayer.create(PLACES.this,R.raw.supermarkettt);
        supermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                superplayer.start();
                globalv.addmImageUrls(R.drawable.supermarkeet);
                globalv.addmNames("السوبرماركت");
                globalv.addMrecords(R.raw.supermarkettt);
                initRecyclerView();



            }
        });

        //UNIVERSITY
        final MediaPlayer universityplayer = MediaPlayer.create(PLACES.this,R.raw.universityyy);
        university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universityplayer.start();
                globalv.addmImageUrls(R.drawable.universityy);
                globalv.addmNames("الجامعة");
                globalv.addMrecords(R.raw.universityyy);
                initRecyclerView();



            }
        });

        //PLAY ALL

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

        //BACK

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

