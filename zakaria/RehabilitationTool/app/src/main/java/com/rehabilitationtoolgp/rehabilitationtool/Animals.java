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

public class Animals extends AppCompatActivity {
    TextView bird2,fish3,dog2,cat2,insect2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }


    private static final String TAG = "Animals";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        bird2 = (TextView)findViewById(R.id.bird2);
        fish3 = (TextView)findViewById(R.id.fish3);
        dog2 = (TextView)findViewById(R.id.dog2);
        cat2 = (TextView)findViewById(R.id.cat2);
        insect2 = (TextView)findViewById(R.id.insect2);
        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));

        ImageView cat = (ImageView) findViewById(R.id.cat);
        ImageView dog = (ImageView) findViewById(R.id.dog);
        ImageView bird = (ImageView) findViewById(R.id.bird);
        ImageView samak = (ImageView) findViewById(R.id.samka);
        ImageView insect = (ImageView) findViewById(R.id.insect);
        Button back = (Button) findViewById(R.id.back);
        ImageButton play = (ImageButton) findViewById(R.id.playall);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        final MediaPlayer catplayer = MediaPlayer.create(Animals.this,R.raw.cat);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catplayer.start();
                globalv.addmImageUrls(R.drawable.cat);
                globalv.addmNames(cat2);
                globalv.addMrecords(R.raw.cat);
                initRecyclerView();

            }
        });


        final MediaPlayer dogplayer = MediaPlayer.create(Animals.this,R.raw.dog);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dogplayer.start();
                globalv.addmImageUrls(R.drawable.dog);
                globalv.addmNames(dog2);
                globalv.addMrecords(R.raw.dog);
                initRecyclerView();

            }
        });


        final MediaPlayer birdplayer = MediaPlayer.create(Animals.this,R.raw.bird);
        bird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birdplayer.start();
                globalv.addmImageUrls(R.drawable.bird);
                globalv.addmNames(bird2);
                globalv.addMrecords(R.raw.bird);
                initRecyclerView();

            }
        });


        final MediaPlayer samkplayer = MediaPlayer.create(Animals.this,R.raw.fishhh);
        samak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                samkplayer.start();
                globalv.addmImageUrls(R.drawable.fish);
                globalv.addmNames(fish3);
                globalv.addMrecords(R.raw.fishhh);
                initRecyclerView();

            }
        });

        final MediaPlayer insectplayer = MediaPlayer.create(Animals.this,R.raw.insect);
        insect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insectplayer.start();
                globalv.addmImageUrls(R.drawable.insect);
                globalv.addmNames(insect2);
                globalv.addMrecords(R.raw.insect);
                initRecyclerView();

            }
        });



        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(Animals.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(Animals.this,Main2Activity.class);
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
        bird2.setText(resources.getString(R.string.bird));
        insect2.setText(resources.getString(R.string.insect));
        dog2.setText(resources.getString(R.string.dog));
        cat2.setText(resources.getString(R.string.cat));
        fish3.setText(resources.getString(R.string.fish));


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

}
