package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
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

import com.rehabilitationtoolgp.rehabilitationtool.Helper.LocalHelper;

import io.paperdb.Paper;

public class PLACES extends AppCompatActivity {
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
                globalv.addmNames(kitchen2);
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
                globalv.addmNames(companyy2);
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
                globalv.addmNames(bedroom2);
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
                globalv.addmNames(bathroom2);
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
                globalv.addmNames(livingroom2);
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
                globalv.addmNames(school2);
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
                globalv.addmNames(supermarket2);
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
                globalv.addmNames(university2);
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
                globalv.addmNames(home2);
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
                globalv.addmNames(hospital2);
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
                globalv.addmNames(busStation2);
                globalv.addMrecords(R.raw.busstation);




            }
        });


        final MediaPlayer parkyplayer = MediaPlayer.create(PLACES.this,R.raw.garden);
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parkyplayer.start();
                globalv.addmImageUrls(R.drawable.park);
                globalv.addmNames(park2);
                globalv.addMrecords(R.raw.garden);
                initRecyclerView();



            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(PLACES.this, globalv.getMrecords().get(i));
                    mediaPlay.start();
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
        }
        else  if(item.getItemId() == R.id.language_ar){
            Paper.book().write("language","ar");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }
    }

