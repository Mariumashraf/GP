package com.rehabilitationtoolgp.rehabilitationtool;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import io.paperdb.Paper;

public class DRINKS extends AppCompatActivity {
    private static final String TAG = "DRINKS";
    Globalrecycler globalv;
    TextView water2,juice2,milk2;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        water2 = (TextView)findViewById(R.id.water2);
        juice2  = (TextView)findViewById(R.id.juice2);
        milk2  = (TextView)findViewById(R.id.milk2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        ImageView juice = (ImageView) findViewById(R.id.juice);
        ImageView water = (ImageView) findViewById(R.id.water);
        ImageView milk = (ImageView) findViewById(R.id.milk);
        Button back = (Button) findViewById(R.id.back);
        ImageButton play = (ImageButton) findViewById(R.id.playall);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //JUICE
        final MediaPlayer juiceplayer = MediaPlayer.create(DRINKS.this,R.raw.juiceee);
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                juiceplayer.start();
                globalv.addmImageUrls(R.drawable.aser);
                globalv.addmNames(juice2);
                globalv.addMrecords(R.raw.juiceee);
                initRecyclerView();

            }
        });

        //WATER
        final MediaPlayer waterplayer = MediaPlayer.create(DRINKS.this,R.raw.waterrr);
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterplayer.start();
                globalv.addmImageUrls(R.drawable.water);
                globalv.addmNames(water2);
                globalv.addMrecords(R.raw.waterrr);
                initRecyclerView();

            }
        });

        //MILK
        final MediaPlayer milkplayer = MediaPlayer.create(DRINKS.this,R.raw.milkkk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                milkplayer.start();
                globalv.addmImageUrls(R.drawable.labn);
                globalv.addmNames(milk2);
                globalv.addMrecords(R.raw.milkkk);
                initRecyclerView();



            }
        });


        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(DRINKS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(DRINKS.this,Main2Activity.class);
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

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        water2.setText(resources.getString(R.string.water));
        juice2.setText(resources.getString(R.string.juice));
        milk2.setText(resources.getString(R.string.milk));

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

