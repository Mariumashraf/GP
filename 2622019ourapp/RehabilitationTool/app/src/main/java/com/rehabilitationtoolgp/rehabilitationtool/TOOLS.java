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
import android.widget.ImageView;


public class TOOLS extends AppCompatActivity {

    private static final String TAG = "TOOLS";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);


        ImageView dishh = (ImageView) findViewById(R.id.dishh);
        ImageView cupp= (ImageView) findViewById(R.id.cupp);
        ImageView spoonn = (ImageView) findViewById(R.id.spoonn);
        ImageView forkk = (ImageView) findViewById(R.id.forkk);
        ImageView knifee = (ImageView) findViewById(R.id.knifee);
        ImageView scissorss = (ImageView) findViewById(R.id.scissorss);
        ImageView chairr = (ImageView) findViewById(R.id.chairr);
        ImageView tablee = (ImageView) findViewById(R.id.tablee);
        ImageView notebookk = (ImageView) findViewById(R.id.notebookk);
        ImageView penn = (ImageView) findViewById(R.id.penn);
        ImageView glassess = (ImageView) findViewById(R.id.glassess);
        ImageView tvv = (ImageView) findViewById(R.id.tvv);
        ImageView computerr = (ImageView) findViewById(R.id.computerr);
        ImageView ball = (ImageView) findViewById(R.id.ball);
        ImageView toyss = (ImageView) findViewById(R.id.toyss);
        Button play = (Button) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);

        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //DISH
        final MediaPlayer dishplayer = MediaPlayer.create(TOOLS.this,R.raw.plateee);
        dishh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dishplayer.start();
                globalv.addmImageUrls(R.drawable.dishhzz);
                globalv.addmNames("طبق");
                globalv.addMrecords(R.raw.plateee);
                initRecyclerView();



            }
        });

        //CUP
        final MediaPlayer cupplayer = MediaPlayer.create(TOOLS.this,R.raw.cuppp);
        cupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cupplayer.start();
                globalv.addmImageUrls(R.drawable.cuppzz);
                globalv.addmNames("كوباية");
                globalv.addMrecords(R.raw.cuppp);
                initRecyclerView();



            }
        });

        //SPOON
        final MediaPlayer spoonplayer = MediaPlayer.create(TOOLS.this,R.raw.spoonnn);
        spoonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spoonplayer.start();
                globalv.addmImageUrls(R.drawable.spoonnz);
                globalv.addmNames("ملعقة");
                globalv.addMrecords(R.raw.spoonnn);
                initRecyclerView();



            }
        });

        //FORK
        final MediaPlayer forkplayer = MediaPlayer.create(TOOLS.this,R.raw.forkkk);
        forkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forkplayer.start();
                globalv.addmImageUrls(R.drawable.forkkz);
                globalv.addmNames("شوكة");
                globalv.addMrecords(R.raw.forkkk);
                initRecyclerView();



            }
        });

        //KNIFE
        final MediaPlayer knifeplayer = MediaPlayer.create(TOOLS.this,R.raw.knifeee);
        knifee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                knifeplayer.start();
                globalv.addmImageUrls(R.drawable.knifeeezz);
                globalv.addmNames("سكينة");
                globalv.addMrecords(R.raw.knifeee);
                initRecyclerView();



            }
        });

        //SCISSORS
        final MediaPlayer scisplayer = MediaPlayer.create(TOOLS.this,R.raw.makasss);
        scissorss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scisplayer.start();
                globalv.addmImageUrls(R.drawable.scissz);
                globalv.addmNames("مقص");
                globalv.addMrecords(R.raw.makasss);
                initRecyclerView();



            }
        });

        //CHAIR
        final MediaPlayer chairplayer = MediaPlayer.create(TOOLS.this,R.raw.chairrr);
        chairr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chairplayer.start();
                globalv.addmImageUrls(R.drawable.chairzz);
                globalv.addmNames("كرسي");
                globalv.addMrecords(R.raw.chairrr);
                initRecyclerView();



            }
        });

        //TABLE
        final MediaPlayer tableplayer = MediaPlayer.create(TOOLS.this,R.raw.tableee);
        tablee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableplayer.start();
                globalv.addmImageUrls(R.drawable.tableeez);
                globalv.addmNames("ترابيزة");
                globalv.addMrecords(R.raw.tableee);
                initRecyclerView();



            }
        });

        //NOTEBOOK
        final MediaPlayer noteplayer = MediaPlayer.create(TOOLS.this,R.raw.notebookkk);
        notebookk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteplayer.start();
                globalv.addmImageUrls(R.drawable.notebookz);
                globalv.addmNames("كراسة");
                globalv.addMrecords(R.raw.notebookkk);
                initRecyclerView();



            }
        });

        //PEN
        final MediaPlayer penplayer = MediaPlayer.create(TOOLS.this,R.raw.pennn);
        penn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penplayer.start();
                globalv.addmImageUrls(R.drawable.pennz);
                globalv.addmNames("قلم");
                globalv.addMrecords(R.raw.pennn);
                initRecyclerView();



            }
        });

        //GLASSES
        final MediaPlayer glassplayer = MediaPlayer.create(TOOLS.this,R.raw.glassss);
        glassess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glassplayer.start();
                globalv.addmImageUrls(R.drawable.glassz);
                globalv.addmNames("نضارة");
                globalv.addMrecords(R.raw.glassss);
                initRecyclerView();



            }
        });


        //TV
        final MediaPlayer tvplayer = MediaPlayer.create(TOOLS.this,R.raw.tvvv);
        tvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvplayer.start();
                globalv.addmImageUrls(R.drawable.tvzs);
                globalv.addmNames("تليفزيون");
                globalv.addMrecords(R.raw.tvvv);
                initRecyclerView();



            }
        });

        //COMPUTER
        final MediaPlayer computerplayer = MediaPlayer.create(TOOLS.this,R.raw.computerrr);
        computerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computerplayer.start();
                globalv.addmImageUrls(R.drawable.computerrzz);
                globalv.addmNames("كمبيوتر");
                globalv.addMrecords(R.raw.computerrr);
                initRecyclerView();



            }
        });

        //BALL
        final MediaPlayer ballplayer = MediaPlayer.create(TOOLS.this,R.raw.ballll);
        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ballplayer.start();
                globalv.addmImageUrls(R.drawable.balllll);
                globalv.addmNames("كورة");
                globalv.addMrecords(R.raw.ballll);
                initRecyclerView();



            }
        });

        //TOYS
        final MediaPlayer toyplayer = MediaPlayer.create(TOOLS.this,R.raw.gamesss);
        toyss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toyplayer.start();
                globalv.addmImageUrls(R.drawable.toysssz);
                globalv.addmNames("ألعاب");
                globalv.addMrecords(R.raw.gamesss);
                initRecyclerView();



            }
        });


        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(TOOLS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(TOOLS.this,MainActivity.class);
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
