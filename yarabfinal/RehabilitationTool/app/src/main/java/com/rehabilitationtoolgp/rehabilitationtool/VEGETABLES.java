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

public class VEGETABLES extends AppCompatActivity {
    private TextToSpeech textToSpeech;
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

        final ImageView tomato =(ImageView) findViewById(R.id.tomato);
        ImageView potato=(ImageView) findViewById(R.id.potato);
        final ImageView cucumber= (ImageView) findViewById(R.id.cucumb2 );
        final ImageView carrot =(ImageView) findViewById(R.id.carrot);
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
                if(tomato2.getText().toString().equalsIgnoreCase("Tomato")){
                    String data="tomato";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.tomato);
                    globalv.addmNames(tomato2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    tomatoplayer .start();
                    globalv.addMrecords(R.raw.tomatoesss);
                    globalv.addmImageUrls(R.drawable.tomato);
                    globalv.addmNames(tomato);
                }
                initRecyclerView();



            }
        });


        //POTATO
        final MediaPlayer potatoplayer = MediaPlayer.create(VEGETABLES.this,R.raw.potatoesss);
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(potato2.getText().toString().equalsIgnoreCase("Potato")){
                    String data="potato";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.btats);
                    globalv.addmNames(potato2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    potatoplayer .start();
                    globalv.addMrecords(R.raw.potatoesss);
                    globalv.addmImageUrls(R.drawable.btats);
                    globalv.addmNames(potato2);
                }
                initRecyclerView();



            }
        });


        //CUCUMBER
        final MediaPlayer cucumberplayer = MediaPlayer.create(VEGETABLES.this,R.raw.khearrr);
        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cucumber2.getText().toString().equalsIgnoreCase("Cucumber")){
                    String data="cucumber";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.kyar);
                    globalv.addmNames(cucumber2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    cucumberplayer .start();
                    globalv.addMrecords(R.raw.khearrr);
                    globalv.addmImageUrls(R.drawable.kyar);
                    globalv.addmNames(cucumber2);
                }
                initRecyclerView();



            }
        });


        //CARROT
        final MediaPlayer carrotplayer = MediaPlayer.create(VEGETABLES.this,R.raw.carrottt);
        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carrot2.getText().toString().equalsIgnoreCase("Carrot")){
                    String data="carrot";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.gazr);
                    globalv.addmNames(carrot2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    carrotplayer .start();
                    globalv.addMrecords(R.raw.carrottt);
                    globalv.addmImageUrls(R.drawable.gazr);
                    globalv.addmNames(carrot2);
                }
                initRecyclerView();



            }
        });

        //LETTUCE
        final MediaPlayer lettuceplayer = MediaPlayer.create(VEGETABLES.this,R.raw.khasss);
        lettuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lettuce2.getText().toString().equalsIgnoreCase("Lettuce")){
                    String data="lettuce";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.kas);
                    globalv.addmNames(lettuce2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    lettuceplayer .start();
                    globalv.addMrecords(R.raw.khasss);
                    globalv.addmImageUrls(R.drawable.kas);
                    globalv.addmNames(lettuce2);
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
