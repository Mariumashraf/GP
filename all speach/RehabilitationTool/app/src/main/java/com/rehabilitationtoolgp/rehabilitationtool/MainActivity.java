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


public class MainActivity extends AppCompatActivity {

    //vars
    // private ArrayList<String> mNames = new ArrayList<>();
    //private ArrayList<Integer> mImageUrls = new ArrayList<>();
    //private ArrayList<Integer> mrecords = new ArrayList<>();


    private static final String TAG = "MainActivity";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_main);
        ImageView want = (ImageView) findViewById(R.id.want);
        ImageView notwant= (ImageView) findViewById(R.id.notWant);
        ImageView eat = (ImageView) findViewById(R.id.eat);
        ImageView drink = (ImageView) findViewById(R.id.drink);
        ImageView wear = (ImageView) findViewById(R.id.wear);
        ImageView go = (ImageView) findViewById(R.id.go);
        ImageView yes= (ImageView) findViewById(R.id.yes);
        ImageView no = (ImageView) findViewById(R.id.no);
        ImageView family = (ImageView) findViewById(R.id.family);
        ImageView actions= (ImageView) findViewById(R.id.actions);
        ImageView trans= (ImageView) findViewById(R.id.trans);
        ImageView relations = (ImageView) findViewById(R.id.relations);
        ImageView time= (ImageView) findViewById(R.id.timee);
        ImageView tools =(ImageView) findViewById(R.id.tools2);
        ImageView createcard =(ImageView) findViewById(R.id.createcardd);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button practice = (Button) findViewById(R.id.speechvrifecationbtn);
        // Button next = (Button) findViewById(R.id.next);
        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



   //I WANT
        final MediaPlayer iwantplayer =MediaPlayer.create(MainActivity.this, R.raw.ineeddd);
       want.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               iwantplayer.start();
                globalv.addmImageUrls(R.drawable.needddzz);
                globalv.addmNames(" أناعايز");
                globalv.addMrecords(R.raw.ineeddd);
                initRecyclerView();

         }
        });

       // I DONONT WANT
        final MediaPlayer inotwantplayer =MediaPlayer.create(MainActivity.this, R.raw.inotneeddd);
        notwant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inotwantplayer .start();
                globalv.addmImageUrls(R.drawable.notneedddz);
                globalv.addmNames(" أنا مش عايز");
                globalv.addMrecords(R.raw.inotneeddd);
                initRecyclerView();

            }
        });


        //YES
        final MediaPlayer yesplayer =MediaPlayer.create(MainActivity.this, R.raw.yesss);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesplayer .start();
                globalv.addmImageUrls(R.drawable.yesz);
                globalv.addmNames("نعم");
                globalv.addMrecords(R.raw.yesss);
                initRecyclerView();

            }
        });

        //NO

        final MediaPlayer noplayer =MediaPlayer.create(MainActivity.this, R.raw.nooo);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noplayer.start();
                globalv.addmImageUrls(R.drawable.nooozz);
                globalv.addmNames("لا");
                globalv.addMrecords(R.raw.nooo);
                initRecyclerView();

            }
        });

        //EAT

        final MediaPlayer eatplayer =MediaPlayer.create(MainActivity.this, R.raw.eattt);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eatplayer.start();
               globalv.addmImageUrls(R.drawable.eatttzz);
                globalv.addmNames("أكل");
                globalv.addMrecords(R.raw.eattt);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(MainActivity.this,FOODS.class);
                startActivity(intent1);

            }
        });

        //DRINK

        final MediaPlayer drinkplayer =MediaPlayer.create(MainActivity.this, R.raw.drinkkk);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drinkplayer.start();
                globalv.addmImageUrls(R.drawable.drinkkkkzz);
                globalv.addmNames(" أشرب");
                globalv.addMrecords(R.raw.drinkkk);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent2 = new Intent(MainActivity.this,DRINKS.class);
                startActivity(intent2);

            }
        });

        //WEAR

        final MediaPlayer wearplayer =MediaPlayer.create(MainActivity.this, R.raw.wearrr);
        wear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wearplayer.start();
                globalv.addmImageUrls(R.drawable.wearrrrz);
                globalv.addmNames("ألبس");
                globalv.addMrecords(R.raw.wearrr);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent3 = new Intent(MainActivity.this,CLOTHES.class);
                startActivity(intent3);

            }
        });

        //GO
        final MediaPlayer goplayer =MediaPlayer.create(MainActivity.this, R.raw.gooo);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goplayer.start();
               globalv.addmImageUrls(R.drawable.walkkkz);
                globalv.addmNames("اروح");
                globalv.addMrecords(R.raw.gooo);
                initRecyclerView();

                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent4 = new Intent(MainActivity.this,PLACES.class);
                startActivity(intent4);

            }
        });
        //FAMILY
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent5 = new Intent(MainActivity.this,FAMILY.class);
                startActivity(intent5);

            }
        });


        //ACTIONS
        actions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            CleanUpMemory();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent6 = new Intent(MainActivity.this,ACTIONS.class);
                startActivity(intent6);

            }
        });

        //TRANSPORTATION

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent7 = new Intent(MainActivity.this,TRANSPORTATION.class);
                startActivity(intent7);

            }
        });

        //DIRECTIONS
        relations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CleanUpMemory();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent8 = new Intent(MainActivity.this,DIRECTIONS.class);
                startActivity(intent8);

            }
        });

        //TIME
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent9 = new Intent(MainActivity.this,TIME.class);
                startActivity(intent9);

            }
        });
        //TOOLS
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent10 = new Intent(MainActivity.this,TOOLS.class);
                startActivity(intent10);

            }
        });

        //CREATE CARD
        createcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent11 = new Intent(MainActivity.this,CREATCARD.class);
                startActivity(intent11);

            }
        });

        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(MainActivity.this, globalv.getMrecords().get(i));
                    mediaPlay.start();
                    try {
                        Thread.sleep(700);
                    } catch(InterruptedException e) {
                    }
                }
            }



        });


        //SPEECH VRIFECATION
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent12 = new Intent(MainActivity.this,PRACTICING.class);
                startActivity(intent12);

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


    public static void CleanUpMemory(){
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }

    @Override
    protected void onStop() {
        super.onStop();
        CleanUpMemory();
    }

    @Override
    protected void onPause() {
        super.onPause();
        CleanUpMemory();

    }

    public void buttonClicked(View view) {
    }
}


















