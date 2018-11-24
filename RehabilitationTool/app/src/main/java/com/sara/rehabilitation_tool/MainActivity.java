package com.sara.rehabilitation_tool;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadlocate();
        setContentView(R.layout.activity_main);

        Button Language = findViewById(R.id.language);
        Language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }

        });

        final MediaPlayer playEat = MediaPlayer.create(MainActivity.this,R.raw.eat);
        Button eat = findViewById(R.id.eat);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playEat.start();
                Intent intent = new Intent(MainActivity.this, Food.class);
                startActivity(intent);
            }
        });

        final MediaPlayer playDrink= MediaPlayer.create(MainActivity.this,R.raw.drink);
        Button drink = findViewById(R.id.drink);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playDrink.start();
                Intent intent = new Intent(MainActivity.this, Drink.class);
                startActivity(intent);
            }
        });



        final MediaPlayer playWant= MediaPlayer.create(MainActivity.this,R.raw.want);
        Button want = findViewById(R.id.want);
        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playWant.start();

            }
        });

        final MediaPlayer playNotWant= MediaPlayer.create(MainActivity.this,R.raw.notwant);
        Button notWant = findViewById(R.id.notWant);
        notWant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playNotWant.start();

            }
        });

        final MediaPlayer playNo= MediaPlayer.create(MainActivity.this,R.raw.no);
        Button no = findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playNo.start();

            }
        });

        final MediaPlayer playYes= MediaPlayer.create(MainActivity.this,R.raw.yes);
        Button yes = findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playYes.start();

            }
        });

        final MediaPlayer playWear= MediaPlayer.create(MainActivity.this,R.raw.wear);
        Button wear = findViewById(R.id.wear);
        wear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playWear.start();
                Intent intent = new Intent(MainActivity.this, Wear.class);
                startActivity(intent);

            }
        });

        final MediaPlayer playGo= MediaPlayer.create(MainActivity.this,R.raw.wear);
        Button go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGo.start();
                Intent intent = new Intent(MainActivity.this, Places.class);
                startActivity(intent);

            }
        });



    }
    private void showChangeLanguageDialog(){
        final String[] listItems = {" عربي ", " English "};
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
        myBuilder.setTitle("اختر اللغة ...");
        myBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0){

                    setLocale("ar"); //Arabic
                    recreate();
                }
                if (i==1){

                    setLocale("en"); //English
                    recreate();
                }
                //Dismiss alert dialog when language selected
                dialogInterface.dismiss();



            }
        });
        AlertDialog mDialog = myBuilder.create();
        //show alert dialog
        mDialog.show();

    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putString("My language",lang);
        editor.apply();
    }

    //load language saved on Preferences
    public void loadlocate(){
        SharedPreferences prefs = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My language", "");
        setLocale(language);
    }

}
