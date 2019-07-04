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


public class Main2Activity extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    TextView iwant,inotwant,yes2,no2,eat2,drink2,wear2,go2,family2,actions2,trans2,relations2,tools2,time2,feelings2,question2,animals2,createee,mycar;



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }




    private static final String TAG = "Main2Activity";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_main2);
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



        iwant = (TextView)findViewById(R.id.iwantt);
        inotwant = (TextView)findViewById(R.id.notwanttt);
        yes2 = (TextView)findViewById(R.id.yess);
        no2 = (TextView)findViewById(R.id.noo);
        eat2 = (TextView)findViewById(R.id.eattt);
        drink2 = (TextView)findViewById(R.id.drinkk);
        wear2 = (TextView)findViewById(R.id.wearr);
        go2 = (TextView)findViewById(R.id.gooo);
        family2 = (TextView)findViewById(R.id.familyy);
        actions2 = (TextView)findViewById(R.id.actionss);
        trans2 = (TextView)findViewById(R.id.transportationn);
        relations2 = (TextView)findViewById(R.id.relationss);
        tools2 = (TextView)findViewById(R.id.tools);
        time2 = (TextView)findViewById(R.id.time);
        feelings2 = (TextView)findViewById(R.id.feeling);
        question2 = (TextView)findViewById(R.id.question);
        animals2  = (TextView)findViewById(R.id.animals2);
        createee  = (TextView)findViewById(R.id.createe);
        mycar     = (TextView) findViewById(R.id.mycar);
        Button back = (Button) findViewById(R.id.back);



        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        final ImageView want = (ImageView) findViewById(R.id.want);
        ImageView notwant= (ImageView) findViewById(R.id.notWant);
        ImageView eat = (ImageView) findViewById(R.id.eat);
        ImageView drink = (ImageView) findViewById(R.id.drink);
        ImageView wear = (ImageView) findViewById(R.id.wear);
        ImageView go = (ImageView) findViewById(R.id.go);
        ImageView yes= (ImageView) findViewById(R.id.yes);
        final ImageView no = (ImageView) findViewById(R.id.no);
        ImageView family = (ImageView) findViewById(R.id.family);
        ImageView actions= (ImageView) findViewById(R.id.actions);
        ImageView trans= (ImageView) findViewById(R.id.trans);
        ImageView relations = (ImageView) findViewById(R.id.relations);
        ImageView time= (ImageView) findViewById(R.id.timee);
        ImageView tools =(ImageView) findViewById(R.id.tools2);
        ImageView createcard =(ImageView) findViewById(R.id.createcardd);
        ImageView mycard = (ImageView) findViewById(R.id.display);
        ImageView animals= (ImageView) findViewById(R.id.animals);
        ImageView feelings =(ImageView) findViewById(R.id.feelings);
        ImageView questions =(ImageView) findViewById(R.id.questions);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        // Button next = (Button) findViewById(R.id.next);
        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



        //I WANT
        final MediaPlayer iwantplayer =MediaPlayer.create(Main2Activity.this, R.raw.ineeddd);
        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iwant.getText().toString().equalsIgnoreCase("I want")){
                    // iwantplayer.stop();
                    String data="i want";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.need);
                    globalv.addmNames(iwant);



                }
                else{
                    iwantplayer.start();
                    globalv.addmImageUrls(R.drawable.need);
                    globalv.addmNames(iwant);
                    globalv.addMrecords(R.raw.ineeddd);

                }
                initRecyclerView();

            }
        });

        // I DONONT WANT
        final MediaPlayer inotwantplayer =MediaPlayer.create(Main2Activity.this, R.raw.inotneeddd);
        notwant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inotwant.getText().toString().equalsIgnoreCase("I donot want")){
                    String data="i don't want";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.donotwant);
                    globalv.addmNames(inotwant);



                }
                else{
                    iwantplayer.start();
                    inotwantplayer .start();
                    globalv.addmImageUrls(R.drawable.donotwant);
                    globalv.addmNames(inotwant);
                    globalv.addMrecords(R.raw.inotneeddd);
                }
                initRecyclerView();


            }
        });


        //YES
        final MediaPlayer yesplayer =MediaPlayer.create(Main2Activity.this, R.raw.yesss);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(yes2.getText().toString().equalsIgnoreCase("Yes")){
                    String data="yes";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.yes);
                    globalv.addmNames(yes2);;

                }
                else{
                    yesplayer .start();
                    globalv.addMrecords(R.raw.yesss);
                    globalv.addmImageUrls(R.drawable.yes);
                    globalv.addmNames(yes2);
                }
                initRecyclerView();

            }
        });

        //NO

        final MediaPlayer noplayer =MediaPlayer.create(Main2Activity.this, R.raw.nooo);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(no2.getText().toString().equalsIgnoreCase("No")){
                    String data="no";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.no);
                    globalv.addmNames(no2);;

                }
                else{
                    noplayer .start();
                    globalv.addMrecords(R.raw.nooo);
                    globalv.addmImageUrls(R.drawable.no);
                    globalv.addmNames(no2);
                }
                initRecyclerView();

            }
        });

        //EAT

        final MediaPlayer eatplayer =MediaPlayer.create(Main2Activity.this, R.raw.eattt);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eat2.getText().toString().equalsIgnoreCase("Eat")){
                   String data="eat";
                   int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                    globalv.addmImageUrls(R.drawable.eat);
                    globalv.addmNames(eat2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    eatplayer .start();
                    globalv.addMrecords(R.raw.eattt);
                    globalv.addmImageUrls(R.drawable.eat);
                    globalv.addmNames(eat2);
                }
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(Main2Activity.this,FOODS.class);
                startActivity(intent1);

            }
        });

        //DRINK

        final MediaPlayer drinkplayer =MediaPlayer.create(Main2Activity.this, R.raw.drinkkk);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drink2.getText().toString().equalsIgnoreCase("Drink")){
                    String data="drink";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.drink);
                    globalv.addmNames(drink2);;

                }
                else{
                    drinkplayer .start();
                    globalv.addMrecords(R.raw.drinkkk);
                    globalv.addmImageUrls(R.drawable.drink);
                    globalv.addmNames(drink2);
                }
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent2 = new Intent(Main2Activity.this,DRINKS.class);
                startActivity(intent2);

            }
        });

        //WEAR

        final MediaPlayer wearplayer =MediaPlayer.create(Main2Activity.this, R.raw.wearrr);
        wear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(wear2.getText().toString().equalsIgnoreCase("Wear")){
                    String data="wear";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.wear);
                    globalv.addmNames(wear2);;

                }
                else{
                    wearplayer .start();
                    globalv.addMrecords(R.raw.wearrr);
                    globalv.addmImageUrls(R.drawable.wear);
                    globalv.addmNames(wear2);
                }
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent3 = new Intent(Main2Activity.this,CLOTHES.class);
                startActivity(intent3);

            }
        });

        //GO
        final MediaPlayer goplayer =MediaPlayer.create(Main2Activity.this, R.raw.gooo);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(go2.getText().toString().equalsIgnoreCase("Go")){
                    String data="go";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.walk);
                    globalv.addmNames(go2);;

                }
                else{
                    goplayer .start();
                    globalv.addMrecords(R.raw.gooo);
                    globalv.addmImageUrls(R.drawable.walk);
                    globalv.addmNames(go2);
                }
                initRecyclerView();

                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent4 = new Intent(Main2Activity.this,PLACES.class);
                startActivity(intent4);

            }
        });
        //FAMILY
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent5 = new Intent(Main2Activity.this,FAMILY.class);
                startActivity(intent5);

            }
        });

        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent100 = new Intent(Main2Activity.this,Questions.class);
                startActivity(intent100);

            }
        });
        feelings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent101 = new Intent(Main2Activity.this,Feelings.class);
                startActivity(intent101);

            }
        });
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent99 = new Intent(Main2Activity.this,Animals.class);
                startActivity(intent99);

            }
        });

        //ACTIONS
        actions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CleanUpMemory();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent6 = new Intent(Main2Activity.this,ACTIONS.class);
                startActivity(intent6);

            }
        });

        //TRANSPORTATION

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent7 = new Intent(Main2Activity.this,TRANSPORTATION.class);
                startActivity(intent7);

            }
        });

        //DIRECTIONS
        relations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CleanUpMemory();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent8 = new Intent(Main2Activity.this,DIRECTIONS.class);
                startActivity(intent8);

            }
        });

        //TIME
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent9 = new Intent(Main2Activity.this,TIME.class);
                startActivity(intent9);

            }
        });
        //TOOLS
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent10 = new Intent(Main2Activity.this,TOOLS.class);
                startActivity(intent10);

            }
        });

        //CREATE CARD
        createcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent11 = new Intent(Main2Activity.this,CREATCARD.class);
                startActivity(intent11);

            }
        });

        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(Main2Activity.this, globalv.getMrecords().get(i));
                    mediaPlay.start();*/

                    if (globalv.getMrecords().get(i) instanceof Integer) {
                        // The Object is an instance of a String
                        Integer M = (Integer) globalv.getMrecords().get(i);

                       final MediaPlayer mediaPlayer=MediaPlayer.create(view.getContext(),M);
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

        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent(Main2Activity.this,CardList.class);
                startActivity(intent1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent1);
            }
        });







        //next.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //public void onClick(View view) {
        //  globalv.getmImageUrls();
        //globalv.getmNames();
        //globalv.getMrecords();

        // Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
        //startActivity(intent1);
        //}
        //});


    }

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        iwant.setText(resources.getString(R.string.iwant));
        inotwant.setText(resources.getString(R.string.idonotwant));
        yes2.setText(resources.getString(R.string.yes));
        no2.setText(resources.getString(R.string.no));
        eat2.setText(resources.getString(R.string.eat));
        drink2.setText(resources.getString(R.string.drink));
        wear2.setText(resources.getString(R.string.wear));
        go2.setText(resources.getString(R.string.go));
        feelings2.setText(resources.getString(R.string.feelings));
        actions2.setText(resources.getString(R.string.actions));
        trans2.setText(resources.getString(R.string.transportations));
        family2.setText(resources.getString(R.string.family));
        tools2.setText(resources.getString(R.string.tools));
        time2.setText(resources.getString(R.string.time));
        animals2.setText(resources.getString(R.string.animals));
        question2.setText(resources.getString(R.string.questions));
        createee.setText(resources.getString(R.string.createcard));
        //mycar.setText(resources.getString(R.string.mycard));
        relations2.setText(resources.getString(R.string.directions));




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

    @Override
    protected void onStop() {
        super.onStop();
        CleanUpMemory();
    }

    @Override
    protected void onPause() {
        super.onPause();
        CleanUpMemory();

    }

    public void buttonClicked(View view) {
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


















