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

public class TIME extends AppCompatActivity {
    private static final String TAG = "TIME";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        Button morning =(Button) findViewById(R.id.morning);
        Button night=(Button) findViewById(R.id.night);
        Button play = (Button) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



        //MORNING

        final MediaPlayer morningplayer= MediaPlayer.create(TIME.this,R.raw.morninggg);
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                morningplayer.start();
                globalv.addmImageUrls(R.drawable.morninggg);
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
                globalv.addmImageUrls(R.drawable.nighttt);
                globalv.addmNames("الليل");
                globalv.addMrecords(R.raw.nighttt);
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
