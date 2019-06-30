package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TRANSPORTATION extends AppCompatActivity {
    private static final String TAG = "TRANSPORTATION";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

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
                metroplayer.start();
                globalv.addmImageUrls(R.drawable.metro);
                globalv.addmNames("مترو");
                globalv.addMrecords(R.raw.metrooo);
                initRecyclerView();



            }
        });

        //CAR
        final MediaPlayer carplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.carrr);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carplayer.start();
                globalv.addmImageUrls(R.drawable.car);
                globalv.addmNames("عربية");
                globalv.addMrecords(R.raw.carrr);
                initRecyclerView();



            }
        });


        //TAXI
        final MediaPlayer taxiplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.taxiii);
        taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taxiplayer.start();
                globalv.addmImageUrls(R.drawable.taxi);
                globalv.addmNames("تاكسي");
                globalv.addMrecords(R.raw.taxiii);
                initRecyclerView();



            }
        });


        //AUTOBUS
        final MediaPlayer autobusplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.busss);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autobusplayer.start();
                globalv.addmImageUrls(R.drawable.bus);
                globalv.addmNames("أوتوبيس");
                globalv.addMrecords(R.raw.busss);
                initRecyclerView();



            }
        });


        //BIKE
        final MediaPlayer bikeplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.bicycleee);
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bikeplayer.start();
                globalv.addmImageUrls(R.drawable.bike);
                globalv.addmNames("عجلة");
                globalv.addMrecords(R.raw.bicycleee);
                initRecyclerView();



            }
        });


        //PLANE
        final MediaPlayer planeplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.planeee);
        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                planeplayer.start();
                globalv.addmImageUrls(R.drawable.plane);
                globalv.addmNames("طيارة");
                globalv.addMrecords(R.raw.planeee);
                initRecyclerView();



            }
        });

        //SHIP
        final MediaPlayer shipplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.shippp);
        ship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shipplayer.start();
                globalv.addmImageUrls(R.drawable.ship);
                globalv.addmNames("سفينة");
                globalv.addMrecords(R.raw.shippp);
                initRecyclerView();



            }
        });

        //TRAIN
        final MediaPlayer trainplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.trainnn);
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trainplayer.start();
                globalv.addmImageUrls(R.drawable.train);
                globalv.addmNames("قطار");
                globalv.addMrecords(R.raw.trainnn);
                initRecyclerView();



            }
        });

        //motor
        final MediaPlayer motorplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.motosekl);
        motor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motorplayer.start();
                globalv.addmImageUrls(R.drawable.motor);
                globalv.addmNames("موتوسيكل");
                globalv.addMrecords(R.raw.motosekl);
                initRecyclerView();



            }
        });

        //elevator
        final MediaPlayer elevatorplayer = MediaPlayer.create(TRANSPORTATION.this,R.raw.elevator);
        elevator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elevatorplayer.start();
                globalv.addmImageUrls(R.drawable.asanser);
                globalv.addmNames("مصعد");
                globalv.addMrecords(R.raw.elevator);
                initRecyclerView();



            }
        });


        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(TRANSPORTATION.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(TRANSPORTATION.this,MainActivity.class);
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
}
