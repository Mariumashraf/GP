package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rehabilitationtoolgp.rehabilitationtool.Helper.LocalHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    TextView make,practice,remember;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        make = (TextView)findViewById(R.id.make);
        remember = (TextView)findViewById(R.id.remeber);
        practice = (TextView)findViewById(R.id.practicee);
        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));
        ImageView cards= (ImageView) findViewById(R.id.c);
        ImageView practice = (ImageView) findViewById(R.id.speechvrifecation);


        //Cards
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent1);

            }
        });
        //SPEECH VRIFECATION
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent12 = new Intent(MainActivity.this,PRACTICING.class);
                startActivity(intent12);


                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(MainActivity.this, globalv.getMrecords().get(i));
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
    }

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        make.setText(resources.getString(R.string.make));
        practice.setText(resources.getString(R.string.practice));
        remember.setText(resources.getString(R.string.remember));


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




