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

public class TIME extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private static final String TAG = "TIME";
    TextView morning2,night2,sunset2,today2,yesterday2,tomorrow2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
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


        yesterday2 = (TextView)findViewById(R.id.yesterdat2);
        tomorrow2 = (TextView)findViewById(R.id.tomoorrow2);
        today2 = (TextView)findViewById(R.id.today2);
        sunset2 = (TextView)findViewById(R.id.sunset2);
        night2 = (TextView)findViewById(R.id.night2);
        morning2 = (TextView)findViewById(R.id.morning2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        ImageView morning =(ImageView) findViewById(R.id.morning);
        ImageView night=(ImageView) findViewById(R.id.night);
        ImageView sunset =(ImageView) findViewById(R.id.sunset);
        ImageView today=(ImageView) findViewById(R.id.today);
        ImageView yesterday =(ImageView) findViewById(R.id.yesterday);
        ImageView tomorrow=(ImageView) findViewById(R.id.tomorrow);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



        //MORNING

        final MediaPlayer morningplayer= MediaPlayer.create(TIME.this,R.raw.morninggg);
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(morning2.getText().toString().equalsIgnoreCase("Morning")){
                    String data="morning";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.morning);
                    globalv.addmNames(morning2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    morningplayer .start();
                    globalv.addMrecords(R.raw.morninggg);
                    globalv.addmImageUrls(R.drawable.morning);
                    globalv.addmNames(morning2);
                }
                initRecyclerView();



            }
        });

        //NIGHT
        final MediaPlayer nightplayer = MediaPlayer.create(TIME.this,R.raw.nighttt);
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(night2.getText().toString().equalsIgnoreCase("Night")){
                    String data="night";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.night);
                    globalv.addmNames(night2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    nightplayer .start();
                    globalv.addMrecords(R.raw.nighttt);
                    globalv.addmImageUrls(R.drawable.night);
                    globalv.addmNames(night2);
                }
                initRecyclerView();



            }
        });

        //MORNING

        final MediaPlayer sunplayer= MediaPlayer.create(TIME.this,R.raw.sunset);
        sunset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sunset2.getText().toString().equalsIgnoreCase("Sunset")){
                    String data="sunset";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.sunset);
                    globalv.addmNames(sunset2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    sunplayer .start();
                    globalv.addMrecords(R.raw.sunset);
                    globalv.addmImageUrls(R.drawable.sunset);
                    globalv.addmNames(sunset2);
                }
                initRecyclerView();



            }
        });

        final MediaPlayer todayplayer = MediaPlayer.create(TIME.this,R.raw.today);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(today2.getText().toString().equalsIgnoreCase("Today")){
                    String data="today";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.today);
                    globalv.addmNames(today2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    todayplayer .start();
                    globalv.addMrecords(R.raw.today);
                    globalv.addmImageUrls(R.drawable.today);
                    globalv.addmNames(today2);
                }
                initRecyclerView();



            }
        });


        final MediaPlayer tomorroplayer= MediaPlayer.create(TIME.this,R.raw.tomorrw);
        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tomorrow2.getText().toString().equalsIgnoreCase("Tomorrow")){
                    String data="tomorrow";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.tomorrow);
                    globalv.addmNames(tomorrow2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    tomorroplayer .start();
                    globalv.addMrecords(R.raw.gooo);
                    globalv.addmImageUrls(R.drawable.tomorrow);
                    globalv.addmNames(tomorrow2);
                }
                initRecyclerView();



            }
        });

        final MediaPlayer yesterplayer = MediaPlayer.create(TIME.this,R.raw.yesterday);
        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(yesterday2.getText().toString().equalsIgnoreCase("Yesterday")){
                    String data="yesterday";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.yesterday);
                    globalv.addmNames(yesterday2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    yesterplayer .start();
                    globalv.addMrecords(R.raw.yesterday);
                    globalv.addmImageUrls(R.drawable.yesterday);
                    globalv.addmNames(yesterday2);
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

                Intent intent1 = new Intent(TIME.this,Main2Activity.class);
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

        yesterday2.setText(resources.getString(R.string.yesterday));
        today2.setText(resources.getString(R.string.today));
        tomorrow2.setText(resources.getString(R.string.tomorrow));
        sunset2.setText(resources.getString(R.string.sunset));
        night2.setText(resources.getString(R.string.night));
        morning2.setText(resources.getString(R.string.morning));



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
