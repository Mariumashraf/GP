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

public class TRANSPORTATION extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    TextView car2,taxi2,autobus2,metro2,train2,bike2,elevator2,motor2,plane2,ship2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    private static final String TAG = "TRANSPORTATION";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
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

        car2 = (TextView)findViewById(R.id.car2);
        taxi2 = (TextView)findViewById(R.id.taxi2);
        autobus2 = (TextView)findViewById(R.id.autobus2);
        metro2 = (TextView)findViewById(R.id.metro2);
        train2 = (TextView)findViewById(R.id.train2);
        bike2 = (TextView)findViewById(R.id.bike2);
        elevator2 = (TextView)findViewById(R.id.elevator2);
        motor2 = (TextView)findViewById(R.id.motor2);
        plane2 = (TextView)findViewById(R.id.plane2);
        ship2 = (TextView)findViewById(R.id.ship2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));

        ImageView metro = (ImageView) findViewById(R.id.Metro);
        ImageView car = (ImageView) findViewById(R.id.Car);
        ImageView taxi = (ImageView) findViewById(R.id.Taxi);
        ImageView bus = (ImageView) findViewById(R.id.bus);
        ImageView bike = (ImageView) findViewById(R.id.bike);
        ImageView plane = (ImageView) findViewById(R.id.Plane);
        ImageView ship = (ImageView) findViewById(R.id.Ship);
        ImageView train = (ImageView) findViewById(R.id.Train);
        ImageView motor = (ImageView) findViewById(R.id.motor);
        ImageView elevator = (ImageView) findViewById(R.id.elevator);

        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();



        //METRO
        final MediaPlayer metroplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.metrooo);
        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(metro2.getText().toString().equalsIgnoreCase("Metro")){
                    String data="metro";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.metro);
                    globalv.addmNames(metro2);;

                }
                else{
                    metroplayer .start();
                    globalv.addMrecords(R.raw.metrooo);
                    globalv.addmImageUrls(R.drawable.metro);
                    globalv.addmNames(metro2);
                }
                initRecyclerView();



            }
        });

        //CAR
        final MediaPlayer carplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.carrr);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(car2.getText().toString().equalsIgnoreCase("Car")){
                    String data="car";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.car);
                    globalv.addmNames(car2);;

                }
                else{
                    carplayer .start();
                    globalv.addMrecords(R.raw.carrr);
                    globalv.addmImageUrls(R.drawable.car);
                    globalv.addmNames(car2);
                }
                initRecyclerView();



            }
        });


        //TAXI
        final MediaPlayer taxiplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.taxiii);
        taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(taxi2.getText().toString().equalsIgnoreCase("Taxi")){
                    String data="taxi";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.taxi);
                    globalv.addmNames(taxi2);;

                }
                else{
                    taxiplayer .start();
                    globalv.addMrecords(R.raw.taxiii);
                    globalv.addmImageUrls(R.drawable.taxi);
                    globalv.addmNames(taxi2);
                }
                initRecyclerView();



            }
        });


        //AUTOBUS
        final MediaPlayer autobusplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.busss);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(autobus2.getText().toString().equalsIgnoreCase("Bus")){
                    String data="bus";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.bus);
                    globalv.addmNames(autobus2);;

                }
                else{
                    autobusplayer .start();
                    globalv.addMrecords(R.raw.busss);
                    globalv.addmImageUrls(R.drawable.bus);
                    globalv.addmNames(autobusplayer);
                }
                initRecyclerView();



            }
        });


        //BIKE
        final MediaPlayer bikeplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.bicycleee);
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bike2.getText().toString().equalsIgnoreCase("Bike")){
                    String data="bike";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.bike);
                    globalv.addmNames(bike2);;

                }
                else{
                    bikeplayer .start();
                    globalv.addMrecords(R.raw.bicycleee);
                    globalv.addmImageUrls(R.drawable.bike);
                    globalv.addmNames(bike2);
                }
                initRecyclerView();



            }
        });


        //PLANE
        final MediaPlayer planeplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.planeee);
        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(plane2.getText().toString().equalsIgnoreCase("Plane")){
                    String data="plane";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.plane);
                    globalv.addmNames(plane2);;

                }
                else{
                    planeplayer .start();
                    globalv.addMrecords(R.raw.planeee);
                    globalv.addmImageUrls(R.drawable.plane);
                    globalv.addmNames(plane2);
                }
                initRecyclerView();



            }
        });

        //SHIP
        final MediaPlayer shipplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.shippp);
        ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ship2.getText().toString().equalsIgnoreCase("Ship")){
                    String data="ship";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.ship);
                    globalv.addmNames(ship2);;

                }
                else{
                    shipplayer .start();
                    globalv.addMrecords(R.raw.shippp);
                    globalv.addmImageUrls(R.drawable.ship);
                    globalv.addmNames(ship2);
                }
                initRecyclerView();



            }
        });

        //TRAIN
        final MediaPlayer trainplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.trainnn);
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(train2.getText().toString().equalsIgnoreCase("Train")){
                    String data="train";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.train);
                    globalv.addmNames(train2);;

                }
                else{
                    trainplayer .start();
                    globalv.addMrecords(R.raw.trainnn);
                    globalv.addmImageUrls(R.drawable.train);
                    globalv.addmNames(train2);
                }
                initRecyclerView();



            }
        });

        //motor
        final MediaPlayer motorplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.motosekl);
        motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(motor2.getText().toString().equalsIgnoreCase("Motorcycle")){
                    String data="motorcycle";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.motor);
                    globalv.addmNames(motor2);;

                }
                else{
                    motorplayer .start();
                    globalv.addMrecords(R.raw.motosekl);
                    globalv.addmImageUrls(R.drawable.motor);
                    globalv.addmNames(motor2);
                }
                initRecyclerView();



            }
        });

        //elevator
        final MediaPlayer elevatorplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.elevator);
        elevator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(elevator2.getText().toString().equalsIgnoreCase("Elevator")){
                    String data="elevator";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.asanser);
                    globalv.addmNames(elevator2);;

                }
                else{
                    elevatorplayer .start();
                    globalv.addMrecords(R.raw.elevator);
                    globalv.addmImageUrls(R.drawable.asanser);
                    globalv.addmNames(elevator2);
                }
                initRecyclerView();



            }
        });


        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                   /* final MediaPlayer mediaPlay = MediaPlayer.create(TRANSPORTATION.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(TRANSPORTATION.this,Main2Activity.class);
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
        bike2.setText(resources.getString(R.string.bike));
        ship2.setText(resources.getString(R.string.ship));
        plane2.setText(resources.getString(R.string.plane));
        motor2.setText(resources.getString(R.string.motor));
        elevator2.setText(resources.getString(R.string.elevator));
        train2.setText(resources.getString(R.string.train));
        metro2.setText(resources.getString(R.string.metro));
        autobus2.setText(resources.getString(R.string.bus));
        taxi2.setText(resources.getString(R.string.taxi));
        car2.setText(resources.getString(R.string.car));




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
