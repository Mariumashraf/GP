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

import io.paperdb.Paper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VEGETABLES extends AppCompatActivity {
    TextView lettuce2,potato2,cucumber2,tomato2,carrot2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    private static final String TAG = "VEGETABLES";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        lettuce2 = (TextView)findViewById(R.id.lettuce2);
        potato2 = (TextView)findViewById(R.id.potato2);
        cucumber2 = (TextView)findViewById(R.id.cucumber2);
        tomato2 = (TextView)findViewById(R.id.tomato2);
        carrot2 = (TextView)findViewById(R.id.carrot2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));

        ImageView tomato =(ImageView) findViewById(R.id.tomato);
        ImageView potato=(ImageView) findViewById(R.id.potato);
        ImageView cucumber= (ImageView) findViewById(R.id.cucumb2 );
        ImageView carrot =(ImageView) findViewById(R.id.carrot);
        ImageView lettuce=(ImageView) findViewById(R.id.lettuce);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //TOMATO
        final MediaPlayer tomatoplayer = MediaPlayer.create(VEGETABLES.this,R.raw.tomatoesss);
        tomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomatoplayer.start();
                globalv.addmImageUrls(R.drawable.tomato);
                globalv.addmNames(tomato2);
                globalv.addMrecords(R.raw.tomatoesss);
                initRecyclerView();



            }
        });


        //POTATO
        final MediaPlayer potatoplayer = MediaPlayer.create(VEGETABLES.this,R.raw.potatoesss);
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                potatoplayer.start();
                globalv.addmImageUrls(R.drawable.btats);
                globalv.addmNames(potato2);
                globalv.addMrecords(R.raw.potatoesss);
                initRecyclerView();



            }
        });


        //CUCUMBER
        final MediaPlayer cucumberplayer = MediaPlayer.create(VEGETABLES.this,R.raw.khearrr);
        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cucumberplayer.start();
                globalv.addmImageUrls(R.drawable.kyar);
                globalv.addmNames(cucumber2);
                globalv.addMrecords(R.raw.khearrr);
                initRecyclerView();



            }
        });


        //CARROT
        final MediaPlayer carrotplayer = MediaPlayer.create(VEGETABLES.this,R.raw.carrottt);
        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carrotplayer.start();
                globalv.addmImageUrls(R.drawable.gazr);
                globalv.addmNames(carrot2);
                globalv.addMrecords(R.raw.carrottt);
                initRecyclerView();



            }
        });

        //LETTUCE
        final MediaPlayer lettuceplayer = MediaPlayer.create(VEGETABLES.this,R.raw.khasss);
        lettuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lettuceplayer.start();
                globalv.addmImageUrls(R.drawable.kas);
                globalv.addmNames(lettuce2);
                globalv.addMrecords(R.raw.khasss);
                initRecyclerView();



            }
        });



        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(VEGETABLES.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(VEGETABLES.this,FOODS.class);
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

<<<<<<< HEAD
    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        carrot2.setText(resources.getString(R.string.carrot));
        cucumber2.setText(resources.getString(R.string.cucumber));
        lettuce2.setText(resources.getString(R.string.lettuce));
        tomato2.setText(resources.getString(R.string.tomato));
        potato2.setText(resources.getString(R.string.potato));




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
=======
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
>>>>>>> f0cf9b186c6d0b3f8063256bd9283c5b02504fb2
    }
}
