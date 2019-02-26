package com.rehabilitationtoolgp.rehabilitationtool;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

import java.util.ArrayList;
import java.util.List;

public class PRACTICING extends  Activity implements View.OnClickListener {
    private TextView mText;
    private MediaRecorder recorder;
    private SpeechRecognizer sr;
    private static final String TAG = "MyStt3Activity";
    private static View view1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicing);


        //activity_practicing     tools:context=".MainActivity"      Activity implements View.OnClickListener   AppCompatActivity
        Button seen = (Button) findViewById(R.id.seenbtn);
        Button raa = (Button) findViewById(R.id.raabtn);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


       /* ImageView want = (ImageView) findViewById(R.id.want);
        ImageView notwant= (ImageView) findViewById(R.id.notWant);
        ImageView eat = (ImageView) findViewById(R.id.eat);
        ImageView drink = (ImageView) findViewById(R.id.drink);
        ImageView wear = (ImageView) findViewById(R.id.wear);
        ImageView go = (ImageView) findViewById(R.id.go);
        ImageView yes= (ImageView) findViewById(R.id.yes);
        ImageView no = (ImageView) findViewById(R.id.no);
        ImageView family = (ImageView) findViewById(R.id.family);
        ImageView actions= (ImageView) findViewById(R.id.actions);
        ImageView trans= (ImageView) findViewById(R.id.trans);
        ImageView relations = (ImageView) findViewById(R.id.relations);
        ImageView time= (ImageView) findViewById(R.id.timee);
        ImageView tools =(ImageView) findViewById(R.id.tools2);
        ImageView createcard =(ImageView) findViewById(R.id.createcardd);
        Button play = (Button) findViewById(R.id.playall);
        Button practice = (Button) findViewById(R.id.speechvrifecationbtn);
        // Button next = (Button) findViewById(R.id.next);


        play.setVisibility(View.GONE);
        practice.setVisibility(View.GONE);
        createcard.setVisibility(View.GONE);

        //I WANT
        final MediaPlayer iwantplayer =MediaPlayer.create(PRACTICING.this, R.raw.ineeddd);
        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iwantplayer.start();
                *//*globalv.addmImageUrls(R.drawable.needddzz);
                globalv.addmNames(" أناعايز");
                globalv.addMrecords(R.raw.ineeddd);
                initRecyclerView();
*//*
            }
        });

        // I DONONT WANT
        final MediaPlayer inotwantplayer =MediaPlayer.create(PRACTICING.this, R.raw.inotneeddd);
        notwant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inotwantplayer .start();
               *//* globalv.addmImageUrls(R.drawable.notneedddz);
                globalv.addmNames(" أنا مش عايز");
                globalv.addMrecords(R.raw.inotneeddd);
                initRecyclerView();*//*

            }
        });


        //YES
        final MediaPlayer yesplayer =MediaPlayer.create(PRACTICING.this, R.raw.yesss);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yesplayer .start();
               *//* globalv.addmImageUrls(R.drawable.yesz);
                globalv.addmNames("نعم");
                globalv.addMrecords(R.raw.yesss);
                initRecyclerView();*//*

            }
        });

        //NO

        final MediaPlayer noplayer =MediaPlayer.create(PRACTICING.this, R.raw.nooo);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noplayer.start();
               *//* globalv.addmImageUrls(R.drawable.nooozz);
                globalv.addmNames("لا");
                globalv.addMrecords(R.raw.nooo);
                initRecyclerView();*//*

            }
        });

        //EAT

        final MediaPlayer eatplayer =MediaPlayer.create(PRACTICING.this, R.raw.eattt);
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eatplayer.start();
                *//*globalv.addmImageUrls(R.drawable.eatttzz);
                globalv.addmNames("أكل");
                globalv.addMrecords(R.raw.eattt);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*

                Intent intent1 = new Intent(PRACTICING.this,FOODS.class);
                startActivity(intent1);

            }
        });

        //DRINK

        final MediaPlayer drinkplayer =MediaPlayer.create(PRACTICING.this, R.raw.drinkkk);
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drinkplayer.start();
                *//*globalv.addmImageUrls(R.drawable.drinkkkkzz);
                globalv.addmNames(" أشرب");
                globalv.addMrecords(R.raw.drinkkk);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*

                Intent intent2 = new Intent(PRACTICING.this,DRINKS.class);
                startActivity(intent2);

            }
        });

        //WEAR

        final MediaPlayer wearplayer =MediaPlayer.create(PRACTICING.this, R.raw.wearrr);
        wear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wearplayer.start();
                *//*globalv.addmImageUrls(R.drawable.wearrrrz);
                globalv.addmNames("ألبس");
                globalv.addMrecords(R.raw.wearrr);
                initRecyclerView();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*


         *//*Intent intent3 = new Intent(PRACTICING.this,CLOTHES.class);
                startActivity(intent3);*//*

            }
        });

        //GO
        final MediaPlayer goplayer =MediaPlayer.create(PRACTICING.this, R.raw.gooo);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goplayer.start();
                *//*globalv.addmImageUrls(R.drawable.walkkkz);
                globalv.addmNames("اروح");
                globalv.addMrecords(R.raw.gooo);
                initRecyclerView();

                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*

         *//*Intent intent4 = new Intent(PRACTICING.this,PLACES.class);
                startActivity(intent4);*//*

            }
        });
        //FAMILY
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*
                Intent intent5 = new Intent(PRACTICING.this,FAMILY.class);
                startActivity(intent5);

            }
        });


        //ACTIONS
        actions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*CleanUpMemory();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*
                Intent intent6 = new Intent(PRACTICING.this,ACTIONS.class);
                startActivity(intent6);

            }
        });

        //TRANSPORTATION

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*
                Intent intent7 = new Intent(PRACTICING.this,TRANSPORTATION.class);
                startActivity(intent7);

            }
        });

        //DIRECTIONS
        relations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*CleanUpMemory();
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*
                Intent intent8 = new Intent(PRACTICING.this,DIRECTIONS.class);
                startActivity(intent8);

            }
        });

        //TIME
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*
                Intent intent9 = new Intent(PRACTICING.this,TIME.class);
                startActivity(intent9);
*/
           /* }
        });
        //TOOLS
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();*//*
                Intent intent10 = new Intent(PRACTICING.this,TOOLS.class);
                startActivity(intent10);

            }
        });

        //CREATE CARD
        createcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent11 = new Intent(PRACTICING.this,CREATCARD.class);
                startActivity(intent11);

            }
        });*/
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /*Button speakButton = (Button) findViewById(R.id.btn_speak);
        mText = (TextView) findViewById(R.id.textView1);*/
        seen.setOnClickListener(this);
        raa.setOnClickListener(this);
        sr = SpeechRecognizer.createSpeechRecognizer(this);
        sr.setRecognitionListener(new listener());
    }


    class listener implements RecognitionListener {
        public void onReadyForSpeech(Bundle params) {
        }

        public void onBeginningOfSpeech() {
        }

        public void onRmsChanged(float rmsdB) {
        }

        public void onBufferReceived(byte[] buffer) {
        }

        public void onEndOfSpeech() {
        }

        public void onError(int error)

        {//final MediaPlayer tryAgainplayer =MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
            // mText.setText("error " + error);
            //tryAgainplayer.start();
            Toast.makeText(PRACTICING.this, "error", Toast.LENGTH_LONG).show();
        }

        public void onResults(Bundle results) {
            String str = new String();
            Log.d(TAG, "onResults " + results);
            ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            //  txtSpeechInput.setText(data.get(0));
          /*for (int i = 0; i < data.size(); i++)
            {
                Log.d(TAG, "result " + data.get(i));
                str += data.get(i);
            }*/
            processResult(data.get(0));
           /*str= data.get(0);
            //  mText.setText("results: "+str+" "+String.valueOf(data.size()));
           // mText.setText("results: "+data.get(0));
            Toast.makeText(PRACTICING.this,str, Toast.LENGTH_LONG).show();
            if(str == "برتقاله"){
            final MediaPlayer bravoplayer =MediaPlayer.create(PRACTICING.this, R.raw.bravo);
            bravoplayer.start();}
            else if (str !="برتقاله") {
                final MediaPlayer tryAgainplayer =MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }*/
        }

        public void onPartialResults(Bundle partialResults) {
            Log.d(TAG, "onPartialResults");
        }

        public void onEvent(int eventType, Bundle params) {
            Log.d(TAG, "onEvent " + eventType);
        }
    }


    private void processResult(String command) {
        command = command.toLowerCase();


        if (this.view1.getId() == R.id.seenbtn) {
            if (command.indexOf("سين") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(PRACTICING.this, R.raw.bravo);
                bravoplayer.start();
                Intent intent1 = new Intent(PRACTICING.this,SEEN.class);
                startActivity(intent1);

            } else if (command.indexOf("سين") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        } else if (this.view1.getId() == R.id.raabtn) {
            if (command.indexOf("راء") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(PRACTICING.this, R.raw.bravo);
                bravoplayer.start();
                Intent intent1 = new Intent(PRACTICING.this,RAA.class);
                startActivity(intent1);

            } else if (command.indexOf("راء") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }

        // Toast.makeText(MainActivity.this,"orange", Toast.LENGTH_LONG).show();
       /* if (command.indexOf("orange") != -1) {

            speak("bravo");

        } else if (command.indexOf("orange") == -1){
            speak("try again");
        }

        //Toast.makeText(MainActivity.this,"book", Toast.LENGTH_LONG).show();
        if (command.indexOf("book") != -1) {

            speak("bravo");

        } else if (command.indexOf("book") == -1){
            speak("try again");
        }*/


//}
          /*  }if (command.indexOf("time") !=-1){

                Date now = new Date();
                String time = DateUtils.formatDateTime(this,now.getTime(),DateUtils.FORMAT_SHOW_TIME);
                speak("the time now is"+ time);

            }
        }else if (command.indexOf("open") !=-1){
            if (command.indexOf("browser") !=-1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tutsplus.com"));
                startActivity(intent);
            }*/
    }


    public void onClick(View v) {
        this.view1 = v;
        if (v.getId() == R.id.seenbtn || v.getId() == R.id.raabtn) {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-JO");

            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "tk.oryx.voice");
            //   intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 20000); // value to wait

            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);  // 1 is the maximum number of results to be returned.
            sr.startListening(intent);


            if (v.getId() == R.id.seenbtn) {
                final MediaPlayer seenplayer = MediaPlayer.create(PRACTICING.this, R.raw.seen);
                seenplayer.start();
            }
            if (v.getId() == R.id.raabtn) {
                final MediaPlayer raaplayer = MediaPlayer.create(PRACTICING.this, R.raw.raa);
                raaplayer.start();
            }
        }


    }
}



