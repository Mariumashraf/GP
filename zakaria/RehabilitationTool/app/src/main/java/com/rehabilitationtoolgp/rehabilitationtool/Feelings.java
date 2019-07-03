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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import io.paperdb.Paper;

public class Feelings extends AppCompatActivity {
    private static final String TAG = "Feelings";
    Globalrecycler globalv;
    TextView sad2,happy2,mooref2,donotunder2,laziiz2,hurt2,scared2,mothams2,mozeeg2,boring2,hate2,love2,mohrg2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feelings);

        sad2 = (TextView)findViewById(R.id.sad2);
        happy2 = (TextView)findViewById(R.id.happy2);
        mooref2 = (TextView)findViewById(R.id.mooref2);
        donotunder2 = (TextView)findViewById(R.id.donotunder2);
        laziiz2 = (TextView)findViewById(R.id.laziiz2);
        hurt2 = (TextView)findViewById(R.id.hurt2);
        scared2 = (TextView)findViewById(R.id.scared2);
        mothams2 = (TextView)findViewById(R.id.mothams2);
        mozeeg2 = (TextView)findViewById(R.id.mozeeg2);
        boring2 = (TextView)findViewById(R.id.boring2);
        hate2 = (TextView)findViewById(R.id.hate2);
        love2 = (TextView)findViewById(R.id.love2);
        mohrg2 = (TextView)findViewById(R.id.mohrg2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));

        ImageView sad = (ImageView) findViewById(R.id.sad);
        ImageView happy= (ImageView) findViewById(R.id.happy);
        ImageView hate = (ImageView) findViewById(R.id.hate);
        ImageView love = (ImageView) findViewById(R.id.love);
        ImageView mohrag = (ImageView) findViewById(R.id.mohrag);
        ImageView mozeeg = (ImageView) findViewById(R.id.mozeeg);
        ImageView boring = (ImageView) findViewById(R.id.boring);
        ImageView methams = (ImageView) findViewById(R.id.methams);
        ImageView scared = (ImageView) findViewById(R.id.scared);
        ImageView hurt = (ImageView) findViewById(R.id.hurt);
        ImageView laziiz = (ImageView) findViewById(R.id.laziiz);
        final ImageView mooref = (ImageView) findViewById(R.id.mooref);
        ImageView donotunder = (ImageView) findViewById(R.id.donotunder);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        final MediaPlayer sadplayer =MediaPlayer.create(Feelings.this, R.raw.sad);
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sadplayer.start();
                globalv.addmImageUrls(R.drawable.sad);
                globalv.addmNames(sad2);
               globalv.addMrecords(R.raw.sad);
                initRecyclerView();

            }
        });
        final MediaPlayer happyplayer =MediaPlayer.create(Feelings.this, R.raw.happy);
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                happyplayer.start();
                globalv.addmImageUrls(R.drawable.happy);
                globalv.addmNames(happy2);
                globalv.addMrecords(R.raw.happy);
                initRecyclerView();

            }
        });

        final MediaPlayer hateplayer =MediaPlayer.create(Feelings.this, R.raw.hate);
        hate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hateplayer.start();
                globalv.addmImageUrls(R.drawable.hate);
                globalv.addmNames(hate2);
               globalv.addMrecords(R.raw.hate);
                initRecyclerView();

            }
        });

       final MediaPlayer loveplayer =MediaPlayer.create(Feelings.this, R.raw.love);
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              loveplayer.start();
                globalv.addmImageUrls(R.drawable.love);
                globalv.addmNames(love2);
               globalv.addMrecords(R.raw.love);
                initRecyclerView();

            }
        });

        final MediaPlayer mohragplayer =MediaPlayer.create(Feelings.this, R.raw.mohrag);
        mohrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mohragplayer.start();
                globalv.addmImageUrls(R.drawable.mohrag);
                globalv.addmNames(mohrg2);
               globalv.addMrecords(R.raw.mohrag);
                initRecyclerView();

            }
        });

        final MediaPlayer mozegplayer =MediaPlayer.create(Feelings.this, R.raw.mozeeg);
        mozeeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mozegplayer.start();
                globalv.addmImageUrls(R.drawable.mozeeg);
                globalv.addmNames(mozeeg2);
                globalv.addMrecords(R.raw.mozeeg);
                initRecyclerView();

            }
        });

        final MediaPlayer borplayer =MediaPlayer.create(Feelings.this, R.raw.boring);
        boring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               borplayer.start();
                globalv.addmImageUrls(R.drawable.boring);
                globalv.addmNames(boring2);
                globalv.addMrecords(R.raw.boring);
                initRecyclerView();

            }
        });
        final MediaPlayer metplayer =MediaPlayer.create(Feelings.this, R.raw.methams);
        methams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                metplayer.start();
                globalv.addmImageUrls(R.drawable.methams);
                globalv.addmNames(mothams2);
                globalv.addMrecords(R.raw.methams);
                initRecyclerView();

            }
        });

        final MediaPlayer hurtplayer =MediaPlayer.create(Feelings.this, R.raw.hurt);
        hurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hurtplayer.start();
                globalv.addmImageUrls(R.drawable.hurt);
                globalv.addmNames(hurt2);
                globalv.addMrecords(R.raw.hurt);
                initRecyclerView();

            }
        });

        final MediaPlayer scarplayer =MediaPlayer.create(Feelings.this, R.raw.scared);
        scared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scarplayer.start();
                globalv.addmImageUrls(R.drawable.scared);
                globalv.addmNames(scared2);
              globalv.addMrecords(R.raw.scared);
                initRecyclerView();

            }
        });

        final MediaPlayer lazplayer =MediaPlayer.create(Feelings.this, R.raw.laziiz);
        laziiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lazplayer.start();
                globalv.addmImageUrls(R.drawable.laziiiz);
                globalv.addmNames(laziiz2);
                globalv.addMrecords(R.raw.laziiz);
                initRecyclerView();

            }
        });

        final MediaPlayer donotplayer =MediaPlayer.create(Feelings.this, R.raw.donotunder);
        donotunder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donotplayer.start();
                globalv.addmImageUrls(R.drawable.donotunderstand);
                globalv.addmNames(donotunder2);
                globalv.addMrecords(R.raw.donotunder);
                initRecyclerView();

            }
        });

        final MediaPlayer moorefplayer =MediaPlayer.create(Feelings.this, R.raw.mooref);
        mooref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moorefplayer.start();
                globalv.addmImageUrls(R.drawable.mooref);
                globalv.addmNames(mooref2);
                globalv.addMrecords(R.raw.mooref);
                initRecyclerView();

            }
        });

        //PLAY ALL

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(Feelings.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(Feelings.this,Main2Activity.class);
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

        sad2.setText(resources.getString(R.string.sad));
        happy2.setText(resources.getString(R.string.happy));
        mooref2.setText(resources.getString(R.string.nasty));
        donotunder2.setText(resources.getString(R.string.donotunder));
        laziiz2.setText(resources.getString(R.string.tasty));
        hurt2.setText(resources.getString(R.string.painful));
        scared2.setText(resources.getString(R.string.scared));
        mothams2.setText(resources.getString(R.string.enthusiastic));
        mozeeg2.setText(resources.getString(R.string.annoying));
        boring2.setText(resources.getString(R.string.boring));
        hate2.setText(resources.getString(R.string.ihate));
        love2.setText(resources.getString(R.string.ilike));
        mohrg2.setText(resources.getString(R.string.shy));





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
}
