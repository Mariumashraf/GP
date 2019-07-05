package com.rehabilitationtoolgp.rehabilitationtool;

import android.annotation.SuppressLint;
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

public class DIRECTIONS extends AppCompatActivity {
    private TextToSpeech textToSpeech;
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
                if(along2.getText().toString().equalsIgnoreCase("Along")){
                    String data="along";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.alatol);
                    globalv.addmNames(along2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    alongplayer .start();
                    globalv.addMrecords(R.raw.straight);
                    globalv.addmImageUrls(R.drawable.alatol);
                    globalv.addmNames(along2);
                }
                initRecyclerView();

            }
        });
        final MediaPlayer outplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.out);
        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(outside2.getText().toString().equalsIgnoreCase("Outside")){
                    String data="outside";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.outside);
                    globalv.addmNames(outside2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    outplayer .start();
                    globalv.addMrecords(R.raw.out);
                    globalv.addmImageUrls(R.drawable.outside);
                    globalv.addmNames(outside2);
                }
                initRecyclerView();

            }
        });


        //ABOVE
        final MediaPlayer aboveplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.uppp);
        above.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(above2.getText().toString().equalsIgnoreCase("Above")){
                    String data="above";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.up);
                    globalv.addmNames(above2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    aboveplayer .start();
                    globalv.addMrecords(R.raw.uppp);
                    globalv.addmImageUrls(R.drawable.up);
                    globalv.addmNames(above2);
                }
                initRecyclerView();

            }
        });

        //BELOW
        final MediaPlayer belowplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.underrr);
        below.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(below2.getText().toString().equalsIgnoreCase("Below")){
                    String data="below";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.down);
                    globalv.addmNames(below2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    belowplayer .start();
                    globalv.addMrecords(R.raw.underrr);
                    globalv.addmImageUrls(R.drawable.down);
                    globalv.addmNames(below2);
                }
                initRecyclerView();

            }
        });


        //BESIDE
        final MediaPlayer besideplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.beganppp);
        beside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(beside2.getText().toString().equalsIgnoreCase("Beside")){
                    String data="beside";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.ganb);
                    globalv.addmNames(beside2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    besideplayer .start();
                    globalv.addMrecords(R.raw.beganppp);
                    globalv.addmImageUrls(R.drawable.ganb);
                    globalv.addmNames(beside2);
                }
                initRecyclerView();

            }
        });

        //AROUND
        final MediaPlayer aroundplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.arounddd );
        around.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(around2.getText().toString().equalsIgnoreCase("Around")){
                    String data="around";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.around);
                    globalv.addmNames(around2);
                    globalv.addMrecords(speechStatus);



                }
                else{
                    aroundplayer .start();
                    globalv.addMrecords(R.raw.arounddd);
                    globalv.addmImageUrls(R.drawable.around);
                    globalv.addmNames(around2);
                }
                initRecyclerView();

            }
        });


        //BETWEEN
        final MediaPlayer betweenplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.betweennn );
        between.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(between2.getText().toString().equalsIgnoreCase("Between")){
                    String data="between";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.middle);
                    globalv.addmNames(between2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    betweenplayer .start();
                    globalv.addMrecords(R.raw.betweennn);
                    globalv.addmImageUrls(R.drawable.middle);
                    globalv.addmNames(between2);
                }
                initRecyclerView();

            }
        });

        //INSIDE
        final MediaPlayer insideplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.insideee );
        inside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inside2.getText().toString().equalsIgnoreCase("Inside")){
                    String data="inside";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.inside);
                    globalv.addmNames(inside2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    insideplayer .start();
                    globalv.addMrecords(R.raw.insideee);
                    globalv.addmImageUrls(R.drawable.inside);
                    globalv.addmNames(inside2);
                }
                initRecyclerView();

            }
        });


        //RIGHT
        final MediaPlayer rightplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.righttt);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(right2.getText().toString().equalsIgnoreCase("Right")){
                    String data="right";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.right);
                    globalv.addmNames(right2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    rightplayer .start();
                    globalv.addMrecords(R.raw.righttt);
                    globalv.addmImageUrls(R.drawable.right);
                    globalv.addmNames(right2);
                }
                initRecyclerView();

            }
        });

        //LEFT
        final MediaPlayer leftplayer =MediaPlayer.create(DIRECTIONS.this, R.raw.lefttt);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(left2.getText().toString().equalsIgnoreCase("Left")){
                    String data="left";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.left);
                    globalv.addmNames(left2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    leftplayer .start();
                    globalv.addMrecords(R.raw.lefttt);
                    globalv.addmImageUrls(R.drawable.left);
                    globalv.addmNames(left2);
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

                Intent intent1 = new Intent(DIRECTIONS.this,Main2Activity.class);
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
