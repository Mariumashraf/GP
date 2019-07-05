package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
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
import android.widget.Toast;

import com.rehabilitationtoolgp.rehabilitationtool.Helper.LocalHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import io.paperdb.Paper;


public class TOOLS extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    TextView dish2,fork2,spoon2,cup2,knife2,table2,chair2,scissorss2,glassess2,tv2,pen2,toys2,ball2,watchh,computer2,notebook22;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }

    private static final String TAG = "TOOLS";
    Globalrecycler globalv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                } else {
                    Toast.makeText(getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dish2 = (TextView)findViewById(R.id.dish2);
        cup2 = (TextView)findViewById(R.id.cup2);
        fork2 = (TextView)findViewById(R.id.fork2);
        spoon2 = (TextView)findViewById(R.id.spoon2);
        knife2 = (TextView)findViewById(R.id.knife2);
        table2 = (TextView)findViewById(R.id.table2);
        chair2 = (TextView)findViewById(R.id.chair2);
        scissorss2 = (TextView)findViewById(R.id.scissorss2);
        glassess2 = (TextView)findViewById(R.id.glassess2);
        tv2 = (TextView)findViewById(R.id.tv2);
        notebook22=(TextView)findViewById(R.id.notebook22);

        pen2 = (TextView)findViewById(R.id.pen2);
        toys2 = (TextView)findViewById(R.id.toys2);
        ball2 = (TextView)findViewById(R.id.ball2);
        watchh = (TextView)findViewById(R.id.watchh);
        computer2 = (TextView)findViewById(R.id.computer2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        ImageView dishh = (ImageView) findViewById(R.id.dishh);
        ImageView cupp= (ImageView) findViewById(R.id.cupp);
        ImageView spoonn = (ImageView) findViewById(R.id.spoonn);
        ImageView forkk = (ImageView) findViewById(R.id.forkk);
        ImageView knifee = (ImageView) findViewById(R.id.knifee);
        ImageView scissorss = (ImageView) findViewById(R.id.scissorss);
        ImageView chairr = (ImageView) findViewById(R.id.chairr);
        final ImageView tablee = (ImageView) findViewById(R.id.tablee);
        ImageView notebookk = (ImageView) findViewById(R.id.notebookk);
        ImageView penn = (ImageView) findViewById(R.id.penn);
        ImageView glassess = (ImageView) findViewById(R.id.glassess);
        ImageView tvv = (ImageView) findViewById(R.id.tvv);
        ImageView computerr = (ImageView) findViewById(R.id.computerr);
        ImageView ball = (ImageView) findViewById(R.id.ball);
        ImageView toyss = (ImageView) findViewById(R.id.toyss);
        ImageView watch = (ImageView) findViewById(R.id.watch);

        ImageButton play = (ImageButton) findViewById(R.id.playall);
        Button back = (Button) findViewById(R.id.back);

        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //DISH
        final MediaPlayer dishplayer = MediaPlayer.create(TOOLS.this,R.raw.plateee);
        dishh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dish2.getText().toString().equalsIgnoreCase("Dish")){
                    String data="dish";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.dish);
                    globalv.addmNames(dish2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    dishplayer .start();
                    globalv.addMrecords(R.raw.plateee);
                    globalv.addmImageUrls(R.drawable.dish);
                    globalv.addmNames(dish2);
                }
                initRecyclerView();



            }
        });

        //CUP
        final MediaPlayer cupplayer = MediaPlayer.create(TOOLS.this,R.raw.cuppp);
        cupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cup2.getText().toString().equalsIgnoreCase("Cup")){
                    String data="cup";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.mug);
                    globalv.addmNames(cup2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    cupplayer .start();
                    globalv.addMrecords(R.raw.cuppp);
                    globalv.addmImageUrls(R.drawable.mug);
                    globalv.addmNames(cup2);
                }
                initRecyclerView();



            }
        });

        //SPOON
        final MediaPlayer spoonplayer = MediaPlayer.create(TOOLS.this,R.raw.spoonnn);
        spoonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spoon2.getText().toString().equalsIgnoreCase("Spoon")){
                    String data="spoon";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.spoon);
                    globalv.addmNames(spoon2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    spoonplayer .start();
                    globalv.addMrecords(R.raw.spoonnn);
                    globalv.addmImageUrls(R.drawable.spoon);
                    globalv.addmNames(spoon2);
                }
                initRecyclerView();



            }
        });

        //FORK
        final MediaPlayer forkplayer = MediaPlayer.create(TOOLS.this,R.raw.forkkk);
        forkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fork2.getText().toString().equalsIgnoreCase("Fork")){
                    String data="fork";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.fork);
                    globalv.addmNames(fork2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    forkplayer .start();
                    globalv.addMrecords(R.raw.forkkk);
                    globalv.addmImageUrls(R.drawable.fork);
                    globalv.addmNames(fork2);
                }
                initRecyclerView();



            }
        });

        //KNIFE
        final MediaPlayer knifeplayer = MediaPlayer.create(TOOLS.this,R.raw.knifeee);
        knifee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(knife2.getText().toString().equalsIgnoreCase("Knife")){
                    String data="knife";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.knife);
                    globalv.addmNames(knife2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    knifeplayer .start();
                    globalv.addMrecords(R.raw.knifeee);
                    globalv.addmImageUrls(R.drawable.knife);
                    globalv.addmNames(knife2);
                }
                initRecyclerView();



            }
        });

        //SCISSORS
        final MediaPlayer scisplayer = MediaPlayer.create(TOOLS.this,R.raw.makasss);
        scissorss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(scissorss2.getText().toString().equalsIgnoreCase("Scissors")){
                    String data="scissors";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.maas);
                    globalv.addmNames(scissorss2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    scisplayer .start();
                    globalv.addMrecords(R.raw.makasss);
                    globalv.addmImageUrls(R.drawable.maas);
                    globalv.addmNames(scissorss2);
                }
                initRecyclerView();



            }
        });

        //CHAIR
        final MediaPlayer chairplayer = MediaPlayer.create(TOOLS.this,R.raw.chairrr);
        chairr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chair2.getText().toString().equalsIgnoreCase("Chair")){
                    String data="chair";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.chair);
                    globalv.addmNames(chair2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    chairplayer .start();
                    globalv.addMrecords(R.raw.chairrr);
                    globalv.addmImageUrls(R.drawable.chair);
                    globalv.addmNames(chair2);
                }
                initRecyclerView();



            }
        });

        //TABLE
        final MediaPlayer tableplayer = MediaPlayer.create(TOOLS.this,R.raw.tableee);
        tablee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(table2.getText().toString().equalsIgnoreCase("Table")){
                    String data="table";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.table);
                    globalv.addmNames(table2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    tableplayer .start();
                    globalv.addMrecords(R.raw.tableee);
                    globalv.addmImageUrls(R.drawable.table);
                    globalv.addmNames(table2);
                }
                initRecyclerView();



            }
        });

        //NOTEBOOK
        final MediaPlayer noteplayer = MediaPlayer.create(TOOLS.this,R.raw.notebookkk);
        notebookk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notebook22.getText().toString().equalsIgnoreCase("Notebook")){
                    String data="notebook";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.notebook);
                    globalv.addmNames(notebook22);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    noteplayer .start();
                    globalv.addMrecords(R.raw.notebookkk);
                    globalv.addmImageUrls(R.drawable.notebook);
                    globalv.addmNames(notebook22);
                }
                initRecyclerView();



            }
        });

        //PEN
        final MediaPlayer penplayer = MediaPlayer.create(TOOLS.this,R.raw.pennn);
        penn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pen2.getText().toString().equalsIgnoreCase("Pen")){
                    String data="pen";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.pen);
                    globalv.addmNames(pen2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    penplayer .start();
                    globalv.addMrecords(R.raw.pennn);
                    globalv.addmImageUrls(R.drawable.pen);
                    globalv.addmNames(pen2);
                }
                initRecyclerView();



            }
        });

        //GLASSES
        final MediaPlayer glassplayer = MediaPlayer.create(TOOLS.this,R.raw.glassss);
        glassess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(glassess2.getText().toString().equalsIgnoreCase("Glasses")){
                    String data="glasses";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.glasses);
                    globalv.addmNames(glassess2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    glassplayer .start();
                    globalv.addMrecords(R.raw.glassss);
                    globalv.addmImageUrls(R.drawable.glasses);
                    globalv.addmNames(glassess2);
                }
                initRecyclerView();



            }
        });


        //TV
        final MediaPlayer tvplayer = MediaPlayer.create(TOOLS.this,R.raw.tvvv);
        tvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv2.getText().toString().equalsIgnoreCase("Tv")){
                    String data="tv";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.tv);
                    globalv.addmNames(tv2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    tvplayer .start();
                    globalv.addMrecords(R.raw.tvvv);
                    globalv.addmImageUrls(R.drawable.tv);
                    globalv.addmNames(tv2);
                }
                initRecyclerView();



            }
        });

        //COMPUTER
        final MediaPlayer computerplayer = MediaPlayer.create(TOOLS.this,R.raw.computerrr);
        computerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(computer2.getText().toString().equalsIgnoreCase("Computer")){
                    String data="computer";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.pc);
                    globalv.addmNames(computer2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    computerplayer .start();
                    globalv.addMrecords(R.raw.computerrr);
                    globalv.addmImageUrls(R.drawable.pc);
                    globalv.addmNames(computer2);
                }
                initRecyclerView();



            }
        });

        //BALL
        final MediaPlayer ballplayer = MediaPlayer.create(TOOLS.this,R.raw.ballll);
        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ball2.getText().toString().equalsIgnoreCase("Ball")){
                    String data="ball";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.ball);
                    globalv.addmNames(ball2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    ballplayer .start();
                    globalv.addMrecords(R.raw.ballll);
                    globalv.addmImageUrls(R.drawable.ball);
                    globalv.addmNames(ball2);
                }
                initRecyclerView();



            }
        });

        //TOYS
        final MediaPlayer toyplayer = MediaPlayer.create(TOOLS.this,R.raw.gamesss);
        toyss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toys2.getText().toString().equalsIgnoreCase("Toys")){
                    String data="toys";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.toys);
                    globalv.addmNames(toys2);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    toyplayer .start();
                    globalv.addMrecords(R.raw.gamesss);
                    globalv.addmImageUrls(R.drawable.toys);
                    globalv.addmNames(toys2);
                }


                initRecyclerView();



            }
        });


        final MediaPlayer watchplayer = MediaPlayer.create(TOOLS.this,R.raw.clock);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(watchh.getText().toString().equalsIgnoreCase("Watch")){
                    String data="watch";
                    int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
                    globalv.addmImageUrls(R.drawable.watch);
                    globalv.addmNames(watchh);
                    globalv.addMrecords(speechStatus);


                }
                else{
                    watchplayer .start();
                    globalv.addMrecords(R.raw.clock);
                    globalv.addmImageUrls(R.drawable.watch);
                    globalv.addmNames(watchh);
                }
                initRecyclerView();



            }
        });


        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(MainActivity.this, globalv.getMrecords().get(i));
                    mediaPlay.start();*/
                    if(globalv.getmNames().get(i) instanceof TextView){
                        TextView M = (TextView) globalv.getmNames().get(i);
                        int t = 1;
                        switch(t){
                            case 1:   if (globalv.getMrecords().get(i) instanceof Integer && Locale.getDefault().getLanguage().equals("en")) {
                                // The Object is an instance of a String
                                Integer N = (Integer) globalv.getMrecords().get(i);
                                String data = (String)M.getText().toString();
                                int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                            }
                            case 2:if(globalv.getMrecords().get(i) instanceof Integer && Locale.getDefault().getLanguage().equals("ar")){
                                // The Object is an instance of a String
                                Integer N = (Integer) globalv.getMrecords().get(i);

                                MediaPlayer mediaPlayer=MediaPlayer.create(view.getContext(),N);
                                mediaPlayer.start();



                            }}


                    }else if (globalv.getmNames().get(i) instanceof String){
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

                Intent intent1 = new Intent(TOOLS.this,Main2Activity.class);
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
        tv2.setText(resources.getString(R.string.tv));
        glassess2.setText(resources.getString(R.string.glassesss));
        scissorss2.setText(resources.getString(R.string.scissorsss));
        chair2.setText(resources.getString(R.string.chair));
        table2.setText(resources.getString(R.string.table));
        knife2.setText(resources.getString(R.string.knife));
        cup2.setText(resources.getString(R.string.cup));
        spoon2.setText(resources.getString(R.string.spoon));
        fork2.setText(resources.getString(R.string.fork));
        dish2.setText(resources.getString(R.string.dish));

        computer2.setText(resources.getString(R.string.computer));
        watchh.setText(resources.getString(R.string.watc));
        ball2.setText(resources.getString(R.string.balll));
        toys2.setText(resources.getString(R.string.toys));
        pen2.setText(resources.getString(R.string.pen));
        notebook22.setText(resources.getString(R.string.notebook));






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
            globalv.getmNames().clear();
            globalv.getmImageUrls().clear();
            globalv.getMrecords().clear();
        }
        else  if(item.getItemId() == R.id.language_ar){
            Paper.book().write("language","ar");
            updateView((String)Paper.book().read("language"));
            globalv.getmNames().clear();
            globalv.getmImageUrls().clear();
            globalv.getMrecords().clear();
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
    private void speakWords(String speech) {

        //speak straight away
        textToSpeech.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
