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

public class ACTIONS extends AppCompatActivity {
    private static final String TAG = "ACTIONS";
    Globalrecycler globalv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);


        Button smile = (Button) findViewById(R.id.smile);
        Button climb= (Button) findViewById(R.id.climb);
        Button speak = (Button) findViewById(R.id.speak);
        Button run = (Button) findViewById(R.id.run);
        Button dance = (Button) findViewById(R.id.dance);
        Button ride = (Button) findViewById(R.id.ride);
        Button throw3 = (Button) findViewById(R.id.throw3);
        Button watch = (Button) findViewById(R.id.watch);
        Button swim = (Button) findViewById(R.id.swim);
        Button sing = (Button) findViewById(R.id.sing);
        Button think = (Button) findViewById(R.id.think);
        Button read = (Button) findViewById(R.id.read);
        Button hop= (Button) findViewById(R.id.hop);
        Button close =(Button) findViewById(R.id.close);
        Button sleep=(Button) findViewById(R.id.sleep);
        Button play = (Button) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //SMILE
        final MediaPlayer smileplayer =MediaPlayer.create(ACTIONS.this, R.raw.smileee);
        smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smileplayer.start();
                globalv.addmImageUrls(R.drawable.smileee);
                globalv.addmNames("ابتسم");
                globalv.addMrecords(R.raw.smileee);
                initRecyclerView();

            }
        });

        //CLIMB
        final MediaPlayer climbplayer =MediaPlayer.create(ACTIONS.this, R.raw.atasalkkk);
        climb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                climbplayer.start();
                globalv.addmImageUrls(R.drawable.climbbb);
                globalv.addmNames("اتسلق");
                globalv.addMrecords(R.raw.atasalkkk);
                initRecyclerView();

            }
        });


        //SPEAK
        final MediaPlayer speakplayer =MediaPlayer.create(ACTIONS.this, R.raw.speakkk);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakplayer.start();
                globalv.addmImageUrls(R.drawable.speakkk);
                globalv.addmNames("اتكلم");
                globalv.addMrecords(R.raw.speakkk);
                initRecyclerView();

            }
        });


        //RUN
        final MediaPlayer runplayer =MediaPlayer.create(ACTIONS.this, R.raw.runnn);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runplayer.start();
                globalv.addmImageUrls(R.drawable.runnn);
                globalv.addmNames("أجرى");
                globalv.addMrecords(R.raw.runnn);
                initRecyclerView();

            }
        });

        //DANCE
        final MediaPlayer danceplayer =MediaPlayer.create(ACTIONS.this, R.raw.dancee);
        dance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                danceplayer.start();
                globalv.addmImageUrls(R.drawable.danceee);
                globalv.addmNames("أرقص");
                globalv.addMrecords(R.raw.dancee);
                initRecyclerView();

            }
        });

        //RIDE
        final MediaPlayer rideplayer =MediaPlayer.create(ACTIONS.this, R.raw.rideee);
        ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rideplayer.start();
                globalv.addmImageUrls(R.drawable.rideeeee);
                globalv.addmNames("أركب");
                globalv.addMrecords(R.raw.rideee);
                initRecyclerView();

            }
        });

        //THROW
        final MediaPlayer throwplayer =MediaPlayer.create(ACTIONS.this, R.raw.throwww);
        throw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throwplayer.start();
                globalv.addmImageUrls(R.drawable.throwww);
                globalv.addmNames("أرمى");
                globalv.addMrecords(R.raw.throwww);
                initRecyclerView();

            }
        });

        //WATCH
        final MediaPlayer watchplayer =MediaPlayer.create(ACTIONS.this, R.raw.watchhh);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchplayer.start();
                globalv.addmImageUrls(R.drawable.watchhhh);
                globalv.addmNames("اشاهد");
                globalv.addMrecords(R.raw.watchhh);
                initRecyclerView();

            }
        });


        //SWIM
        final MediaPlayer swimplayer =MediaPlayer.create(ACTIONS.this, R.raw.swimmm);
        swim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swimplayer.start();
                globalv.addmImageUrls(R.drawable.swimmm);
                globalv.addmNames("أعوم");
                globalv.addMrecords(R.raw.swimmm);
                initRecyclerView();

            }
        });


        //SING
        final MediaPlayer singplayer =MediaPlayer.create(ACTIONS.this, R.raw.singgg);
        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singplayer.start();
                globalv.addmImageUrls(R.drawable.danceeee);
                globalv.addmNames("أغنى");
                globalv.addMrecords(R.raw.singgg);
                initRecyclerView();

            }
        });

        //THINK
        final MediaPlayer thinkplayer =MediaPlayer.create(ACTIONS.this, R.raw.thinkkk);
        think.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thinkplayer.start();
                globalv.addmImageUrls(R.drawable.thinkkk);
                globalv.addmNames("أفكر");
                globalv.addMrecords(R.raw.thinkkk);
                initRecyclerView();

            }
        });

        //READ
        final MediaPlayer readplayer =MediaPlayer.create(ACTIONS.this, R.raw.readdd);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readplayer.start();
                globalv.addmImageUrls(R.drawable.readdd);
                globalv.addmNames("أقرأ");
                globalv.addMrecords(R.raw.readdd);
                initRecyclerView();

            }
        });

        //HOP
        final MediaPlayer hopplayer =MediaPlayer.create(ACTIONS.this, R.raw.jumppp);
        hop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hopplayer.start();
                globalv.addmImageUrls(R.drawable.hoppp);
                globalv.addmNames("أقفز");
                globalv.addMrecords(R.raw.jumppp);
                initRecyclerView();

            }
        });

        //CLOSE
        final MediaPlayer closeplayer =MediaPlayer.create(ACTIONS.this, R.raw.lockkk);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeplayer.start();
                globalv.addmImageUrls(R.drawable.closeee);
                globalv.addmNames("أقفل");
                globalv.addMrecords(R.raw.lockkk);
                initRecyclerView();

            }
        });

        //SLEEP
        final MediaPlayer sleepplayer =MediaPlayer.create(ACTIONS.this, R.raw.sleeppp);
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepplayer.start();
                globalv.addmImageUrls(R.drawable.sleeep);
                globalv.addmNames("أنام");
                globalv.addMrecords(R.raw.sleeppp);
                initRecyclerView();

            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(ACTIONS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(ACTIONS.this,MainActivity.class);
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
