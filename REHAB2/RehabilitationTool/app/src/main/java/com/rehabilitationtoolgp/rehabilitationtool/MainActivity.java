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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<Integer> mrecords = new ArrayList<>();
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button i = (Button) findViewById(R.id.i);
        Button want = (Button) findViewById(R.id.want);
        Button notwant= (Button) findViewById(R.id.notWant);
        Button eat = (Button) findViewById(R.id.eat);
        Button drink = (Button) findViewById(R.id.drink);
        Button wear = (Button) findViewById(R.id.wear);
        Button go = (Button) findViewById(R.id.go);
        Button yes= (Button) findViewById(R.id.yes);
        Button no = (Button) findViewById(R.id.no);

        Button play = (Button) findViewById(R.id.playall);
       // Button next = (Button) findViewById(R.id.next);
        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        final MediaPlayer mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.ana);
        i.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                mediaPlayer.start();
                globalv.addmImageUrls(R.drawable.ana);
                globalv.addmNames("أنا");
                globalv.addMrecords(R.raw.ana);
                initRecyclerView();



           }
        });
        final MediaPlayer mediaPlayer1 =MediaPlayer.create(MainActivity.this, R.raw.want);
       want.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                mediaPlayer1.start();
                globalv.addmImageUrls(R.drawable.need);
                globalv.addmNames("عايز");
                globalv.addMrecords(R.raw.want);
                initRecyclerView();

         }
        });
        final MediaPlayer mediaPlayer2 =MediaPlayer.create(MainActivity.this, R.raw.notwant);
        notwant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();
                globalv.addmImageUrls(R.drawable.notwant);
                globalv.addmNames(" مش عايز");
                globalv.addMrecords(R.raw.notwant);
                initRecyclerView();

            }
        });

        final MediaPlayer mediaPlayer3 =MediaPlayer.create(MainActivity.this, R.raw.eat);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();
                globalv.addmImageUrls(R.drawable.eat);
                globalv.addmNames("أكل");
                globalv.addMrecords(R.raw.eat);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(MainActivity.this,FOODS.class);
                startActivity(intent1);

            }
        });
        final MediaPlayer mediaPlayer4 =MediaPlayer.create(MainActivity.this, R.raw.drink);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer4.start();
                globalv.addmImageUrls(R.drawable.drink);
                globalv.addmNames(" أشرب");
                globalv.addMrecords(R.raw.drink);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(MainActivity.this,DRINKS.class);
                startActivity(intent1);

            }
        });
        final MediaPlayer mediaPlayer5 =MediaPlayer.create(MainActivity.this, R.raw.wear);
        wear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer5.start();
                globalv.addmImageUrls(R.drawable.wear);
                globalv.addmNames("يلبس");
                globalv.addMrecords(R.raw.wear);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(MainActivity.this,CLOTHES.class);
                startActivity(intent1);

            }
        });
        final MediaPlayer mediaPlayer6 =MediaPlayer.create(MainActivity.this, R.raw.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer6.start();
               globalv.addmImageUrls(R.drawable.walk);
                globalv.addmNames("اذهب");
                globalv.addMrecords(R.raw.go);
                initRecyclerView();

                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(MainActivity.this,PLACES.class);
                startActivity(intent1);

            }
        });

        final MediaPlayer mediaPlayer7 =MediaPlayer.create(MainActivity.this, R.raw.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer7.start();
               globalv.addmImageUrls(R.drawable.yes);
                globalv.addmNames("نعم");
                globalv.addMrecords(R.raw.yes);
                initRecyclerView();

            }
        });

        final MediaPlayer mediaPlayer8 =MediaPlayer.create(MainActivity.this, R.raw.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer8.start();
               globalv.addmImageUrls(R.drawable.no);
                globalv.addmNames("لا");
                globalv.addMrecords(R.raw.no);
                initRecyclerView();

            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(MainActivity.this, globalv.getMrecords().get(i));
                    mediaPlay.start();
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                    }
                }
            }



        });

        //next.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  globalv.getmImageUrls();
                //globalv.getmNames();
                //globalv.getMrecords();

               // Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
                //startActivity(intent1);
            //}
        //});


    }



    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,  globalv.getmNames(), globalv.getmImageUrls(),globalv.getMrecords());
        recyclerView.setAdapter(adapter);
    }


    public void button2(View view) {
    }
}


















