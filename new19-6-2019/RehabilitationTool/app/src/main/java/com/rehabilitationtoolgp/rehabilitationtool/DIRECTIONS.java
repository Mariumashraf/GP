package com.rehabilitationtoolgp.rehabilitationtool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.rehabilitationtoolgp.rehabilitationtool.Helper.LocalHelper;

import io.paperdb.Paper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DIRECTIONS extends AppCompatActivity {
    TextView left2,right2,inside2,outside2,along2,between2,around2,beside2,below2,above2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    private static final String TAG = "DIRECTIONS";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_directions);
        left2 = (TextView)findViewById(R.id.left2);
        right2 = (TextView)findViewById(R.id.right2);
        inside2 = (TextView)findViewById(R.id.inside2);
        outside2 = (TextView)findViewById(R.id.outside2);
        beside2 = (TextView)findViewById(R.id.beside2);
        along2 = (TextView)findViewById(R.id.along2);
        below2 = (TextView)findViewById(R.id.below2);
        between2 = (TextView)findViewById(R.id.between2);
        above2 = (TextView)findViewById(R.id.above2);
        around2 = (TextView)findViewById(R.id.around2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));

        ImageView above = (ImageView) findViewById(R.id.above);
        ImageView below = (ImageView) findViewById(R.id.below);
        ImageView beside = (ImageView) findViewById(R.id.beside);
        ImageView around = (ImageView) findViewById(R.id.around);
        ImageView between = (ImageView) findViewById(R.id.between);
        ImageView inside = (ImageView) findViewById(R.id.inside);
        ImageView right = (ImageView) findViewById(R.id.right);
        ImageView left = (ImageView) findViewById(R.id.left);
        ImageView along = (ImageView) findViewById(R.id.along);
        ImageView outside = (ImageView) findViewById(R.id.outside);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);



        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();
        final MediaPlayer alongplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.straight);
        along.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alongplayer.start();
                globalv.addmImageUrls(R.drawable.alatol);
                globalv.addmNames(along2);
                globalv.addMrecords(R.raw.straight);
                initRecyclerView();

            }
        });
        final MediaPlayer outplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.out);
        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outplayer.start();
                globalv.addmImageUrls(R.drawable.outside);
                globalv.addmNames(outside2);
                globalv.addMrecords(R.raw.out);
                initRecyclerView();

            }
        });


        //ABOVE
        final MediaPlayer aboveplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.uppp);
        above.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboveplayer.start();
                globalv.addmImageUrls(R.drawable.up);
                globalv.addmNames(above2);
                globalv.addMrecords(R.raw.uppp);
                initRecyclerView();

            }
        });

        //BELOW
        final MediaPlayer belowplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.underrr);
        below.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                belowplayer.start();
                globalv.addmImageUrls(R.drawable.down);
                globalv.addmNames(below2);
                globalv.addMrecords(R.raw.underrr);
                initRecyclerView();

            }
        });


        //BESIDE
        final MediaPlayer besideplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.beganppp);
        beside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                besideplayer.start();
                globalv.addmImageUrls(R.drawable.ganb);
                globalv.addmNames(beside2);
                globalv.addMrecords(R.raw.beganppp);
                initRecyclerView();

            }
        });

        //AROUND
        final MediaPlayer aroundplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.arounddd );
        around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aroundplayer.start();
                globalv.addmImageUrls(R.drawable.around);
                globalv.addmNames(around2);
                globalv.addMrecords(R.raw.arounddd );
                initRecyclerView();

            }
        });


        //BETWEEN
        final MediaPlayer betweenplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.betweennn );
        between.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betweenplayer.start();
                globalv.addmImageUrls(R.drawable.middle);
                globalv.addmNames(between2);
                globalv.addMrecords(R.raw.betweennn);
                initRecyclerView();

            }
        });

        //INSIDE
        final MediaPlayer insideplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.insideee );
        inside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insideplayer.start();
                globalv.addmImageUrls(R.drawable.inside);
                globalv.addmNames(inside2);
                globalv.addMrecords(R.raw.insideee);
                initRecyclerView();

            }
        });


        //RIGHT
        final MediaPlayer rightplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.righttt);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightplayer.start();
                globalv.addmImageUrls(R.drawable.right);
                globalv.addmNames(right2);
                globalv.addMrecords(R.raw.righttt);
                initRecyclerView();

            }
        });

        //LEFT
        final MediaPlayer leftplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.lefttt);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftplayer.start();
                globalv.addmImageUrls(R.drawable.left);
                globalv.addmNames(left2);
                globalv.addMrecords(R.raw.lefttt);
                initRecyclerView();

            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                   /* final MediaPlayer mediaPlay = MediaPlayer.create(DIRECTIONS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(DIRECTIONS.this,MainActivity.class);
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

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        left2.setText(resources.getString(R.string.left));
        right2.setText(resources.getString(R.string.right));
        inside2.setText(resources.getString(R.string.inside));
        outside2.setText(resources.getString(R.string.outside));
        beside2.setText(resources.getString(R.string.beside));
        above2.setText(resources.getString(R.string.above));
        below2.setText(resources.getString(R.string.below));
        along2.setText(resources.getString(R.string.along));
        between2.setText(resources.getString(R.string.between));
        around2.setText(resources.getString(R.string.around));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.language_en){
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else  if(item.getItemId() == R.id.language_ar){
            Paper.book().write("language","ar");
            updateView((String)Paper.book().read("language"));
        }
        return true;
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
