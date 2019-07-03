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

public class Questions extends AppCompatActivity {
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
        time2 = (TextView)findViewById(R.id.time2);
        howmoney2 = (TextView)findViewById(R.id.howmoney2);
        whichone2 = (TextView)findViewById(R.id.whichone2);
        who2 = (TextView)findViewById(R.id.who2);
        when2 = (TextView)findViewById(R.id.why2);
        why2 = (TextView)findViewById(R.id.when2);
        where2 = (TextView)findViewById(R.id.where2);


        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        ImageView where = (ImageView) findViewById(R.id.where);
        final ImageView why= (ImageView) findViewById(R.id.why);
        ImageView who =(ImageView) findViewById(R.id.who);
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
                whereplayer.start();
                globalv.addmImageUrls(R.drawable.where);
                globalv.addmNames(where2);
                globalv.addMrecords(R.raw.where);
                initRecyclerView();



            }
        });

        final MediaPlayer whyplayer = MediaPlayer.create(Questions.this,R.raw.why);
        why.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whyplayer.start();
                globalv.addmImageUrls(R.drawable.lmazaa);
                globalv.addmNames(why2);
                globalv.addMrecords(R.raw.why);
                initRecyclerView();



            }
        });



        final MediaPlayer riceplayer= MediaPlayer.create(Questions.this,R.raw.who);
        who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                riceplayer.start();
                globalv.addmImageUrls(R.drawable.who);
                globalv.addmNames(who2);
                globalv.addMrecords(R.raw.who);
                initRecyclerView();



            }
        });

        final MediaPlayer whichplayer = MediaPlayer.create(Questions.this,R.raw.whichone);
        whichone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichplayer.start();
                globalv.addmImageUrls(R.drawable.whichone);
                globalv.addmNames(whichone2);
                globalv.addMrecords(R.raw.whichone);
                initRecyclerView();



            }
        });


        final MediaPlayer whenplayer= MediaPlayer.create(Questions.this,R.raw.when);
        when.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whenplayer.start();
                globalv.addmImageUrls(R.drawable.date);
                globalv.addmNames(when2);
                globalv.addMrecords(R.raw.when);
                initRecyclerView();



            }
        });

        final MediaPlayer timeplayer = MediaPlayer.create(Questions.this,R.raw.timekam);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeplayer.start();
                globalv.addmImageUrls(R.drawable.time);
                globalv.addmNames(time2);
                globalv.addMrecords(R.raw.timekam);
                initRecyclerView();



            }
        });

        //EGG
        final MediaPlayer monplayer = MediaPlayer.create(Questions.this,R.raw.howmany);
        howmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monplayer.start();
                globalv.addmImageUrls(R.drawable.money);
                globalv.addmNames(howmoney2);
                globalv.addMrecords(R.raw.howmany);
                initRecyclerView();



            }
        });
//playALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(Questions.this, globalv.getMrecords().get(i));
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
