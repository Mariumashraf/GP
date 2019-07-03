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

import io.paperdb.Paper;


public class TOOLS extends AppCompatActivity {
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
        ImageView tablee = (ImageView) findViewById(R.id.tablee);
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
                dishplayer.start();
                globalv.addmImageUrls(R.drawable.dish);
                globalv.addmNames(dish2);
                globalv.addMrecords(R.raw.plateee);
                initRecyclerView();



            }
        });

        //CUP
        final MediaPlayer cupplayer = MediaPlayer.create(TOOLS.this,R.raw.cuppp);
        cupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cupplayer.start();
                globalv.addmImageUrls(R.drawable.mug);
                globalv.addmNames(cup2);
                globalv.addMrecords(R.raw.cuppp);
                initRecyclerView();



            }
        });

        //SPOON
        final MediaPlayer spoonplayer = MediaPlayer.create(TOOLS.this,R.raw.spoonnn);
        spoonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spoonplayer.start();
                globalv.addmImageUrls(R.drawable.spoon);
                globalv.addmNames(spoon2);
                globalv.addMrecords(R.raw.spoonnn);
                initRecyclerView();



            }
        });

        //FORK
        final MediaPlayer forkplayer = MediaPlayer.create(TOOLS.this,R.raw.forkkk);
        forkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forkplayer.start();
                globalv.addmImageUrls(R.drawable.fork);
                globalv.addmNames(fork2);
                globalv.addMrecords(R.raw.forkkk);
                initRecyclerView();



            }
        });

        //KNIFE
        final MediaPlayer knifeplayer = MediaPlayer.create(TOOLS.this,R.raw.knifeee);
        knifee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                knifeplayer.start();
                globalv.addmImageUrls(R.drawable.knife);
                globalv.addmNames(knife2);
                globalv.addMrecords(R.raw.knifeee);
                initRecyclerView();



            }
        });

        //SCISSORS
        final MediaPlayer scisplayer = MediaPlayer.create(TOOLS.this,R.raw.makasss);
        scissorss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scisplayer.start();
                globalv.addmImageUrls(R.drawable.maas);
                globalv.addmNames(scissorss2);
                globalv.addMrecords(R.raw.makasss);
                initRecyclerView();



            }
        });

        //CHAIR
        final MediaPlayer chairplayer = MediaPlayer.create(TOOLS.this,R.raw.chairrr);
        chairr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chairplayer.start();
                globalv.addmImageUrls(R.drawable.chair);
                globalv.addmNames(chair2);
                globalv.addMrecords(R.raw.chairrr);
                initRecyclerView();



            }
        });

        //TABLE
        final MediaPlayer tableplayer = MediaPlayer.create(TOOLS.this,R.raw.tableee);
        tablee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableplayer.start();
                globalv.addmImageUrls(R.drawable.table);
                globalv.addmNames(table2);
                globalv.addMrecords(R.raw.tableee);
                initRecyclerView();



            }
        });

        //NOTEBOOK
        final MediaPlayer noteplayer = MediaPlayer.create(TOOLS.this,R.raw.notebookkk);
        notebookk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteplayer.start();
                globalv.addmImageUrls(R.drawable.notebook);
                globalv.addmNames(notebook22);
                globalv.addMrecords(R.raw.notebookkk);
                initRecyclerView();



            }
        });

        //PEN
        final MediaPlayer penplayer = MediaPlayer.create(TOOLS.this,R.raw.pennn);
        penn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penplayer.start();
                globalv.addmImageUrls(R.drawable.pen);
                globalv.addmNames(pen2);
                globalv.addMrecords(R.raw.pennn);
                initRecyclerView();



            }
        });

        //GLASSES
        final MediaPlayer glassplayer = MediaPlayer.create(TOOLS.this,R.raw.glassss);
        glassess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glassplayer.start();
                globalv.addmImageUrls(R.drawable.glasses);
                globalv.addmNames(glassess2);
                globalv.addMrecords(R.raw.glassss);
                initRecyclerView();



            }
        });


        //TV
        final MediaPlayer tvplayer = MediaPlayer.create(TOOLS.this,R.raw.tvvv);
        tvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvplayer.start();
                globalv.addmImageUrls(R.drawable.tv);
                globalv.addmNames(tv2);
                globalv.addMrecords(R.raw.tvvv);
                initRecyclerView();



            }
        });

        //COMPUTER
        final MediaPlayer computerplayer = MediaPlayer.create(TOOLS.this,R.raw.computerrr);
        computerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computerplayer.start();
                globalv.addmImageUrls(R.drawable.pc);
                globalv.addmNames(computer2);
                globalv.addMrecords(R.raw.computerrr);
                initRecyclerView();



            }
        });

        //BALL
        final MediaPlayer ballplayer = MediaPlayer.create(TOOLS.this,R.raw.ballll);
        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ballplayer.start();
                globalv.addmImageUrls(R.drawable.ball);
                globalv.addmNames(ball2);
                globalv.addMrecords(R.raw.ballll);
                initRecyclerView();



            }
        });

        //TOYS
        final MediaPlayer toyplayer = MediaPlayer.create(TOOLS.this,R.raw.gamesss);
        toyss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toyplayer.start();
                globalv.addmImageUrls(R.drawable.toys);
                globalv.addmNames(toys2);
                globalv.addMrecords(R.raw.gamesss);
                initRecyclerView();



            }
        });


        final MediaPlayer watchplayer = MediaPlayer.create(TOOLS.this,R.raw.clock);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchplayer.start();
                globalv.addmImageUrls(R.drawable.watch);
                globalv.addmNames(watchh);
                globalv.addMrecords(R.raw.clock);
                initRecyclerView();



            }
        });


        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(TOOLS.this, globalv.getMrecords().get(i));
                    mediaPlay.start();
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
        }
        else  if(item.getItemId() == R.id.language_ar){
            Paper.book().write("language","ar");
            updateView((String)Paper.book().read("language"));
        }
        return true;
    }
}
