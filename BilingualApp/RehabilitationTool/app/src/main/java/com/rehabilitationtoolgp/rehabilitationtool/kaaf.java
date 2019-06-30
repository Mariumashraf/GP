package com.rehabilitationtoolgp.rehabilitationtool;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

import java.util.ArrayList;

public class kaaf extends  Activity implements View.OnClickListener {
    private TextView mText;
    private MediaRecorder recorder;
    private SpeechRecognizer sr;
    private static final String TAG = "MyStt3Activity";
    private static View view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaaf);

        ImageView roman = (ImageView) findViewById(R.id.ketabbtn);
        ImageView tree = (ImageView) findViewById(R.id.maktabbtn);
        ImageView rock = (ImageView) findViewById(R.id.cakebtn);
        roman.setOnClickListener(this);
        tree.setOnClickListener(this);
        rock.setOnClickListener(this);
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
            Toast.makeText(kaaf.this, "error", Toast.LENGTH_LONG).show();
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


        if (this.view1.getId() == R.id.ketabbtn) {
            if (command.indexOf("كلب") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(kaaf.this, R.raw.bravo);
                bravoplayer.start();

            } else if (command.indexOf("كلب") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(kaaf.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        } else if (this.view1.getId() == R.id.maktabbtn) {
            if (command.indexOf("مكتب") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(kaaf.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("مكتب") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(kaaf.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }else if (this.view1.getId() == R.id.cakebtn) {
            if (command.indexOf("سمك") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(kaaf.this, R.raw.bravo);
                bravoplayer.start();


            } else if (command.indexOf("سمك") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(kaaf.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
    }


    public void onClick(View v) {
        this.view1 = v;
        if (v.getId() == R.id.ketabbtn || v.getId() == R.id.maktabbtn ||  v.getId() == R.id.cakebtn) {


            if (kaaf.view1.getId() == R.id.ketabbtn) {
                final MediaPlayer romanplayer = MediaPlayer.create(kaaf.this, R.raw.dog);
                romanplayer.start();
            }
            if (kaaf.view1.getId() == R.id.maktabbtn) {
                final MediaPlayer treeplayer = MediaPlayer.create(kaaf.this, R.raw.office);
                treeplayer.start();
            }
            if (kaaf.view1.getId() == R.id.cakebtn) {
                final MediaPlayer rockplayer = MediaPlayer.create(kaaf.this, R.raw.fishhh);
                rockplayer.start();
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

