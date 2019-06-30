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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CLOTHES extends AppCompatActivity {
    private static final String TAG = "CLOTHES";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);


        ImageView suit = (ImageView) findViewById(R.id.suit);
        ImageView blouse= (ImageView) findViewById(R.id.blouse);
        ImageView trousers = (ImageView) findViewById(R.id.trousers);
        ImageView pajama = (ImageView) findViewById(R.id.pajama);
        ImageView tshirt = (ImageView) findViewById(R.id.tshirt);
        ImageView jacket = (ImageView) findViewById(R.id.jacket);
        ImageView shoes = (ImageView) findViewById(R.id.shoes);
        ImageView skrit = (ImageView) findViewById(R.id.skirt);
        ImageView sock = (ImageView) findViewById(R.id.sock);
        ImageView dress = (ImageView) findViewById(R.id.dress);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //SUIT
        final MediaPlayer suitPlayer = MediaPlayer.create(CLOTHES.this,R.raw.suittt);
        suit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suitPlayer.start();
                globalv.addmImageUrls(R.drawable.badla);
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
                globalv.addmImageUrls(R.drawable.blouse);
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
                globalv.addmImageUrls(R.drawable.bantlon);
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
                globalv.addmImageUrls(R.drawable.pijama);
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
                globalv.addmImageUrls(R.drawable.chemies);
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
                globalv.addmImageUrls(R.drawable.jacket);
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
                globalv.addmImageUrls(R.drawable.shoes);
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
                globalv.addmImageUrls(R.drawable.skirt);
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
                globalv.addmImageUrls(R.drawable.shrab);
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
                globalv.addmImageUrls(R.drawable.dress);
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
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(CLOTHES.this, globalv.getMrecords().get(i));
                    mediaPlay.start();*/

                    if (globalv.getMrecords().get(i) instanceof Integer) {
                        // The Object is an instance of a String
                        Integer M = (Integer) globalv.getMrecords().get(i);

                        MediaPlayer mediaPlayer=MediaPlayer.create(view.getContext(),M);
                        mediaPlayer.start();
                    }
                    else if (globalv.getMrecords().get(i) instanceof byte[]) {
                        // The Object is an instance of a Double
                        byte[] g = (byte[]) globalv.getMrecords().get(i);
                        playMp3FromByte(g);
                    }
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

    private void playMp3FromByte(byte[] mp3SoundByteArray) {
        try {
            File tempMp3 = File.createTempFile("kurchina", "mp3", getCacheDir());
            tempMp3.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempMp3);
            fos.write(mp3SoundByteArray);
            fos.close();

            MediaPlayer mediaPlayer = new MediaPlayer();

            FileInputStream fis = new FileInputStream(tempMp3);
            mediaPlayer.setDataSource(fis.getFD());
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException ex) {
            String s = ex.toString();
            ex.printStackTrace();
        }
    }

}
