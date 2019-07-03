package com.rehabilitationtoolgp.rehabilitationtool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class geem extends  Activity implements View.OnClickListener {
    private TextView mText;
    private MediaRecorder recorder;
    private SpeechRecognizer sr;
    private static final String TAG = "MyStt3Activity";
    private static View view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geem);

        ImageView fish = (ImageView) findViewById(R.id.gamalbtn);
        ImageView chair = (ImageView) findViewById(R.id.ngmbtn);
        ImageView sun = (ImageView) findViewById(R.id.talgbtn);

        fish.setOnClickListener(this);
        chair.setOnClickListener(this);
        sun.setOnClickListener(this);
        sr = SpeechRecognizer.createSpeechRecognizer(this);
        sr.setRecognitionListener(new listener());

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(geem.this,PRACTICING.class);
                startActivity(intent1);
            }
        });

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

        {
            Toast.makeText(geem.this, "error", Toast.LENGTH_LONG).show();
        }

        public void onResults(Bundle results) {
            String str = new String();
            Log.d(TAG, "onResults " + results);
            ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            processResult(data.get(0));

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


        if (this.view1.getId() == R.id.gamalbtn) {
            if (command.indexOf("جزمه") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(geem.this, R.raw.bravo);
                bravoplayer.start();

            } else if (command.indexOf("جزمه") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(geem.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        } else if (this.view1.getId() == R.id.ngmbtn) {
            if (command.indexOf("مانجه") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(geem.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("مانجه") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(geem.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }

        else if (this.view1.getId() == R.id.talgbtn) {
            if (command.indexOf("ثلج") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(geem.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("ثلج") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(geem.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
    }

    public void onClick(View v) {
        this.view1 = v;


        if (v.getId() == R.id.gamalbtn || v.getId() == R.id.ngmbtn|| v.getId() == R.id.talgbtn ) {

            if (v.getId() == R.id.gamalbtn) {
                final MediaPlayer fishplayer = MediaPlayer.create(geem.this, R.raw.shoesss);
                fishplayer.start();
            }
            if (v.getId() == R.id.ngmbtn) {
                final MediaPlayer chairplayer = MediaPlayer.create(geem.this, R.raw.mangooo);
                chairplayer.start();
            }
            if (v.getId() == R.id.talgbtn) {
                final MediaPlayer sunplayer = MediaPlayer.create(geem.this, R.raw.ice);
                sunplayer.start();
            }
            try {
                Thread.sleep(3000);
            } catch(InterruptedException e) {
            }

            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ar-JO");

            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "tk.oryx.voice");
            //   intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 20000); // value to wait

            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);  // 1 is the maximum number of results to be returned.
            sr.startListening(intent);



        }



    }
}

