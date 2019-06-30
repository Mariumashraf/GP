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

public class Questions extends AppCompatActivity {
    private static final String TAG = "Questions";
    Globalrecycler globalv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        ImageView where = (ImageView) findViewById(R.id.where);
        ImageView why= (ImageView) findViewById(R.id.why);
        ImageView who =(ImageView) findViewById(R.id.who);
        ImageView whichone=(ImageView) findViewById(R.id.whichone);
        ImageView when= (ImageView) findViewById(R.id.when);
        ImageView time =(ImageView) findViewById(R.id.timeee);
        ImageView howmoney=(ImageView) findViewById(R.id.howmoney);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



        final MediaPlayer whereplayer= MediaPlayer.create(Questions.this,R.raw.where);
        where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whereplayer.start();
                globalv.addmImageUrls(R.drawable.where);
                globalv.addmNames("أين");
                globalv.addMrecords(R.raw.where);
                initRecyclerView();



            }
        });

        final MediaPlayer whyplayer = MediaPlayer.create(Questions.this,R.raw.why);
        why.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whyplayer.start();
                globalv.addmImageUrls(R.drawable.lmazaa);
                globalv.addmNames("ليه");
                globalv.addMrecords(R.raw.why);
                initRecyclerView();



            }
        });



        final MediaPlayer riceplayer= MediaPlayer.create(Questions.this,R.raw.who);
        who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                riceplayer.start();
                globalv.addmImageUrls(R.drawable.who);
                globalv.addmNames("من؟");
                globalv.addMrecords(R.raw.who);
                initRecyclerView();



            }
        });

        final MediaPlayer whichplayer = MediaPlayer.create(Questions.this,R.raw.whichone);
        whichone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichplayer.start();
                globalv.addmImageUrls(R.drawable.whichone);
                globalv.addmNames("اى واحدة؟");
                globalv.addMrecords(R.raw.whichone);
                initRecyclerView();



            }
        });


        final MediaPlayer whenplayer= MediaPlayer.create(Questions.this,R.raw.when);
        when.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whenplayer.start();
                globalv.addmImageUrls(R.drawable.date);
                globalv.addmNames("امتى");
                globalv.addMrecords(R.raw.when);
                initRecyclerView();



            }
        });

        final MediaPlayer timeplayer = MediaPlayer.create(Questions.this,R.raw.timekam);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeplayer.start();
                globalv.addmImageUrls(R.drawable.time);
                globalv.addmNames("كم الوقت؟");
                globalv.addMrecords(R.raw.timekam);
                initRecyclerView();



            }
        });

        //EGG
        final MediaPlayer monplayer = MediaPlayer.create(Questions.this,R.raw.howmany);
        howmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monplayer.start();
                globalv.addmImageUrls(R.drawable.money);
                globalv.addmNames("بكام؟");
                globalv.addMrecords(R.raw.howmany);
                initRecyclerView();



            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(Questions.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(Questions.this,MainActivity.class);
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
