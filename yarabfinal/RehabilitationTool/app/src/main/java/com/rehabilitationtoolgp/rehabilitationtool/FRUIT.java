package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
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
import android.widget.Toast;

import com.rehabilitationtoolgp.rehabilitationtool.Helper.LocalHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import io.paperdb.Paper;

public class FRUIT extends AppCompatActivity {
    private TextToSpeech textToSpeech;
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
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                } else {
                    Toast.makeText(getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
        final ImageView watermelon = (ImageView) findViewById(R.id.watermelon);
        ImageView apple = (ImageView) findViewById(R.id.apple);
        final ImageView guava = (ImageView) findViewById(R.id.guava);
        ImageView peach= (ImageView) findViewById(R.id.peach);
        ImageView grape =(ImageView) findViewById(R.id.grape);
        final ImageView Strawberries=(ImageView) findViewById(R.id.Strawberries);
        final ImageView pear= (ImageView) findViewById(R.id.pear);
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
                if(orange2.getText().toString().equalsIgnoreCase("Orange")){
                    String data="orange";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.orange);
                    globalv.addmNames(orange2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    orangeplayer .start();
                    globalv.addMrecords(R.raw.orangeee);
                    globalv.addmImageUrls(R.drawable.orange);
                    globalv.addmNames(orange2);
                }
                initRecyclerView();



            }
        });

        //WATERMELON
        final MediaPlayer watermelonplayer = MediaPlayer.create(FRUIT.this,R.raw.watermelonnn);
        watermelon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(watermelon2.getText().toString().equalsIgnoreCase("Watermelon")){
                    String data="watermelon";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.batek);
                    globalv.addmNames(watermelon2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    watermelonplayer .start();
                    globalv.addMrecords(R.raw.watermelonnn);
                    globalv.addmImageUrls(R.drawable.batek);
                    globalv.addmNames(watermelon2);
                }
                initRecyclerView();



            }
        });
        final MediaPlayer pomeplayer = MediaPlayer.create(FRUIT.this,R.raw.roman);
        roman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pome2.getText().toString().equalsIgnoreCase("Pome")){
                    String data="pome";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.roman);
                    globalv.addmNames(pome2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    pomeplayer .start();
                    globalv.addMrecords(R.raw.roman);
                    globalv.addmImageUrls(R.drawable.roman);
                    globalv.addmNames(pome2);
                }
                initRecyclerView();



            }
        });

        //APPLE

        final MediaPlayer appleplayer= MediaPlayer.create(FRUIT.this,R.raw.appleee);
        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(apple2.getText().toString().equalsIgnoreCase("Apple")){
                    String data="apple";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.apple);
                    globalv.addmNames(apple2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    appleplayer .start();
                    globalv.addMrecords(R.raw.appleee);
                    globalv.addmImageUrls(R.drawable.apple);
                    globalv.addmNames(apple2);
                }
                initRecyclerView();



            }
        });

        //GUAVA
        final MediaPlayer guavaplayer = MediaPlayer.create(FRUIT.this,R.raw.guavaaa);
        guava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(guava2.getText().toString().equalsIgnoreCase("Guava")){
                    String data="guava";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.gwafa);
                    globalv.addmNames(guava2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    guavaplayer .start();
                    globalv.addMrecords(R.raw.guavaaa);
                    globalv.addmImageUrls(R.drawable.gwafa);
                    globalv.addmNames(guava2);
                }
                initRecyclerView();



            }
        });

        //PEACH

        final MediaPlayer peachplayer= MediaPlayer.create(FRUIT.this,R.raw.peachhh);
        peach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(peach2.getText().toString().equalsIgnoreCase("Peach")){
                    String data="peach";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.kok);
                    globalv.addmNames(peach2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    peachplayer .start();
                    globalv.addMrecords(R.raw.peachhh);
                    globalv.addmImageUrls(R.drawable.kok);
                    globalv.addmNames(peach2);
                }
                initRecyclerView();



            }
        });

        //GRAPE
        final MediaPlayer grapeplayer = MediaPlayer.create(FRUIT.this,R.raw.gripsss);
        grape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(grape2.getText().toString().equalsIgnoreCase("Grape")){
                    String data="grape";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.enab);
                    globalv.addmNames(grape2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    grapeplayer .start();
                    globalv.addMrecords(R.raw.gripsss);
                    globalv.addmImageUrls(R.drawable.enab);
                    globalv.addmNames(grape2);
                }
                initRecyclerView();



            }
        });

        //STRAWABERRIES

        final MediaPlayer strawplayer= MediaPlayer.create(FRUIT.this,R.raw.stroparyyy);
        Strawberries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Strawberries2.getText().toString().equalsIgnoreCase("Strawberries")){
                    String data="strawberries";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.frawla);
                    globalv.addmNames(Strawberries2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    strawplayer .start();
                    globalv.addMrecords(R.raw.stroparyyy);
                    globalv.addmImageUrls(R.drawable.frawla);
                    globalv.addmNames(Strawberries2);
                }



                initRecyclerView();



            }
        });

        //PEAR
        final MediaPlayer pearplayer = MediaPlayer.create(FRUIT.this,R.raw.kometraaa);
        pear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pear2.getText().toString().equalsIgnoreCase("Pear")){
                    String data="pear";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.komtra);
                    globalv.addmNames(pear2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    peachplayer .start();
                    globalv.addMrecords(R.raw.kometraaa);
                    globalv.addmImageUrls(R.drawable.komtra);
                    globalv.addmNames(pear);
                }
                initRecyclerView();



            }
        });

        //MANGO

        final MediaPlayer mangoplayer= MediaPlayer.create(FRUIT.this,R.raw.mangooo);
        mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mango2.getText().toString().equalsIgnoreCase("Mango")){
                    String data="mango";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.mango);
                    globalv.addmNames(mango2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    mangoplayer .start();
                    globalv.addMrecords(R.raw.mangooo);
                    globalv.addmImageUrls(R.drawable.mango);
                    globalv.addmNames(mango2);
                }
                initRecyclerView();



            }
        });

        //BANANA
        final MediaPlayer bananaplayer = MediaPlayer.create(FRUIT.this,R.raw.bananaaa);
        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(banana2.getText().toString().equalsIgnoreCase("Banana")){
                    String data="banana";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.mozz);
                    globalv.addmNames(banana2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    bananaplayer .start();
                    globalv.addMrecords(R.raw.bananaaa);
                    globalv.addmImageUrls(R.drawable.mozz);
                    globalv.addmNames(banana2);
                }
                initRecyclerView();



            }
        });

        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(MainActivity.this, globalv.getMrecords().get(i));
                    mediaPlay.start();*/
                    if(globalv.getmNames().get(i) instanceof TextView){
                        TextView M = (TextView) globalv.getmNames().get(i);
                        int t = 1;
                        switch(t){
                            case 1:   if (globalv.getMrecords().get(i) instanceof Integer && Locale.getDefault().getLanguage().equals("en")) {
                                // The Object is an instance of a String
                                Integer N = (Integer) globalv.getMrecords().get(i);
                                String data = (String)M.getText().toString();
                                int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                            }
                            case 2:if(globalv.getMrecords().get(i) instanceof Integer && Locale.getDefault().getLanguage().equals("ar")){
                                // The Object is an instance of a String
                                Integer N = (Integer) globalv.getMrecords().get(i);

                                MediaPlayer mediaPlayer=MediaPlayer.create(view.getContext(),N);
                                mediaPlayer.start();



                            }}


                    }else if (globalv.getmNames().get(i) instanceof String){
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
            globalv.getmNames().clear();
            globalv.getmImageUrls().clear();
            globalv.getMrecords().clear();
        }
        else  if(item.getItemId() == R.id.language_ar){
            Paper.book().write("language","ar");
            updateView((String)Paper.book().read("language"));
            globalv.getmNames().clear();
            globalv.getmImageUrls().clear();
            globalv.getMrecords().clear();
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
