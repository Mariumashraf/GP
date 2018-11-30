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

public class CLOTHES extends AppCompatActivity {
    private static final String TAG = "CLOTHES";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);


        Button suit = (Button) findViewById(R.id.suit);
        Button blouse= (Button) findViewById(R.id.blouse);
        Button trousers = (Button) findViewById(R.id.trousers);
        Button pajama = (Button) findViewById(R.id.pajama);
        Button tshirt = (Button) findViewById(R.id.tshirt);
        Button jacket = (Button) findViewById(R.id.jacket);
        Button shoes = (Button) findViewById(R.id.shoes);
        Button skrit = (Button) findViewById(R.id.skirt);
        Button sock = (Button) findViewById(R.id.sock);
        Button dress = (Button) findViewById(R.id.dress);
        Button play = (Button) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //SUIT
        final MediaPlayer suitPlayer = MediaPlayer.create(CLOTHES.this,R.raw.suittt);
        suit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suitPlayer.start();
                globalv.addmImageUrls(R.drawable.suitttt);
                globalv.addmNames("بدلة");
                globalv.addMrecords(R.raw.suittt);
                initRecyclerView();



            }
        });

        //BLOUSE
        final MediaPlayer blousePlayer = MediaPlayer.create(CLOTHES.this,R.raw.blouseee);
        blouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blousePlayer.start();
                globalv.addmImageUrls(R.drawable.blouseee);
                globalv.addmNames("بلوزة");
                globalv.addMrecords(R.raw.blouseee);
                initRecyclerView();



            }
        });

        //TROUSERS
        final MediaPlayer trousersPlayer = MediaPlayer.create(CLOTHES.this,R.raw.pantsss);
        trousers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trousersPlayer.start();
                globalv.addmImageUrls(R.drawable.panttt);
                globalv.addmNames("بنطلون");
                globalv.addMrecords(R.raw.pantsss);
                initRecyclerView();



            }
        });

        //PAJAMA
        final MediaPlayer pajamaPlayer = MediaPlayer.create(CLOTHES.this,R.raw.pajamaaa );
        pajama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pajamaPlayer.start();
                globalv.addmImageUrls(R.drawable.pajamaaa);
                globalv.addmNames("بيجامة");
                globalv.addMrecords(R.raw.pajamaaa);
                initRecyclerView();



            }
        });

        //TSHIRT

        final MediaPlayer tshirtPlayer = MediaPlayer.create(CLOTHES.this,R.raw.tshirttt);
        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tshirtPlayer.start();
                globalv.addmImageUrls(R.drawable.tshirttt);
                globalv.addmNames("تيشيرت");
                globalv.addMrecords(R.raw.tshirttt);
                initRecyclerView();



            }
        });


        //JACKET
        final MediaPlayer jacketplayer = MediaPlayer.create(CLOTHES.this,R.raw.jackettt );
        jacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jacketplayer.start();
                globalv.addmImageUrls(R.drawable.jackettt);
                globalv.addmNames("جاكيت");
                globalv.addMrecords(R.raw.jackettt);
                initRecyclerView();



            }
        });

        //SHOSE
        final MediaPlayer shoesplayer = MediaPlayer.create(CLOTHES.this,R.raw.shoesss );
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoesplayer.start();
                globalv.addmImageUrls(R.drawable.shoessss);
                globalv.addmNames("جزمة");
                globalv.addMrecords(R.raw.shoesss );
                initRecyclerView();



            }
        });


        //SKRIT
        final MediaPlayer skritplayer= MediaPlayer.create(CLOTHES.this,R.raw.skirttt);
        skrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skritplayer.start();
                globalv.addmImageUrls(R.drawable.skrittt);
                globalv.addmNames("جيبة");
                globalv.addMrecords(R.raw.skirttt);
                initRecyclerView();



            }
        });

        //SOCK
        final MediaPlayer sockplayer = MediaPlayer.create(CLOTHES.this,R.raw.sockkk );
        sock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sockplayer.start();
                globalv.addmImageUrls(R.drawable.socksss);
                globalv.addmNames("شراب");
                globalv.addMrecords(R.raw.sockkk );
                initRecyclerView();



            }
        });



        //DRESS
        final MediaPlayer mediaPlayer12 = MediaPlayer.create(CLOTHES.this,R.raw.dresss);
        dress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer12.start();
                globalv.addmImageUrls(R.drawable.dresss);
                globalv.addmNames("فستان");
                globalv.addMrecords(R.raw.dresss);
                initRecyclerView();



            }
        });

        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(CLOTHES.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(CLOTHES.this,MainActivity.class);
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
