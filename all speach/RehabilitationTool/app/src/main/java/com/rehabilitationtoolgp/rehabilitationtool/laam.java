package com.rehabilitationtoolgp.rehabilitationtool;

import android.support.v7.app.AppCompatActivity;
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
import android.os.Bundle;


public class laam extends  Activity implements View.OnClickListener {
    private TextView mText;
    private MediaRecorder recorder;
    private SpeechRecognizer sr;
    private static final String TAG = "MyStt3Activity";
    private static View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laam);
        Button lamba = (Button) findViewById(R.id.lambabtn);
        Button selm = (Button) findViewById(R.id.selmbtn);

        lamba.setOnClickListener(this);
        selm.setOnClickListener(this);
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
            Toast.makeText(laam.this, "error", Toast.LENGTH_LONG).show();
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


        if (this.view1.getId() == R.id.lambabtn) {
            if (command.indexOf("لمبه") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(laam.this, R.raw.bravo);
                bravoplayer.start();

            } else if (command.indexOf("لمبه") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(laam.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        } else if (this.view1.getId() == R.id.selmbtn) {
            if (command.indexOf("سلم") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(laam.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("سلم") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(laam.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }else if (this.view1.getId() == R.id.basalbtn) {
            if (command.indexOf("بصل") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(laam.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("بصل") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(laam.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
    }

    public void onClick(View v) {
        this.view1 = v;


        if (v.getId() == R.id.lambabtn || v.getId() == R.id.selmbtn ) {

            if (v.getId() == R.id.lambabtn) {
                final MediaPlayer fishplayer = MediaPlayer.create(laam.this, R.raw.lamp);
                fishplayer.start();
            }
            if (v.getId() == R.id.selmbtn) {
                final MediaPlayer chairplayer = MediaPlayer.create(laam.this, R.raw.staires);
                chairplayer.start();
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
