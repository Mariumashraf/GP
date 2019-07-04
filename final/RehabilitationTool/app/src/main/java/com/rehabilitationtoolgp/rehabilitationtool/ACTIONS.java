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

public class ACTIONS extends AppCompatActivity {
    public TextToSpeech textToSpeech;

    TextView smile2,write2,speak2,run2,think2,wash2,sleep2,watch2,close2,open2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    private static final String TAG = "ACTIONS";
    Globalrecycler globalv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_actions);
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

        smile2 = (TextView)findViewById(R.id.smile2);
        write2 = (TextView)findViewById(R.id.write2);
        speak2 = (TextView)findViewById(R.id.speak2);
        run2 = (TextView)findViewById(R.id.run2);
        think2 = (TextView)findViewById(R.id.think2);
        wash2 = (TextView)findViewById(R.id.wash2);
        watch2 = (TextView)findViewById(R.id.watch2);
        sleep2 = (TextView)findViewById(R.id.sleep2);
        close2 = (TextView)findViewById(R.id.close2);
        open2 = (TextView)findViewById(R.id.open2);
        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));
        ImageView cards= (ImageView) findViewById(R.id.c);
        ImageView practice = (ImageView) findViewById(R.id.speechvrifecation);


        ImageView smile = (ImageView) findViewById(R.id.smile);
        ImageView write= (ImageView) findViewById(R.id.write);
        ImageView speak = (ImageView) findViewById(R.id.speak);
        ImageView run = (ImageView) findViewById(R.id.run);
        ImageView think = (ImageView) findViewById(R.id.think);
        ImageView wash = (ImageView) findViewById(R.id.wash);
        ImageView sleep=(ImageView) findViewById(R.id.sleep);
        ImageView watchh = (ImageView) findViewById(R.id.watch);
        ImageView close =(ImageView) findViewById(R.id.close);
        ImageView open=(ImageView) findViewById(R.id.open);

        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        final MediaPlayer OPENplayer =MediaPlayer.create(ACTIONS.this, R.raw.lockkk);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open2.getText().toString().equalsIgnoreCase("Open")){
                    String data="open";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.open);
                    globalv.addmNames(open2);;

                }
                else{
                    OPENplayer .start();
                    globalv.addMrecords(R.raw.open);
                    globalv.addmImageUrls(R.drawable.open);
                    globalv.addmNames(open2);
                }


                initRecyclerView();



            }
        });
        //؟؟؟

        final MediaPlayer washplayer =MediaPlayer.create(ACTIONS.this, R.raw.wash);
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wash2.getText().toString().equalsIgnoreCase("Wash")){
                    String data="wash";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.wash);
                    globalv.addmNames(wash2);;

                }
                else{
                    washplayer .start();
                    globalv.addMrecords(R.raw.wash);
                    globalv.addmImageUrls(R.drawable.wash);
                    globalv.addmNames(wash2);
                }
                initRecyclerView();

            }
        });
        final MediaPlayer thinkplayer =MediaPlayer.create(ACTIONS.this, R.raw.thinkkk);
        think.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(think2.getText().toString().equalsIgnoreCase("Think")){
                    String data="think";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.think);
                    globalv.addmNames(think2);;

                }
                else{
                    thinkplayer .start();
                    globalv.addMrecords(R.raw.thinkkk);
                    globalv.addmImageUrls(R.drawable.think);
                    globalv.addmNames(think2);
                }
                initRecyclerView();

            }
        });
        final MediaPlayer writeplayer =MediaPlayer.create(ACTIONS.this, R.raw.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(write2.getText().toString().equalsIgnoreCase("Write")){
                    String data="write";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.write);
                    globalv.addmNames(write2);;

                }
                else{
                    writeplayer .start();
                    globalv.addMrecords(R.raw.write);
                    globalv.addmImageUrls(R.drawable.write);
                    globalv.addmNames(write2);
                }
                initRecyclerView();

            }
        });


        //SMILE
        final MediaPlayer smileplayer =MediaPlayer.create(ACTIONS.this, R.raw.smileee);
        smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(smile2.getText().toString().equalsIgnoreCase("Smile")){
                    String data="smile";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.happy);
                    globalv.addmNames(smile2);;

                }
                else{
                    smileplayer .start();
                    globalv.addMrecords(R.raw.smileee);
                    globalv.addmImageUrls(R.drawable.happy);
                    globalv.addmNames(smile2);
                }
                initRecyclerView();

            }
        });




        //SPEAK
        final MediaPlayer speakplayer =MediaPlayer.create(ACTIONS.this, R.raw.speakkk);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(speak2.getText().toString().equalsIgnoreCase("Speak")){
                    String data="speak";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.talk);
                    globalv.addmNames(speak2);;

                }
                else{
                    speakplayer .start();
                    globalv.addMrecords(R.raw.speakkk);
                    globalv.addmImageUrls(R.drawable.talk);
                    globalv.addmNames(speak2);
                }
                initRecyclerView();

            }
        });


        //RUN
        final MediaPlayer runplayer =MediaPlayer.create(ACTIONS.this, R.raw.runnn);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(run2.getText().toString().equalsIgnoreCase("Run")){
                    String data="run";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.run);
                    globalv.addmNames(run2);;

                }
                else{
                    runplayer .start();
                    globalv.addMrecords(R.raw.runnn);
                    globalv.addmImageUrls(R.drawable.run);
                    globalv.addmNames(run2);
                }
                initRecyclerView();

            }
        });




        //WATCH
        final MediaPlayer watchplayer =MediaPlayer.create(ACTIONS.this, R.raw.watchhh);
        watchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(watch2.getText().toString().equalsIgnoreCase("Watch")){
                    String data="watch";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.watchh);
                    globalv.addmNames(watch2);;

                }
                else{
                    washplayer .start();
                    globalv.addMrecords(R.raw.watchhh);
                    globalv.addmImageUrls(R.drawable.watchh);
                    globalv.addmNames(watch2);
                }
                initRecyclerView();

            }
        });




        //CLOSE
        final MediaPlayer closeplayer =MediaPlayer.create(ACTIONS.this, R.raw.lockkk);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(close2.getText().toString().equalsIgnoreCase("Close")){
                    String data="close";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.closed);
                    globalv.addmNames(close2);;
                }
                else{
                    closeplayer .start();
                    globalv.addMrecords(R.raw.lockkk);
                    globalv.addmImageUrls(R.drawable.yes);
                    globalv.addmNames(close2);
                }
                initRecyclerView();

            }
        });

        //SLEEP
        final MediaPlayer sleepplayer =MediaPlayer.create(ACTIONS.this, R.raw.sleeppp);
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sleep2.getText().toString().equalsIgnoreCase("Sleep")){
                    String data="sleep";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.sleep);
                    globalv.addmNames(sleep2);;

                }
                else{
                    sleepplayer .start();
                    globalv.addMrecords(R.raw.sleeppp);
                    globalv.addmImageUrls(R.drawable.sleep);
                    globalv.addmNames(sleep2);
                }
                initRecyclerView();

            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                   /* final MediaPlayer mediaPlay = MediaPlayer.create(ACTIONS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(ACTIONS.this,Main2Activity.class);
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
        smile2.setText(resources.getString(R.string.smile));
        sleep2.setText(resources.getString(R.string.sleep));
        wash2.setText(resources.getString(R.string.wash));
        watch2.setText(resources.getString(R.string.watch));
        open2.setText(resources.getString(R.string.open));
        close2.setText(resources.getString(R.string.close));
        think2.setText(resources.getString(R.string.think));
        write2.setText(resources.getString(R.string.write));
        run2.setText(resources.getString(R.string.run));
        speak2.setText(resources.getString(R.string.speak));



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
    private void speakWords(String speech) {

        //speak straight away
        textToSpeech.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
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
