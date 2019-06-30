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

public class PLACES extends AppCompatActivity {
    private static final String TAG = "PLACES";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        ImageView bedroom = (ImageView) findViewById(R.id.bedroom);
        ImageView bathroom = (ImageView) findViewById(R.id.bathroom);
        ImageView livingroom= (ImageView) findViewById(R.id.livingroom);
        ImageView school = (ImageView) findViewById(R.id.school);
        ImageView university = (ImageView) findViewById(R.id.university);
        ImageView supermarket = (ImageView) findViewById(R.id.supermarket);
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
                kitchenplayer.start();
                globalv.addmImageUrls(R.drawable.kitchen);
                globalv.addmNames("المطبخ");
                globalv.addMrecords(R.raw.kitchennn);
                initRecyclerView();



            }
        });

        //COMPANY
        final MediaPlayer companyplayer = MediaPlayer.create(PLACES.this,R.raw.work);
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companyplayer.start();
                globalv.addmImageUrls(R.drawable.work);
                globalv.addmNames("الشركة");
                globalv.addMrecords(R.raw.work);
                initRecyclerView();



            }
        });

        //BEDROOM
        final MediaPlayer bedplayer = MediaPlayer.create(PLACES.this,R.raw.bedroommm);
        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bedplayer.start();
                globalv.addmImageUrls(R.drawable.bedroom);
                globalv.addmNames("اوضة النوم");
                globalv.addMrecords(R.raw.bedroommm);
                initRecyclerView();



            }
        });

        //BATHROOM
        final MediaPlayer pathplayer = MediaPlayer.create(PLACES.this,R.raw.bathroommm);
        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathplayer.start();
                globalv.addmImageUrls(R.drawable.toilet);
                globalv.addmNames("الحمام");
                globalv.addMrecords(R.raw.bathroommm);
                initRecyclerView();



            }
        });


        //LIVINGROOM
        final MediaPlayer livingplayer = MediaPlayer.create(PLACES.this,R.raw.salonnn);
        livingroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                livingplayer.start();
                globalv.addmImageUrls(R.drawable.livingroom);
                globalv.addmNames("الصالة");
                globalv.addMrecords(R.raw.salonnn);
                initRecyclerView();



            }
        });


        //SCHOOL
        final MediaPlayer schoolplayer = MediaPlayer.create(PLACES.this,R.raw.schoolll);
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schoolplayer.start();
                globalv.addmImageUrls(R.drawable.school);
                globalv.addmNames("المدرسة");
                globalv.addMrecords(R.raw.schoolll);
                initRecyclerView();



            }
        });

        //SUPERMARKET
        final MediaPlayer superplayer = MediaPlayer.create(PLACES.this,R.raw.supermarkettt);
        supermarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                superplayer.start();
                globalv.addmImageUrls(R.drawable.supermarket);
                globalv.addmNames("السوبرماركت");
                globalv.addMrecords(R.raw.supermarkettt);
                initRecyclerView();



            }
        });

        //UNIVERSITY
        final MediaPlayer universityplayer = MediaPlayer.create(PLACES.this,R.raw.universityyy);
        university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                universityplayer.start();
                globalv.addmImageUrls(R.drawable.university);
                globalv.addmNames("الجامعة");
                globalv.addMrecords(R.raw.universityyy);
                initRecyclerView();



            }
        });


        final MediaPlayer homeplayer = MediaPlayer.create(PLACES.this,R.raw.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeplayer.start();
                globalv.addmImageUrls(R.drawable.home);
                globalv.addmNames("البيت");
                globalv.addMrecords(R.raw.home);
                initRecyclerView();



            }
        });



        final MediaPlayer hoslplayer = MediaPlayer.create(PLACES.this,R.raw.hosbital);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoslplayer.start();
                globalv.addmImageUrls(R.drawable.hospital);
                globalv.addmNames("المستشفى");
                globalv.addMrecords(R.raw.hosbital);
                initRecyclerView();



            }
        });

        final MediaPlayer busplayer = MediaPlayer.create(PLACES.this,R.raw.busstation);
        busstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busplayer.start();
                globalv.addmImageUrls(R.drawable.busstation);
                globalv.addmNames("محطة القطار");
                globalv.addMrecords(R.raw.busstation);




            }
        });


        final MediaPlayer parkyplayer = MediaPlayer.create(PLACES.this,R.raw.garden);
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkyplayer.start();
                globalv.addmImageUrls(R.drawable.park);
                globalv.addmNames("الحديقة");
                globalv.addMrecords(R.raw.garden);
                initRecyclerView();



            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(PLACES.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(PLACES.this,MainActivity.class);
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

