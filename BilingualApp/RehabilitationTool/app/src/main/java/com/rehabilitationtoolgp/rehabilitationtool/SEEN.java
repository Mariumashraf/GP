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

public class SEEN extends  Activity implements View.OnClickListener {
    private TextView mText;
    private MediaRecorder recorder;
    private SpeechRecognizer sr;
    private static final String TAG = "MyStt3Activity";
    private static View view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seen);

        ImageView fish = (ImageView) findViewById(R.id.fishbtn);
        ImageView chair = (ImageView) findViewById(R.id.chairbtn);
        ImageView sun = (ImageView) findViewById(R.id.sunbtn);

        fish.setOnClickListener(this);
        chair.setOnClickListener(this);
        sun.setOnClickListener(this);
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

        {
            Toast.makeText(SEEN.this, "error", Toast.LENGTH_LONG).show();
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


        if (this.view1.getId() == R.id.fishbtn) {
            if (command.indexOf("سمك") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(SEEN.this, R.raw.bravo);
                bravoplayer.start();

            } else if (command.indexOf("سمك") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(SEEN.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        } else if (this.view1.getId() == R.id.chairbtn) {
            if (command.indexOf("كرسي") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(SEEN.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("كرسي") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(SEEN.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }

        else if (this.view1.getId() == R.id.sunbtn) {
            if (command.indexOf("شمس") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(SEEN.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("شمس") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(SEEN.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
    }

    public void onClick(View v) {
        this.view1 = v;


        if (v.getId() == R.id.fishbtn || v.getId() == R.id.chairbtn|| v.getId() == R.id.sunbtn ) {

            if (v.getId() == R.id.fishbtn) {
                final MediaPlayer fishplayer = MediaPlayer.create(SEEN.this, R.raw.fishhh);
                fishplayer.start();
            }
            if (v.getId() == R.id.chairbtn) {
                final MediaPlayer chairplayer = MediaPlayer.create(SEEN.this, R.raw.chairrr);
                chairplayer.start();
            }
            if (v.getId() == R.id.sunbtn) {
                final MediaPlayer sunplayer = MediaPlayer.create(SEEN.this, R.raw.sun);
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

