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

public class Feelings extends AppCompatActivity {
    private static final String TAG = "Feelings";
    Globalrecycler globalv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feelings);

        ImageView sad = (ImageView) findViewById(R.id.sad);
        ImageView happy= (ImageView) findViewById(R.id.happy);
        ImageView hate = (ImageView) findViewById(R.id.hate);
        ImageView love = (ImageView) findViewById(R.id.love);
        ImageView mohrag = (ImageView) findViewById(R.id.mohrag);
        ImageView mozeeg = (ImageView) findViewById(R.id.mozeeg);
        ImageView boring = (ImageView) findViewById(R.id.boring);
        ImageView methams = (ImageView) findViewById(R.id.methams);
        ImageView scared = (ImageView) findViewById(R.id.scared);
        ImageView hurt = (ImageView) findViewById(R.id.hurt);
        ImageView laziiz = (ImageView) findViewById(R.id.laziiz);
        ImageView mooref = (ImageView) findViewById(R.id.mooref);
        ImageView donotunder = (ImageView) findViewById(R.id.donotunder);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        final MediaPlayer sadplayer =MediaPlayer.create(Feelings.this, R.raw.sad);
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sadplayer.start();
                globalv.addmImageUrls(R.drawable.sad);
                globalv.addmNames("حزين");
               globalv.addMrecords(R.raw.sad);
                initRecyclerView();

            }
        });
        final MediaPlayer happyplayer =MediaPlayer.create(Feelings.this, R.raw.happy);
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                happyplayer.start();
                globalv.addmImageUrls(R.drawable.happy);
                globalv.addmNames("فرحان");
                globalv.addMrecords(R.raw.happy);
                initRecyclerView();

            }
        });

        final MediaPlayer hateplayer =MediaPlayer.create(Feelings.this, R.raw.hate);
        hate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hateplayer.start();
                globalv.addmImageUrls(R.drawable.hate);
                globalv.addmNames("بكره");
               globalv.addMrecords(R.raw.hate);
                initRecyclerView();

            }
        });

       final MediaPlayer loveplayer =MediaPlayer.create(Feelings.this, R.raw.love);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              loveplayer.start();
                globalv.addmImageUrls(R.drawable.love);
                globalv.addmNames("بحب");
               globalv.addMrecords(R.raw.love);
                initRecyclerView();

            }
        });

        final MediaPlayer mohragplayer =MediaPlayer.create(Feelings.this, R.raw.mohrag);
        mohrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mohragplayer.start();
                globalv.addmImageUrls(R.drawable.mohrag);
                globalv.addmNames("محرج");
               globalv.addMrecords(R.raw.mohrag);
                initRecyclerView();

            }
        });

        final MediaPlayer mozegplayer =MediaPlayer.create(Feelings.this, R.raw.mozeeg);
        mozeeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mozegplayer.start();
                globalv.addmImageUrls(R.drawable.mozeeg);
                globalv.addmNames("مزعج");
                globalv.addMrecords(R.raw.mozeeg);
                initRecyclerView();

            }
        });

        final MediaPlayer borplayer =MediaPlayer.create(Feelings.this, R.raw.boring);
        boring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               borplayer.start();
                globalv.addmImageUrls(R.drawable.boring);
                globalv.addmNames("ممل");
                globalv.addMrecords(R.raw.boring);
                initRecyclerView();

            }
        });
        final MediaPlayer metplayer =MediaPlayer.create(Feelings.this, R.raw.methams);
        methams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                metplayer.start();
                globalv.addmImageUrls(R.drawable.methams);
                globalv.addmNames("متحمس");
                globalv.addMrecords(R.raw.methams);
                initRecyclerView();

            }
        });

        final MediaPlayer hurtplayer =MediaPlayer.create(Feelings.this, R.raw.hurt);
        hurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hurtplayer.start();
                globalv.addmImageUrls(R.drawable.hurt);
                globalv.addmNames("مؤلم");
                globalv.addMrecords(R.raw.hurt);
                initRecyclerView();

            }
        });

        final MediaPlayer scarplayer =MediaPlayer.create(Feelings.this, R.raw.scared);
        scared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scarplayer.start();
                globalv.addmImageUrls(R.drawable.scared);
                globalv.addmNames("خايف");
              globalv.addMrecords(R.raw.scared);
                initRecyclerView();

            }
        });

        final MediaPlayer lazplayer =MediaPlayer.create(Feelings.this, R.raw.laziiz);
        laziiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lazplayer.start();
                globalv.addmImageUrls(R.drawable.laziiiz);
                globalv.addmNames("لذيذ");
                globalv.addMrecords(R.raw.laziiz);
                initRecyclerView();

            }
        });

        final MediaPlayer donotplayer =MediaPlayer.create(Feelings.this, R.raw.donotunder);
        donotunder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donotplayer.start();
                globalv.addmImageUrls(R.drawable.donotunderstand);
                globalv.addmNames("مش فاهم");
                globalv.addMrecords(R.raw.donotunder);
                initRecyclerView();

            }
        });

        final MediaPlayer moorefplayer =MediaPlayer.create(Feelings.this, R.raw.mooref);
        mooref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moorefplayer.start();
                globalv.addmImageUrls(R.drawable.mooref);
                globalv.addmNames("مقرف");
                globalv.addMrecords(R.raw.mooref);
                initRecyclerView();

            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(Feelings.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(Feelings.this,MainActivity.class);
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
