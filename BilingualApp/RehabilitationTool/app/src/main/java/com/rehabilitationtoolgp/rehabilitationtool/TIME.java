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

public class TIME extends AppCompatActivity {
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
                morningplayer.start();
                globalv.addmImageUrls(R.drawable.morning);
                globalv.addmNames(morning2);
                globalv.addMrecords(R.raw.morninggg);
                initRecyclerView();



            }
        });

        //NIGHT
        final MediaPlayer nightplayer = MediaPlayer.create(TIME.this,R.raw.nighttt);
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nightplayer.start();
                globalv.addmImageUrls(R.drawable.night);
                globalv.addmNames(night2);
                globalv.addMrecords(R.raw.nighttt);
                initRecyclerView();



            }
        });

        //MORNING

        final MediaPlayer sunplayer= MediaPlayer.create(TIME.this,R.raw.sunset);
        sunset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sunplayer.start();
                globalv.addmImageUrls(R.drawable.sunset);
                globalv.addmNames(sunset2);
                globalv.addMrecords(R.raw.sunset);
                initRecyclerView();



            }
        });

        final MediaPlayer todayplayer = MediaPlayer.create(TIME.this,R.raw.today);
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todayplayer.start();
                globalv.addmImageUrls(R.drawable.today);
                globalv.addmNames(today2);
                globalv.addMrecords(R.raw.today);
                initRecyclerView();



            }
        });


        final MediaPlayer tomorroplayer= MediaPlayer.create(TIME.this,R.raw.tomorrw);
        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomorroplayer.start();
                globalv.addmImageUrls(R.drawable.tomorrow);
                globalv.addmNames(tomorrow2);
                globalv.addMrecords(R.raw.tomorrw);
                initRecyclerView();



            }
        });

        final MediaPlayer yesterplayer = MediaPlayer.create(TIME.this,R.raw.yesterday);
        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesterplayer.start();
                globalv.addmImageUrls(R.drawable.yesterday);
                globalv.addmNames(yesterday2);
                globalv.addMrecords(R.raw.yesterday);
                initRecyclerView();



            }
        });



        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(TIME.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(TIME.this,MainActivity.class);
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
        }
        else  if(item.getItemId() == R.id.language_ar){
            Paper.book().write("language","ar");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }
}
