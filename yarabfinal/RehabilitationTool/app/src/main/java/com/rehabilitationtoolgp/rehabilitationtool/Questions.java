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

public class Questions extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    TextView where2,when2,why2,who2,whichone2,howmoney2,time2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    private static final String TAG = "Questions";
    Globalrecycler globalv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
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
        time2 = (TextView)findViewById(R.id.time2);
        howmoney2 = (TextView)findViewById(R.id.howmoney2);
        whichone2 = (TextView)findViewById(R.id.whichone2);
        who2 = (TextView)findViewById(R.id.who2);
        when2 = (TextView)findViewById(R.id.when2);
        why2 = (TextView)findViewById(R.id.why2);
        where2 = (TextView)findViewById(R.id.where2);


        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        ImageView where = (ImageView) findViewById(R.id.where);
        final ImageView why= (ImageView) findViewById(R.id.why);
        final ImageView who =(ImageView) findViewById(R.id.who);
        ImageView whichone=(ImageView) findViewById(R.id.whichone);
        final ImageView when= (ImageView) findViewById(R.id.when);
        ImageView time =(ImageView) findViewById(R.id.timeee);
        ImageView howmoney=(ImageView) findViewById(R.id.howmoney);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



        final MediaPlayer whereplayer= MediaPlayer.create(Questions.this,R.raw.where);
        where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(where2.getText().toString().equalsIgnoreCase("Where?")){
                    String data="where";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.where);
                    globalv.addmNames(where2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    whereplayer .start();
                    globalv.addMrecords(R.raw.where);
                    globalv.addmImageUrls(R.drawable.where);
                    globalv.addmNames(where2);
                }
                initRecyclerView();



            }
        });

        final MediaPlayer whyplayer = MediaPlayer.create(Questions.this,R.raw.why);
        why.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(why2.getText().toString().equalsIgnoreCase("Why?")){
                    String data="why";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.lmazaa);
                    globalv.addmNames(why2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    whyplayer .start();
                    globalv.addMrecords(R.raw.why);
                    globalv.addmImageUrls(R.drawable.lmazaa);
                    globalv.addmNames(why2);
                }
                initRecyclerView();



            }
        });



        final MediaPlayer whoplayer= MediaPlayer.create(Questions.this,R.raw.who);
        who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(who2.getText().toString().equalsIgnoreCase("Who?")){
                    String data="who";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.who);
                    globalv.addmNames(who2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    whoplayer .start();
                    globalv.addMrecords(R.raw.who);
                    globalv.addmImageUrls(R.drawable.who);
                    globalv.addmNames(who2);
                }
                initRecyclerView();



            }
        });

        final MediaPlayer whichplayer = MediaPlayer.create(Questions.this,R.raw.whichone);
        whichone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(whichone2.getText().toString().equalsIgnoreCase("Which one?")){
                    String data="which one";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.whichone);
                    globalv.addmNames(whichone2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    whichplayer .start();
                    globalv.addMrecords(R.raw.whichone);
                    globalv.addmImageUrls(R.drawable.whichone);
                    globalv.addmNames(whichone2);
                }
                initRecyclerView();



            }
        });


        final MediaPlayer whenplayer= MediaPlayer.create(Questions.this,R.raw.when);
        when.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(when2.getText().toString().equalsIgnoreCase("When?")){
                    String data="when";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.date);
                    globalv.addmNames(when2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    whenplayer.start();
                    globalv.addMrecords(R.raw.when);
                    globalv.addmImageUrls(R.drawable.date);
                    globalv.addmNames(when2);
                }
                initRecyclerView();



            }
        });

        final MediaPlayer timeplayer = MediaPlayer.create(Questions.this,R.raw.timekam);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(time2.getText().toString().equalsIgnoreCase("What is the time?")){
                    String data="what is the time";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.time);
                    globalv.addmNames(time2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    timeplayer .start();
                    globalv.addMrecords(R.raw.timekam);
                    globalv.addmImageUrls(R.drawable.time);
                    globalv.addmNames(time2);
                }
                initRecyclerView();



            }
        });

        //EGG
        final MediaPlayer monplayer = MediaPlayer.create(Questions.this,R.raw.howmuch);
        howmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(howmoney2.getText().toString().equalsIgnoreCase("How much?")){
                    String data="how much";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.money);
                    globalv.addmNames(howmoney2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    monplayer .start();
                    globalv.addMrecords(R.raw.howmuch);
                    globalv.addmImageUrls(R.drawable.money);
                    globalv.addmNames(howmoney2);
                }
                initRecyclerView();



            }
        });
//playALL
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

                Intent intent1 = new Intent(Questions.this,Main2Activity.class);
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

        time2.setText(resources.getString(R.string.Timee));
        howmoney2.setText(resources.getString(R.string.howmoney));
        whichone2.setText(resources.getString(R.string.whichone));
        who2.setText(resources.getString(R.string.who));
        why2.setText(resources.getString(R.string.why));
        when2.setText(resources.getString(R.string.when));
        where2.setText(resources.getString(R.string.where));



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
