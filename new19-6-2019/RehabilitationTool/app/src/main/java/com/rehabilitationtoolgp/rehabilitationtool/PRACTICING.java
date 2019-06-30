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
        TextView seen = (TextView) findViewById(R.id.seenbtn);
        TextView raa = (TextView) findViewById(R.id.raabtn);
        TextView laam= (TextView) findViewById(R.id.laambtn);
        TextView qaaf= (TextView) findViewById(R.id.qaafbtn);
        TextView kaaf= (TextView) findViewById(R.id.kaafbtn);
        TextView geem= (TextView) findViewById(R.id.geembtn);
 seen.setOnClickListener(this);
        raa.setOnClickListener(this);
        laam.setOnClickListener(this);
        qaaf.setOnClickListener(this);
        kaaf.setOnClickListener(this);
        geem.setOnClickListener(this);
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
                try {
                    Thread.sleep(3000);
                } catch(InterruptedException e) {
                }
                Intent intent1 = new Intent(PRACTICING.this,SEEN.class);
                startActivity(intent1);

            } else if (command.indexOf("سين") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
        else if (this.view1.getId() == R.id.raabtn) {
            if (command.indexOf("راء") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(PRACTICING.this, R.raw.bravo);
                bravoplayer.start();
                try {
                    Thread.sleep(3000);
                } catch(InterruptedException e) {
                }
                Intent intent2 = new Intent(PRACTICING.this,RAA.class);
                startActivity(intent2);

            } else if (command.indexOf("راء") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
        else if (this.view1.getId() == R.id.laambtn) {
            if (command.indexOf("لام") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(PRACTICING.this, R.raw.bravo);
                bravoplayer.start();
                try {
                    Thread.sleep(3000);
                } catch(InterruptedException e) {
                }
                Intent intent2 = new Intent(PRACTICING.this,laam.class);
                startActivity(intent2);

            } else if (command.indexOf("لام") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
        else if (this.view1.getId() == R.id.qaafbtn) {
            if (command.indexOf("قاف") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(PRACTICING.this, R.raw.bravo);
                bravoplayer.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
<<<<<<< HEAD
               // Intent intent2 = new Intent(PRACTICING.this, qaaf.class);
                //startActivity(intent2);
=======
                Intent intent2 = new Intent(PRACTICING.this, laam.class);
                startActivity(intent2);
>>>>>>> f0cf9b186c6d0b3f8063256bd9283c5b02504fb2

            } else if (command.indexOf("قاف") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
        else if (this.view1.getId() == R.id.kaafbtn) {
            if (command.indexOf("كاف") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(PRACTICING.this, R.raw.bravo);
                bravoplayer.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
<<<<<<< HEAD
                //Intent intent2 = new Intent(PRACTICING.this, kaaf.class);
                //startActivity(intent2);
=======
                Intent intent2 = new Intent(PRACTICING.this, laam.class);
                startActivity(intent2);
>>>>>>> f0cf9b186c6d0b3f8063256bd9283c5b02504fb2

            } else if (command.indexOf("كاف") == -1) {

                //speak("apple");
                final MediaPlayer tryAgainplayer = MediaPlayer.create(PRACTICING.this, R.raw.tryagain);
                // mText.setText("error " + error);
                tryAgainplayer.start();
            }
            this.view1 = null;
        }
        else if (this.view1.getId() == R.id.geembtn) {
            if (command.indexOf("جيم") != -1) {

                final MediaPlayer bravoplayer = MediaPlayer.create(PRACTICING.this, R.raw.bravo);
                bravoplayer.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
<<<<<<< HEAD
              //  Intent intent2 = new Intent(PRACTICING.this, geem.class);
               // startActivity(intent2);
=======
                Intent intent2 = new Intent(PRACTICING.this, laam.class);
                startActivity(intent2);
>>>>>>> f0cf9b186c6d0b3f8063256bd9283c5b02504fb2

            } else if (command.indexOf("جيم") == -1) {

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

        if (v.getId() == R.id.seenbtn || v.getId() == R.id.raabtn || v.getId() == R.id.laambtn||v.getId() == R.id.qaafbtn||v.getId() == R.id.kaafbtn||v.getId() == R.id.geembtn) {


            if (v.getId() == R.id.seenbtn) {
                final MediaPlayer seenplayer = MediaPlayer.create(PRACTICING.this, R.raw.seen);
                seenplayer.start();

            }
            if (v.getId() == R.id.raabtn) {
                final MediaPlayer raaplayer = MediaPlayer.create(PRACTICING.this, R.raw.raa);
                raaplayer.start();
            }
            if (v.getId() == R.id.laambtn) {
                final MediaPlayer laamplayer = MediaPlayer.create(PRACTICING.this, R.raw.laam);
                laamplayer.start();

            }
            if (v.getId() == R.id.qaafbtn) {
<<<<<<< HEAD
              //  final MediaPlayer qaafplayer = MediaPlayer.create(PRACTICING.this, R.raw.qaaf);
                //qaafplayer.start();
            }
            if (v.getId() == R.id.kaafbtn) {
              //  final MediaPlayer kaafplayer = MediaPlayer.create(PRACTICING.this, R.raw.kaaf);
                //kaafplayer.start();
            }
            if (v.getId() == R.id.geembtn) {
               // final MediaPlayer seenplayer = MediaPlayer.create(PRACTICING.this, R.raw.geem);
                //seenplayer.start();
=======
                final MediaPlayer qaafplayer = MediaPlayer.create(PRACTICING.this, R.raw.laam);
                qaafplayer.start();
            }
            if (v.getId() == R.id.kaafbtn) {
                final MediaPlayer kaafplayer = MediaPlayer.create(PRACTICING.this, R.raw.laam);
                kaafplayer.start();
            }
            if (v.getId() == R.id.geembtn) {
                final MediaPlayer seenplayer = MediaPlayer.create(PRACTICING.this, R.raw.laam);
                seenplayer.start();
>>>>>>> f0cf9b186c6d0b3f8063256bd9283c5b02504fb2

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



