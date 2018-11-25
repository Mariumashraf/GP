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

import java.util.ArrayList;

public class FOODS extends AppCompatActivity {
    private static final String TAG = "FOODS";
   // private ArrayList<String> mNames = new ArrayList<>();
    //private ArrayList<Integer> mImageUrls = new ArrayList<>();
    //private ArrayList<Integer> mrecords = new ArrayList<>();
   Globalrecycler globalv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        Button rice = (Button) findViewById(R.id.rice);
        Button potato = (Button) findViewById(R.id.potato);
        Button egg = (Button) findViewById(R.id.egg);
        Button play = (Button) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        final MediaPlayer mediaPlayer9 = MediaPlayer.create(FOODS.this,R.raw.rice);
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer9.start();
                globalv.addmImageUrls(R.drawable.rice);
                globalv.addmNames("أرز");
                globalv.addMrecords(R.raw.rice);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer10 = MediaPlayer.create(FOODS.this,R.raw.egg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer10.start();
                globalv.addmImageUrls(R.drawable.egg2);
                globalv.addmNames("بيض");
                globalv.addMrecords(R.raw.egg);
                initRecyclerView();



            }
        });
        final MediaPlayer mediaPlayer11 = MediaPlayer.create(FOODS.this,R.raw.potato);
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer11.start();
                globalv.addmImageUrls(R.drawable.potato);
                globalv.addmNames("بطاطس");
                globalv.addMrecords(R.raw.potato);
                initRecyclerView();



            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(FOODS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(FOODS.this,MainActivity.class);
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
