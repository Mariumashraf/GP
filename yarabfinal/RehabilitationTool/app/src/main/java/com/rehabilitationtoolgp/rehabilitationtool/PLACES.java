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

public class PLACES extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private static final String TAG = "PLACES";
    Globalrecycler globalv;

    TextView livingroom2,bathroom2,kitchen2,university2,school2,supermarket2,home2,companyy2,hospital2,busStation2,park2,bedroom2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
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

        livingroom2 = (TextView)findViewById(R.id.livingroom2);
        bathroom2 = (TextView)findViewById(R.id.bathroom2);
        kitchen2 = (TextView)findViewById(R.id.kitchen2);
        university2 = (TextView)findViewById(R.id.university2);
        school2 = (TextView)findViewById(R.id.school2);
        supermarket2 = (TextView)findViewById(R.id.supermarket2);
        home2 = (TextView)findViewById(R.id.home2);
        companyy2 = (TextView)findViewById(R.id.companyy2);
        hospital2 = (TextView)findViewById(R.id.hospital2);
        busStation2 = (TextView)findViewById(R.id.busStation2);
        park2 = (TextView)findViewById(R.id.park2);
        bedroom2 = (TextView)findViewById(R.id.bedroom2);


        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));

        ImageView bedroom = (ImageView) findViewById(R.id.bedroom);
        ImageView bathroom = (ImageView) findViewById(R.id.bathroom);
        ImageView livingroom= (ImageView) findViewById(R.id.livingroom);
        ImageView school = (ImageView) findViewById(R.id.school);
        ImageView university = (ImageView) findViewById(R.id.university);
        final ImageView supermarket = (ImageView) findViewById(R.id.supermarket);
        ImageView kitchen = (ImageView) findViewById(R.id.kitchen);
        ImageView company = (ImageView) findViewById(R.id.company);
        ImageView home = (ImageView) findViewById(R.id.home);
        ImageView hospital = (ImageView) findViewById(R.id.hospital);
        ImageView busstation = (ImageView) findViewById(R.id.busStation);
        ImageView park = (ImageView) findViewById(R.id.park);
        Button back = (Button) findViewById(R.id.back);
        ImageButton play = (ImageButton) findViewById(R.id.playall);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();


        //KITCHEN
        final MediaPlayer kitchenplayer = MediaPlayer.create(PLACES.this,R.raw.kitchennn);
        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kitchen2.getText().toString().equalsIgnoreCase("Kitchen")){
                    String data="kitchen";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.kitchen);
                    globalv.addmNames(kitchen2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    kitchenplayer .start();
                    globalv.addMrecords(R.raw.kitchennn);
                    globalv.addmImageUrls(R.drawable.kitchen);
                    globalv.addmNames(kitchen2);
                }
                initRecyclerView();



            }
        });

        //COMPANY
        final MediaPlayer companyplayer = MediaPlayer.create(PLACES.this,R.raw.work);
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(companyy2.getText().toString().equalsIgnoreCase("Company")){
                    String data="company";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.work);
                    globalv.addmNames(companyy2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    companyplayer .start();
                    globalv.addMrecords(R.raw.work);
                    globalv.addmImageUrls(R.drawable.work);
                    globalv.addmNames(companyy2);
                }
                initRecyclerView();



            }
        });

        //BEDROOM
        final MediaPlayer bedplayer = MediaPlayer.create(PLACES.this,R.raw.bedroommm);
        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bedroom2.getText().toString().equalsIgnoreCase("Bedroom")){
                    String data="bedroom";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.bedroom);
                    globalv.addmNames(bedroom2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    bedplayer .start();
                    globalv.addMrecords(R.raw.bedroommm);
                    globalv.addmImageUrls(R.drawable.bedroom);
                    globalv.addmNames(bedroom2);
                }
                initRecyclerView();



            }
        });

        //BATHROOM
        final MediaPlayer pathplayer = MediaPlayer.create(PLACES.this,R.raw.bathroommm);
        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bathroom2.getText().toString().equalsIgnoreCase("Bathroom")){
                    String data="bathroom";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.toilet);
                    globalv.addmNames(bathroom2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    pathplayer .start();
                    globalv.addMrecords(R.raw.bathroommm);
                    globalv.addmImageUrls(R.drawable.toilet);
                    globalv.addmNames(bathroom2);
                }
                initRecyclerView();



            }
        });


        //LIVINGROOM
        final MediaPlayer livingplayer = MediaPlayer.create(PLACES.this,R.raw.salonnn);
        livingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livingroom2.getText().toString().equalsIgnoreCase("Livingroom")){
                    String data="livingroom";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.livingroom);
                    globalv.addmNames(livingroom2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    livingplayer .start();
                    globalv.addMrecords(R.raw.salonnn);
                    globalv.addmImageUrls(R.drawable.livingroom);
                    globalv.addmNames(livingroom2);
                }
                initRecyclerView();



            }
        });


        //SCHOOL
        final MediaPlayer schoolplayer = MediaPlayer.create(PLACES.this,R.raw.schoolll);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(school2.getText().toString().equalsIgnoreCase("School")){
                    String data="school";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.school);
                    globalv.addmNames(school2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    schoolplayer .start();
                    globalv.addMrecords(R.raw.schoolll);
                    globalv.addmImageUrls(R.drawable.school);
                    globalv.addmNames(school2);
                }
                initRecyclerView();



            }
        });

        //SUPERMARKET
        final MediaPlayer superplayer = MediaPlayer.create(PLACES.this,R.raw.supermarkettt);
        supermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(supermarket2.getText().toString().equalsIgnoreCase("Supermarket")){
                    String data="supermarket";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.supermarket);
                    globalv.addmNames(supermarket2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    superplayer .start();
                    globalv.addMrecords(R.raw.supermarkettt);
                    globalv.addmImageUrls(R.drawable.supermarket);
                    globalv.addmNames(supermarket2);
                }
                initRecyclerView();



            }
        });

        //UNIVERSITY
        final MediaPlayer universityplayer = MediaPlayer.create(PLACES.this,R.raw.universityyy);
        university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(university2.getText().toString().equalsIgnoreCase("University")){
                    String data="university";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.university);
                    globalv.addmNames(university2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    universityplayer .start();
                    globalv.addMrecords(R.raw.universityyy);
                    globalv.addmImageUrls(R.drawable.university);
                    globalv.addmNames(university2);
                }
                initRecyclerView();



            }
        });


        final MediaPlayer homeplayer = MediaPlayer.create(PLACES.this,R.raw.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(home2.getText().toString().equalsIgnoreCase("Home")){
                    String data="home";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.home);
                    globalv.addmNames(home2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    homeplayer .start();
                    globalv.addMrecords(R.raw.home);
                    globalv.addmImageUrls(R.drawable.home);
                    globalv.addmNames(home2);
                }
                initRecyclerView();



            }
        });



        final MediaPlayer hoslplayer = MediaPlayer.create(PLACES.this,R.raw.hosbital);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hospital2.getText().toString().equalsIgnoreCase("Hospital")){
                    String data="hospital";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.hospital);
                    globalv.addmNames(hospital2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    hoslplayer .start();
                    globalv.addMrecords(R.raw.hosbital);
                    globalv.addmImageUrls(R.drawable.hospital);
                    globalv.addmNames(hospital2);
                }
                initRecyclerView();



            }
        });

        final MediaPlayer busplayer = MediaPlayer.create(PLACES.this,R.raw.busstation);
        busstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(busStation2.getText().toString().equalsIgnoreCase("Bus Station")){
                    String data="bus station";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.busstation);
                    globalv.addmNames(busStation2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    busplayer .start();
                    globalv.addMrecords(R.raw.busstation);
                    globalv.addmImageUrls(R.drawable.busstation);
                    globalv.addmNames(busStation2);
                }
                initRecyclerView();




            }
        });


        final MediaPlayer parkyplayer = MediaPlayer.create(PLACES.this,R.raw.garden);
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(park2.getText().toString().equalsIgnoreCase("Park")){
                    String data="park";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.park);
                    globalv.addmNames(park2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    parkyplayer .start();
                    globalv.addMrecords(R.raw.garden);
                    globalv.addmImageUrls(R.drawable.park);
                    globalv.addmNames(park2);
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

                Intent intent1 = new Intent(PLACES.this,Main2Activity.class);
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
        livingroom2.setText(resources.getString(R.string.livingroom));
        bathroom2.setText(resources.getString(R.string.bathroom));
        bedroom2.setText(resources.getString(R.string.bedroom));
        kitchen2.setText(resources.getString(R.string.kitchen));
        university2.setText(resources.getString(R.string.university));
        school2.setText(resources.getString(R.string.school));
        companyy2.setText(resources.getString(R.string.company));
        home2.setText(resources.getString(R.string.home));
        hospital2.setText(resources.getString(R.string.hospital));
        park2.setText(resources.getString(R.string.park));
        busStation2.setText(resources.getString(R.string.busstation));
        supermarket2.setText(resources.getString(R.string.supermarket));





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

