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

import java.util.ArrayList;

public class FOODS extends AppCompatActivity {
    private static final String TAG = "FOODS";
    Globalrecycler globalv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_foods);

        ImageView rice = (ImageView) findViewById(R.id.rice);
        ImageView egg = (ImageView) findViewById(R.id.egg);
        ImageView vegatable = (ImageView) findViewById(R.id.vegatable);
        ImageView fruit= (ImageView) findViewById(R.id.fruit);
        ImageView icecream = (ImageView) findViewById(R.id.icecream);
        ImageView pizza = (ImageView) findViewById(R.id.pizza);
        ImageView biscuit = (ImageView) findViewById(R.id.biscuit);
        ImageView cheese = (ImageView) findViewById(R.id.cheese);
        ImageView Yogurt = (ImageView) findViewById(R.id.Yogurt);
        ImageView salad = (ImageView) findViewById(R.id.salad);
        ImageView fish = (ImageView) findViewById(R.id.fish);
        ImageView sandwich = (ImageView) findViewById(R.id.sandwich);
        ImageView soup = (ImageView) findViewById(R.id.soup);
        ImageView Chocolate = (ImageView) findViewById(R.id.Chocolate);
        ImageView honey= (ImageView) findViewById(R.id.honey);
        ImageView bread =(ImageView) findViewById(R.id.bread);
        ImageView chickens=(ImageView) findViewById(R.id.chickens);
        ImageView popcorn= (ImageView) findViewById(R.id.popcorn);
        ImageView meat =(ImageView) findViewById(R.id.meat);
        ImageView jam=(ImageView) findViewById(R.id.jam);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //RICE

        final MediaPlayer riceplayer= MediaPlayer.create(FOODS.this,R.raw.riceee);
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                riceplayer.start();
               globalv.addmImageUrls(R.drawable.riceeez);
                globalv.addmNames("رز");
                globalv.addMrecords(R.raw.riceee);
                initRecyclerView();



            }
        });

        //EGG
        final MediaPlayer eggplayer = MediaPlayer.create(FOODS.this,R.raw.egggg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eggplayer.start();
                globalv.addmImageUrls(R.drawable.eggggzz);
                globalv.addmNames("بيض");
                globalv.addMrecords(R.raw.egggg);
                initRecyclerView();



            }
        });


        //VEGATABLES

        vegatable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent12 = new Intent(FOODS.this,VEGETABLES.class);
                startActivity(intent12);



            }
        });

        //FRUIT
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent13 = new Intent(FOODS.this,FRUIT.class);
                startActivity(intent13);;



            }
        });


        //ICE CREAM

        final MediaPlayer iceplayer= MediaPlayer.create(FOODS.this,R.raw.icecreammm);
        icecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iceplayer.start();
               globalv.addmImageUrls(R.drawable.icecreammmz);
                globalv.addmNames("أيس كريم");
                globalv.addMrecords(R.raw.icecreammm);
                initRecyclerView();



            }
        });

        //PIZZA
        final MediaPlayer pizzaplayer = MediaPlayer.create(FOODS.this,R.raw.pizzaaa);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pizzaplayer.start();
                globalv.addmImageUrls(R.drawable.pizzaaaz);
                globalv.addmNames("بيتزا");
                globalv.addMrecords(R.raw.pizzaaa);
                initRecyclerView();



            }
        });


        //BISCUITS

        final MediaPlayer biscuitplayer= MediaPlayer.create(FOODS.this,R.raw.biscuitsss);
        biscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biscuitplayer.start();
                globalv.addmImageUrls(R.drawable.biscuuittt);
                globalv.addmNames("بسكويت");
                globalv.addMrecords(R.raw.biscuitsss);
                initRecyclerView();



            }
        });

        //CHEESE
        final MediaPlayer cheeseplayer = MediaPlayer.create(FOODS.this,R.raw.cheeseee);
        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheeseplayer.start();
               globalv.addmImageUrls(R.drawable.cheeseeezz);
                globalv.addmNames("جبنة");
                globalv.addMrecords(R.raw.cheeseee);
                initRecyclerView();



            }
        });


        //YOGURT

        final MediaPlayer yogurtplayer= MediaPlayer.create(FOODS.this,R.raw.zbadyyy);
        Yogurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yogurtplayer.start();
                globalv.addmImageUrls(R.drawable.yoghurtz);
                globalv.addmNames("زبادى");
                globalv.addMrecords(R.raw.zbadyyy);
                initRecyclerView();



            }
        });

        //SALAD
        final MediaPlayer saladplayer = MediaPlayer.create(FOODS.this,R.raw.saladdd);
        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladplayer.start();
                globalv.addmImageUrls(R.drawable.saladddz);
                globalv.addmNames("سلطة");
                globalv.addMrecords(R.raw.saladdd);
                initRecyclerView();



            }
        });


        //FISH

        final MediaPlayer fishplayer= MediaPlayer.create(FOODS.this,R.raw.fishhh);
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fishplayer.start();
                globalv.addmImageUrls(R.drawable.fishhhz);
                globalv.addmNames("سمك");
                globalv.addMrecords(R.raw.fishhh);
                initRecyclerView();



            }
        });

        //SANDWICH
        final MediaPlayer sandwichplayer = MediaPlayer.create(FOODS.this,R.raw.sandwichesss);
        sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sandwichplayer.start();
                globalv.addmImageUrls(R.drawable.sandwichhhz);
                globalv.addmNames("سندوتش");
                globalv.addMrecords(R.raw.sandwichesss);
                initRecyclerView();



            }
        });


        //SOUP

        final MediaPlayer soupplayer= MediaPlayer.create(FOODS.this,R.raw.souppp);
        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soupplayer.start();
                globalv.addmImageUrls(R.drawable.soupppz);
                globalv.addmNames("شوربة");
                globalv.addMrecords(R.raw.souppp);
                initRecyclerView();



            }
        });

        //CHOCOLATE
        final MediaPlayer chocolaplayer = MediaPlayer.create(FOODS.this,R.raw.chocolateee);
        Chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chocolaplayer.start();
                globalv.addmImageUrls(R.drawable.chocolateeezz);
                globalv.addmNames("شيكولاتة");
                globalv.addMrecords(R.raw.chocolateee);
                initRecyclerView();



            }
        });



        //HONEY

        final MediaPlayer honeyplayer= MediaPlayer.create(FOODS.this,R.raw.honeyyy);
        honey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                honeyplayer.start();
                globalv.addmImageUrls(R.drawable.honeyyyz);
                globalv.addmNames("عسل");
                globalv.addMrecords(R.raw.honeyyy);
                initRecyclerView();



            }
        });

        //BREAD
        final MediaPlayer breadplayer = MediaPlayer.create(FOODS.this,R.raw.breaddd);
        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                breadplayer.start();
                globalv.addmImageUrls(R.drawable.bbbreaddd);
                globalv.addmNames("عيش");
                globalv.addMrecords(R.raw.breaddd);
                initRecyclerView();



            }
        });



        //chickens

        final MediaPlayer chickenplayer= MediaPlayer.create(FOODS.this,R.raw.chickennn);
        chickens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chickenplayer.start();
                globalv.addmImageUrls(R.drawable.chikennnzz);
                globalv.addmNames("فراخ");
                globalv.addMrecords(R.raw.chickennn);
                initRecyclerView();



            }
        });

        //POPCORN
        final MediaPlayer popplayer = MediaPlayer.create(FOODS.this,R.raw.popcornnn);
        popcorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popplayer.start();
                globalv.addmImageUrls(R.drawable.popcornnnz);
                globalv.addmNames("فشار");
                globalv.addMrecords(R.raw.popcornnn);
                initRecyclerView();



            }
        });


        //MEAT

        final MediaPlayer meatplayer= MediaPlayer.create(FOODS.this,R.raw.meattt);
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meatplayer.start();
                globalv.addmImageUrls(R.drawable.meattz);
                globalv.addmNames("لحمة");
                globalv.addMrecords(R.raw.meattt);
                initRecyclerView();



            }
        });

        //JAM
        final MediaPlayer jamplayer = MediaPlayer.create(FOODS.this,R.raw.jammm);
        jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jamplayer.start();
                globalv.addmImageUrls(R.drawable.jammmz);
                globalv.addmNames("مربي");
                globalv.addMrecords(R.raw.jammm);
                initRecyclerView();



            }
        });



        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(FOODS.this, globalv.getMrecords().get(i));
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
    public static void CleanUpMemory(){
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }


    }

