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

public class ACTIONS extends AppCompatActivity {

    TextView smile2,write2,speak2,run2,think2,wash2,sleep2,watch2,close2,open2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    private static final String TAG = "ACTIONS";
    Globalrecycler globalv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_actions);

        smile2 = (TextView)findViewById(R.id.smile2);
        write2 = (TextView)findViewById(R.id.write2);
        speak2 = (TextView)findViewById(R.id.speak2);
        run2 = (TextView)findViewById(R.id.run2);
        think2 = (TextView)findViewById(R.id.think2);
        wash2 = (TextView)findViewById(R.id.wash2);
        watch2 = (TextView)findViewById(R.id.watch2);
        sleep2 = (TextView)findViewById(R.id.sleep2);
        close2 = (TextView)findViewById(R.id.close2);
        open2 = (TextView)findViewById(R.id.open2);
        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));
        ImageView cards= (ImageView) findViewById(R.id.c);
        ImageView practice = (ImageView) findViewById(R.id.speechvrifecation);


        ImageView smile = (ImageView) findViewById(R.id.smile);
        ImageView write= (ImageView) findViewById(R.id.write);
        ImageView speak = (ImageView) findViewById(R.id.speak);
        ImageView run = (ImageView) findViewById(R.id.run);
        ImageView think = (ImageView) findViewById(R.id.think);
        ImageView wash = (ImageView) findViewById(R.id.wash);
        ImageView sleep=(ImageView) findViewById(R.id.sleep);
        ImageView watchh = (ImageView) findViewById(R.id.watch);
        ImageView close =(ImageView) findViewById(R.id.close);
        ImageView open=(ImageView) findViewById(R.id.open);

        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();
//RECOED???

        final MediaPlayer OPENplayer =MediaPlayer.create(ACTIONS.this, R.raw.lockkk);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OPENplayer.start();
                globalv.addmImageUrls(R.drawable.open);
                globalv.addmNames(open2);
                globalv.addMrecords(R.raw.lockkk);
                initRecyclerView();

            }
        });
        //؟؟؟

        final MediaPlayer washplayer =MediaPlayer.create(ACTIONS.this, R.raw.wash);
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                washplayer.start();
                globalv.addmImageUrls(R.drawable.wash);
                globalv.addmNames(wash2);
                globalv.addMrecords(R.raw.wash);
                initRecyclerView();

            }
        });
        final MediaPlayer thinkplayer =MediaPlayer.create(ACTIONS.this, R.raw.thinkkk);
        think.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thinkplayer.start();
                globalv.addmImageUrls(R.drawable.think);
                globalv.addmNames(think2);
                globalv.addMrecords(R.raw.thinkkk);
                initRecyclerView();

            }
        });
        final MediaPlayer writeplayer =MediaPlayer.create(ACTIONS.this, R.raw.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeplayer.start();
                globalv.addmImageUrls(R.drawable.write);
                globalv.addmNames(write2);
                globalv.addMrecords(R.raw.write);
                initRecyclerView();

            }
        });


        //SMILE
        final MediaPlayer smileplayer =MediaPlayer.create(ACTIONS.this, R.raw.smileee);
        smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smileplayer.start();
                globalv.addmImageUrls(R.drawable.happy);
                globalv.addmNames(smile2);
                globalv.addMrecords(R.raw.smileee);
                initRecyclerView();

            }
        });




        //SPEAK
        final MediaPlayer speakplayer =MediaPlayer.create(ACTIONS.this, R.raw.speakkk);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakplayer.start();
                globalv.addmImageUrls(R.drawable.talk);
                globalv.addmNames(speak2);
                globalv.addMrecords(R.raw.speakkk);
                initRecyclerView();

            }
        });


        //RUN
        final MediaPlayer runplayer =MediaPlayer.create(ACTIONS.this, R.raw.runnn);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runplayer.start();
                globalv.addmImageUrls(R.drawable.run);
                globalv.addmNames(run2);
                globalv.addMrecords(R.raw.runnn);
                initRecyclerView();

            }
        });




        //WATCH
        final MediaPlayer watchplayer =MediaPlayer.create(ACTIONS.this, R.raw.watchhh);
        watchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchplayer.start();
                globalv.addmImageUrls(R.drawable.watchh);
                globalv.addmNames(watch2);
                globalv.addMrecords(R.raw.watchhh);
                initRecyclerView();

            }
        });




        //CLOSE
        final MediaPlayer closeplayer =MediaPlayer.create(ACTIONS.this, R.raw.lockkk);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeplayer.start();
                globalv.addmImageUrls(R.drawable.closed);
                globalv.addmNames(close2);
                globalv.addMrecords(R.raw.lockkk);
                initRecyclerView();

            }
        });

        //SLEEP
        final MediaPlayer sleepplayer =MediaPlayer.create(ACTIONS.this, R.raw.sleeppp);
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleepplayer.start();
                globalv.addmImageUrls(R.drawable.sleep);
                globalv.addmNames(sleep2);
                globalv.addMrecords(R.raw.sleeppp);
                initRecyclerView();

            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(ACTIONS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(ACTIONS.this,MainActivity.class);
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
        smile2.setText(resources.getString(R.string.smile));
        sleep2.setText(resources.getString(R.string.sleep));
        wash2.setText(resources.getString(R.string.wash));
        watch2.setText(resources.getString(R.string.watch));
        open2.setText(resources.getString(R.string.open));
        close2.setText(resources.getString(R.string.close));
        think2.setText(resources.getString(R.string.think));
        write2.setText(resources.getString(R.string.write));
        run2.setText(resources.getString(R.string.run));
        speak2.setText(resources.getString(R.string.speak));



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

    public static void CleanUpMemory(){
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
