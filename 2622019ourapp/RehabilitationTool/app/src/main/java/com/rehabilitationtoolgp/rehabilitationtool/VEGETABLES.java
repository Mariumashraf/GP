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

public class VEGETABLES extends AppCompatActivity {
    private static final String TAG = "VEGETABLES";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        ImageView tomato =(ImageView) findViewById(R.id.tomato);
        ImageView potato=(ImageView) findViewById(R.id.potato);
        ImageView cucumber= (ImageView) findViewById(R.id.cucumb2 );
        ImageView carrot =(ImageView) findViewById(R.id.carrot);
        ImageView lettuce=(ImageView) findViewById(R.id.lettuce);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //TOMATO
        final MediaPlayer tomatoplayer = MediaPlayer.create(VEGETABLES.this,R.raw.tomatoesss);
        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomatoplayer.start();
                globalv.addmImageUrls(R.drawable.tomatoz);
                globalv.addmNames("طماطم");
                globalv.addMrecords(R.raw.tomatoesss);
                initRecyclerView();



            }
        });


        //POTATO
        final MediaPlayer potatoplayer = MediaPlayer.create(VEGETABLES.this,R.raw.potatoesss);
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                potatoplayer.start();
                globalv.addmImageUrls(R.drawable.potatoz);
                globalv.addmNames("بطاطس");
                globalv.addMrecords(R.raw.potatoesss);
                initRecyclerView();



            }
        });


        //CUCUMBER
        final MediaPlayer cucumberplayer = MediaPlayer.create(VEGETABLES.this,R.raw.khearrr);
        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cucumberplayer.start();
                globalv.addmImageUrls(R.drawable.cucumberzz);
                globalv.addmNames("خيار");
                globalv.addMrecords(R.raw.khearrr);
                initRecyclerView();



            }
        });


        //CARROT
        final MediaPlayer carrotplayer = MediaPlayer.create(VEGETABLES.this,R.raw.carrottt);
        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carrotplayer.start();
                globalv.addmImageUrls(R.drawable.caaarrot);
                globalv.addmNames("جزر");
                globalv.addMrecords(R.raw.carrottt);
                initRecyclerView();



            }
        });

        //LETTUCE
        final MediaPlayer lettuceplayer = MediaPlayer.create(VEGETABLES.this,R.raw.khasss);
        lettuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lettuceplayer.start();
                globalv.addmImageUrls(R.drawable.lettucez);
                globalv.addmNames("خس");
                globalv.addMrecords(R.raw.khasss);
                initRecyclerView();



            }
        });



        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(VEGETABLES.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(VEGETABLES.this,FOODS.class);
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
