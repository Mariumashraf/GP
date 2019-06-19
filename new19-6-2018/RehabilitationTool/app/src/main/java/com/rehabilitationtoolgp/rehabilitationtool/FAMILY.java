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

public class FAMILY extends AppCompatActivity {
    private static final String TAG = "FAMILY";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


        ImageView sister = (ImageView) findViewById(R.id.sister);
        ImageView brother= (ImageView) findViewById(R.id.brother);
        ImageView father = (ImageView) findViewById(R.id.father);
        ImageView mother = (ImageView) findViewById(R.id.mother);
        ImageView grandfather = (ImageView) findViewById(R.id.grandfather);
        ImageView grandmother = (ImageView) findViewById(R.id.grandmother);
        ImageView uncle = (ImageView) findViewById(R.id.uncle);
        ImageView aunt = (ImageView) findViewById(R.id.aunt);
        ImageView uncle2 = (ImageView) findViewById(R.id.uncle3);
        ImageView aunt2 = (ImageView) findViewById(R.id.Aunt3);
        ImageView boy = (ImageView) findViewById(R.id.cousinBoy);
        ImageView girl = (ImageView) findViewById(R.id.cousinGirl);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        final MediaPlayer mbroplayer =MediaPlayer.create(FAMILY.this, R.raw.motherbro);
        uncle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mbroplayer.start();
                globalv.addmImageUrls(R.drawable.uncle);
                globalv.addmNames("خالى");
                globalv.addMrecords(R.raw.motherbro);
                initRecyclerView();

            }
        });
        final MediaPlayer msisterplayer =MediaPlayer.create(FAMILY.this, R.raw.mothersis);
        aunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msisterplayer.start();
                globalv.addmImageUrls(R.drawable.auntt);
                globalv.addmNames("خالتى");
                globalv.addMrecords(R.raw.mothersis);
                initRecyclerView();

            }
        });

        final MediaPlayer uncleplayer =MediaPlayer.create(FAMILY.this, R.raw.unkle);
        uncle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uncleplayer.start();
                globalv.addmImageUrls(R.drawable.unclee);
                globalv.addmNames("عمى");
                globalv.addMrecords(R.raw.unkle);
                initRecyclerView();

            }
        });

        final MediaPlayer antplayer =MediaPlayer.create(FAMILY.this, R.raw.ant);
        aunt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                antplayer.start();
                globalv.addmImageUrls(R.drawable.aunt);
                globalv.addmNames("عمتى");
                globalv.addMrecords(R.raw.ant);
                initRecyclerView();

            }
        });

        final MediaPlayer boyplayer =MediaPlayer.create(FAMILY.this, R.raw.sonofunkle);
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boyplayer.start();
                globalv.addmImageUrls(R.drawable.cousinboy);
                globalv.addmNames("ابن عمى");
                globalv.addMrecords(R.raw.sonofunkle);
                initRecyclerView();

            }
        });

        final MediaPlayer girlplayer =MediaPlayer.create(FAMILY.this, R.raw.cosgirl);
        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlplayer.start();
                globalv.addmImageUrls(R.drawable.cousingirl);
                globalv.addmNames("بنت عمى");
                globalv.addMrecords(R.raw.cosgirl);
                initRecyclerView();

            }
        });

        //SISTER
        final MediaPlayer sisterplayer =MediaPlayer.create(FAMILY.this, R.raw.sisterrr);
        sister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sisterplayer.start();
                globalv.addmImageUrls(R.drawable.sis);
                globalv.addmNames("أختى");
                globalv.addMrecords(R.raw.sisterrr);
                initRecyclerView();

            }
        });


        //BROTHER
        final MediaPlayer brotherplayer =MediaPlayer.create(FAMILY.this, R.raw.brotherrr );
        brother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brotherplayer.start();
                globalv.addmImageUrls(R.drawable.bro);
                globalv.addmNames("أخويا");
                globalv.addMrecords(R.raw.brotherrr);
                initRecyclerView();

            }
        });


        //FATHER
        final MediaPlayer fatherplayer =MediaPlayer.create(FAMILY.this, R.raw.fatherrr );
        father.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fatherplayer.start();
                globalv.addmImageUrls(R.drawable.dad);
                globalv.addmNames("بابا");
                globalv.addMrecords(R.raw.fatherrr);
                initRecyclerView();

            }
        });


        //MOTHER
        final MediaPlayer motherplayer =MediaPlayer.create(FAMILY.this, R.raw.motherrr);
        mother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motherplayer.start();
                globalv.addmImageUrls(R.drawable.mom);
                globalv.addmNames("ماما");
                globalv.addMrecords(R.raw.motherrr);
                initRecyclerView();

            }
        });


        //GRANDFATHER
        final MediaPlayer grandfplayer =MediaPlayer.create(FAMILY.this, R.raw.grandpaaa);
        grandfather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grandfplayer.start();
                globalv.addmImageUrls(R.drawable.grandfather);
                globalv.addmNames("جدو");
                globalv.addMrecords(R.raw.grandpaaa);
                initRecyclerView();

            }
        });


        //GRANDMOTHER
        final MediaPlayer grandmplayer =MediaPlayer.create(FAMILY.this, R.raw.grandmaaa);
        grandmother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grandmplayer.start();
                globalv.addmImageUrls(R.drawable.gradmother2);
                globalv.addmNames("جدتى");
                globalv.addMrecords(R.raw.grandmaaa);
                initRecyclerView();

            }
        });


        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(FAMILY.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(FAMILY.this,MainActivity.class);
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
