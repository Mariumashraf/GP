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

public class FRUIT extends AppCompatActivity {
    private static final String TAG = "FRUIT";
    Globalrecycler globalv;
    TextView orange2,watermelon2,apple2,guava2,peach2,grape2,Strawberries2,pear2,banana2,mango2,pome2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        orange2 = (TextView)findViewById(R.id.orange2);
        watermelon2 = (TextView)findViewById(R.id.watermelon2);
        apple2 = (TextView)findViewById(R.id.apple2);
        guava2 = (TextView)findViewById(R.id.guava2);
        peach2 = (TextView)findViewById(R.id.peach2);
        grape2 = (TextView)findViewById(R.id.grape2);
        Strawberries2 = (TextView)findViewById(R.id.Strawberries2);
        pear2 = (TextView)findViewById(R.id.pear2);
        banana2 = (TextView)findViewById(R.id.banana2);
        mango2 = (TextView)findViewById(R.id.mango2);
        pome2 = (TextView)findViewById(R.id.pome2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));



        ImageView orange = (ImageView) findViewById(R.id.orange);
        ImageView watermelon = (ImageView) findViewById(R.id.watermelon);
        ImageView apple = (ImageView) findViewById(R.id.apple);
        ImageView guava = (ImageView) findViewById(R.id.guava);
        ImageView peach= (ImageView) findViewById(R.id.peach);
        ImageView grape =(ImageView) findViewById(R.id.grape);
        ImageView Strawberries=(ImageView) findViewById(R.id.Strawberries);
        ImageView pear= (ImageView) findViewById(R.id.pear);
        ImageView mango =(ImageView) findViewById(R.id.mango);
        ImageView banana=(ImageView) findViewById(R.id.banana);
        ImageView roman=(ImageView) findViewById(R.id.pome);


        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);




        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //ORANGE

        final MediaPlayer orangeplayer= MediaPlayer.create(FRUIT.this,R.raw.orangeee);
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orangeplayer.start();
                globalv.addmImageUrls(R.drawable.orange);
                globalv.addmNames(orange2);
                globalv.addMrecords(R.raw.orangeee);
                initRecyclerView();



            }
        });

        //WATERMELON
        final MediaPlayer watermelonplayer = MediaPlayer.create(FRUIT.this,R.raw.watermelonnn);
        watermelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watermelonplayer.start();
                globalv.addmImageUrls(R.drawable.batek);
                globalv.addmNames(watermelon2);
                globalv.addMrecords(R.raw.watermelonnn);
                initRecyclerView();



            }
        });
        final MediaPlayer pomeplayer = MediaPlayer.create(FRUIT.this,R.raw.roman);
        roman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pomeplayer.start();
                globalv.addmImageUrls(R.drawable.roman);
                globalv.addmNames(pome2);
                globalv.addMrecords(R.raw.roman);
                initRecyclerView();



            }
        });

        //APPLE

        final MediaPlayer appleplayer= MediaPlayer.create(FRUIT.this,R.raw.appleee);
        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appleplayer.start();
                globalv.addmImageUrls(R.drawable.apple);
                globalv.addmNames(apple2);
                globalv.addMrecords(R.raw.appleee);
                initRecyclerView();



            }
        });

        //GUAVA
        final MediaPlayer guavaplayer = MediaPlayer.create(FRUIT.this,R.raw.guavaaa);
        guava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guavaplayer.start();
                globalv.addmImageUrls(R.drawable.gwafa);
                globalv.addmNames(guava2);
                globalv.addMrecords(R.raw.guavaaa);
                initRecyclerView();



            }
        });

        //PEACH

        final MediaPlayer peachplayer= MediaPlayer.create(FRUIT.this,R.raw.peachhh);
        peach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peachplayer.start();
                globalv.addmImageUrls(R.drawable.kok);
                globalv.addmNames(peach2);
                globalv.addMrecords(R.raw.peachhh);
                initRecyclerView();



            }
        });

        //GRAPE
        final MediaPlayer grapeplayer = MediaPlayer.create(FRUIT.this,R.raw.gripsss);
        grape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grapeplayer.start();
                globalv.addmImageUrls(R.drawable.enab);
                globalv.addmNames(grape2);
                globalv.addMrecords(R.raw.gripsss);
                initRecyclerView();



            }
        });

        //STRAWABERRIES

        final MediaPlayer strawplayer= MediaPlayer.create(FRUIT.this,R.raw.stroparyyy);
        Strawberries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strawplayer.start();
                globalv.addmImageUrls(R.drawable.frawla);
                globalv.addmNames(Strawberries2);
                globalv.addMrecords(R.raw.stroparyyy);
                initRecyclerView();



            }
        });

        //PEAR
        final MediaPlayer pearplayer = MediaPlayer.create(FRUIT.this,R.raw.kometraaa);
        pear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pearplayer.start();
                globalv.addmImageUrls(R.drawable.komtra);
                globalv.addmNames(pear2);
                globalv.addMrecords(R.raw.kometraaa);
                initRecyclerView();



            }
        });

        //MANGO

        final MediaPlayer mangoplayer= MediaPlayer.create(FRUIT.this,R.raw.mangooo);
        mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mangoplayer.start();
                globalv.addmImageUrls(R.drawable.mango);
                globalv.addmNames(mango2);
                globalv.addMrecords(R.raw.mangooo);
                initRecyclerView();



            }
        });

        //BANANA
        final MediaPlayer bananaplayer = MediaPlayer.create(FRUIT.this,R.raw.bananaaa);
        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bananaplayer.start();
                globalv.addmImageUrls(R.drawable.mozz);
                globalv.addmNames(banana2);
                globalv.addMrecords(R.raw.bananaaa);
                initRecyclerView();



            }
        });

        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(FRUIT.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(FRUIT.this,FOODS.class);
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
        pome2.setText(resources.getString(R.string.pome));
        mango2.setText(resources.getString(R.string.mango));
        banana2.setText(resources.getString(R.string.banana));
        pear2.setText(resources.getString(R.string.pear));
        Strawberries2.setText(resources.getString(R.string.strawberries));
        grape2.setText(resources.getString(R.string.grape));
        peach2.setText(resources.getString(R.string.peach));
        guava2.setText(resources.getString(R.string.guava));
        apple2.setText(resources.getString(R.string.apple));
        watermelon2.setText(resources.getString(R.string.watermelon));
        orange2.setText(resources.getString(R.string.orange));





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
