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

public class TIME extends AppCompatActivity {
    private static final String TAG = "TIME";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

       ImageView morning =(ImageView) findViewById(R.id.morning);
        ImageView night=(ImageView) findViewById(R.id.night);
        ImageView sunset =(ImageView) findViewById(R.id.sunset);
        ImageView today=(ImageView) findViewById(R.id.today);
        ImageView yesterday =(ImageView) findViewById(R.id.yesterday);
        ImageView tomorrow=(ImageView) findViewById(R.id.tomorrow);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



        //MORNING

        final MediaPlayer morningplayer= MediaPlayer.create(TIME.this,R.raw.morninggg);
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                morningplayer.start();
                globalv.addmImageUrls(R.drawable.morning);
                globalv.addmNames("الصبح");
                globalv.addMrecords(R.raw.morninggg);
                initRecyclerView();



            }
        });

        //NIGHT
        final MediaPlayer nightplayer = MediaPlayer.create(TIME.this,R.raw.nighttt);
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nightplayer.start();
                globalv.addmImageUrls(R.drawable.night);
                globalv.addmNames("الليل");
                globalv.addMrecords(R.raw.nighttt);
                initRecyclerView();



            }
        });

        //MORNING

        final MediaPlayer sunplayer= MediaPlayer.create(TIME.this,R.raw.sunset);
        sunset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sunplayer.start();
                globalv.addmImageUrls(R.drawable.sunset);
                globalv.addmNames("الغروب");
                globalv.addMrecords(R.raw.sunset);
                initRecyclerView();



            }
        });

        final MediaPlayer todayplayer = MediaPlayer.create(TIME.this,R.raw.today);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todayplayer.start();
                globalv.addmImageUrls(R.drawable.today);
                globalv.addmNames("اليوم");
                globalv.addMrecords(R.raw.today);
                initRecyclerView();



            }
        });


        final MediaPlayer tomorroplayer= MediaPlayer.create(TIME.this,R.raw.tomorrw);
        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomorroplayer.start();
                globalv.addmImageUrls(R.drawable.tomorrow);
                globalv.addmNames("غدا");
                globalv.addMrecords(R.raw.tomorrw);
                initRecyclerView();



            }
        });

        final MediaPlayer yesterplayer = MediaPlayer.create(TIME.this,R.raw.yesterday);
        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesterplayer.start();
                globalv.addmImageUrls(R.drawable.yesterday);
                globalv.addmNames("أمس");
                globalv.addMrecords(R.raw.yesterday);
                initRecyclerView();



            }
        });



        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(TIME.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(TIME.this,MainActivity.class);
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
