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

public class FOODS extends AppCompatActivity {
    TextView vegetables2,fruits2,rice2,egg2,cheese2,yogurt2,sandwich2,fish2,salad2,pizza2,chicken2,bread2,meat2,soup2,jam2,icecream2,honey2,biscuit2,popcorn2,chocolate2;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    private static final String TAG = "FOODS";
    Globalrecycler globalv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleanUpMemory();
        setContentView(R.layout.activity_foods);


        vegetables2 = (TextView)findViewById(R.id.vegatable2);
        fruits2 = (TextView)findViewById(R.id.fruit2);
        rice2 = (TextView)findViewById(R.id.rice2);
        egg2 = (TextView)findViewById(R.id.egg2);
        cheese2 = (TextView)findViewById(R.id.cheese2);
        yogurt2 = (TextView)findViewById(R.id.Yogurt2);
        sandwich2 = (TextView)findViewById(R.id.sandwich2);
        salad2 = (TextView)findViewById(R.id.salad2);
        pizza2 = (TextView)findViewById(R.id.pizza2);
        soup2 = (TextView)findViewById(R.id.soup2);
        chicken2 = (TextView)findViewById(R.id.chickens2);
        bread2 = (TextView)findViewById(R.id.bread2);
        meat2 = (TextView)findViewById(R.id.meat2);
        jam2 = (TextView)findViewById(R.id.jam2);
        icecream2 = (TextView)findViewById(R.id.icecream2);
        honey2 = (TextView)findViewById(R.id.honey2);
        biscuit2 = (TextView)findViewById(R.id.biscuit2);
        chocolate2 = (TextView)findViewById(R.id.chocolate2);
        popcorn2 = (TextView)findViewById(R.id.popcorn2);
        fish2 = (TextView)findViewById(R.id.fish2);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));

        ImageView rice = (ImageView) findViewById(R.id.rice);
        ImageView egg = (ImageView) findViewById(R.id.egg);
        ImageView vegatable = (ImageView) findViewById(R.id.vegatable);
        ImageView fruit= (ImageView) findViewById(R.id.fruit);
        ImageView icecream = (ImageView) findViewById(R.id.icecream);
        ImageView pizza = (ImageView) findViewById(R.id.pizza);
        ImageView biscuit = (ImageView) findViewById(R.id.biscuit);
        ImageView cheese = (ImageView) findViewById(R.id.cheese);
        final ImageView Yogurt = (ImageView) findViewById(R.id.Yogurt);
        ImageView salad = (ImageView) findViewById(R.id.salad);
        ImageView fish = (ImageView) findViewById(R.id.samka);
        ImageView sandwich = (ImageView) findViewById(R.id.sandwich);
        ImageView soup = (ImageView) findViewById(R.id.soup);
        ImageView Chocolate = (ImageView) findViewById(R.id.Chocolate);
        ImageView honey= (ImageView) findViewById(R.id.honey);
        ImageView bread =(ImageView) findViewById(R.id.bread);
        ImageView chickens=(ImageView) findViewById(R.id.chickens);
        ImageView popcorn= (ImageView) findViewById(R.id.popcorn);
        ImageView meat =(ImageView) findViewById(R.id.meat);
        ImageView jam=(ImageView) findViewById(R.id.jam);
        ImageButton play = (ImageButton) findViewById(R.id.playalll);
        Button back = (Button) findViewById(R.id.back);


        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        //RICE

        final MediaPlayer riceplayer= MediaPlayer.create(FOODS.this,R.raw.riceee);
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                riceplayer.start();
               globalv.addmImageUrls(R.drawable.roz);
                globalv.addmNames(rice2);
                globalv.addMrecords(R.raw.riceee);
                initRecyclerView();



            }
        });

        //EGG
        final MediaPlayer eggplayer = MediaPlayer.create(FOODS.this,R.raw.egggg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eggplayer.start();
                globalv.addmImageUrls(R.drawable.egg);
                globalv.addmNames(egg2);
                globalv.addMrecords(R.raw.egggg);
                initRecyclerView();



            }
        });


        //VEGATABLES

        vegatable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent12 = new Intent(FOODS.this,VEGETABLES.class);
                startActivity(intent12);



            }
        });

        //FRUIT
        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();
                Intent intent13 = new Intent(FOODS.this,FRUIT.class);
                startActivity(intent13);;



            }
        });


        //ICE CREAM

        final MediaPlayer iceplayer= MediaPlayer.create(FOODS.this,R.raw.icecreammm);
        icecream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iceplayer.start();
               globalv.addmImageUrls(R.drawable.icecream);
                globalv.addmNames(icecream2);
                globalv.addMrecords(R.raw.icecreammm);
                initRecyclerView();



            }
        });

        //PIZZA
        final MediaPlayer pizzaplayer = MediaPlayer.create(FOODS.this,R.raw.pizzaaa);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pizzaplayer.start();
                globalv.addmImageUrls(R.drawable.pizza);
                globalv.addmNames(pizza2);
                globalv.addMrecords(R.raw.pizzaaa);
                initRecyclerView();



            }
        });


        //BISCUITS

        final MediaPlayer biscuitplayer= MediaPlayer.create(FOODS.this,R.raw.biscuitsss);
        biscuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biscuitplayer.start();
                globalv.addmImageUrls(R.drawable.baskot);
                globalv.addmNames(biscuit2);
                globalv.addMrecords(R.raw.biscuitsss);
                initRecyclerView();



            }
        });

        //CHEESE
        final MediaPlayer cheeseplayer = MediaPlayer.create(FOODS.this,R.raw.cheeseee);
        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheeseplayer.start();
               globalv.addmImageUrls(R.drawable.gebna);
                globalv.addmNames(cheese2);
                globalv.addMrecords(R.raw.cheeseee);
                initRecyclerView();



            }
        });


        //YOGURT

        final MediaPlayer yogurtplayer= MediaPlayer.create(FOODS.this,R.raw.zbadyyy);
        Yogurt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yogurtplayer.start();
                globalv.addmImageUrls(R.drawable.zbady);
                globalv.addmNames(yogurt2);
                globalv.addMrecords(R.raw.zbadyyy);
                initRecyclerView();



            }
        });

        //SALAD
        final MediaPlayer saladplayer = MediaPlayer.create(FOODS.this,R.raw.saladdd);
        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saladplayer.start();
                globalv.addmImageUrls(R.drawable.salta);
                globalv.addmNames(salad2);
                globalv.addMrecords(R.raw.saladdd);
                initRecyclerView();



            }
        });


        //FISH

        final MediaPlayer fishplayer= MediaPlayer.create(FOODS.this,R.raw.fishhh);
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fishplayer.start();
                globalv.addmImageUrls(R.drawable.samka);
                globalv.addmNames(fish2);
                globalv.addMrecords(R.raw.fishhh);
                initRecyclerView();



            }
        });

        //SANDWICH
        final MediaPlayer sandwichplayer = MediaPlayer.create(FOODS.this,R.raw.sandwichesss);
        sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sandwichplayer.start();
                globalv.addmImageUrls(R.drawable.sandwich);
                globalv.addmNames(sandwich2);
                globalv.addMrecords(R.raw.sandwichesss);
                initRecyclerView();



            }
        });


        //SOUP

        final MediaPlayer soupplayer= MediaPlayer.create(FOODS.this,R.raw.souppp);
        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soupplayer.start();
                globalv.addmImageUrls(R.drawable.shorba);
                globalv.addmNames(soup2);
                globalv.addMrecords(R.raw.souppp);
                initRecyclerView();



            }
        });

        //CHOCOLATE
        final MediaPlayer chocolaplayer = MediaPlayer.create(FOODS.this,R.raw.chocolateee);
        Chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chocolaplayer.start();
                globalv.addmImageUrls(R.drawable.chocolate);
                globalv.addmNames(chocolate2);
                globalv.addMrecords(R.raw.chocolateee);
                initRecyclerView();



            }
        });



        //HONEY

        final MediaPlayer honeyplayer= MediaPlayer.create(FOODS.this,R.raw.honeyyy);
        honey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                honeyplayer.start();
                globalv.addmImageUrls(R.drawable.asl);
                globalv.addmNames(honey2);
                globalv.addMrecords(R.raw.honeyyy);
                initRecyclerView();



            }
        });

        //BREAD
        final MediaPlayer breadplayer = MediaPlayer.create(FOODS.this,R.raw.breaddd);
        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                breadplayer.start();
                globalv.addmImageUrls(R.drawable.esh);
                globalv.addmNames(bread2);
                globalv.addMrecords(R.raw.breaddd);
                initRecyclerView();



            }
        });



        //chickens

        final MediaPlayer chickenplayer= MediaPlayer.create(FOODS.this,R.raw.chickennn);
        chickens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chickenplayer.start();
                globalv.addmImageUrls(R.drawable.frahk);
                globalv.addmNames(chicken2);
                globalv.addMrecords(R.raw.chickennn);
                initRecyclerView();



            }
        });

        //POPCORN
        final MediaPlayer popplayer = MediaPlayer.create(FOODS.this,R.raw.popcornnn);
        popcorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popplayer.start();
                globalv.addmImageUrls(R.drawable.fshaar);
                globalv.addmNames(popcorn2);
                globalv.addMrecords(R.raw.popcornnn);
                initRecyclerView();



            }
        });


        //MEAT

        final MediaPlayer meatplayer= MediaPlayer.create(FOODS.this,R.raw.meattt);
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meatplayer.start();
                globalv.addmImageUrls(R.drawable.meat);
                globalv.addmNames(meat2);
                globalv.addMrecords(R.raw.meattt);
                initRecyclerView();



            }
        });

        //JAM
        final MediaPlayer jamplayer = MediaPlayer.create(FOODS.this,R.raw.jammm);
        jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jamplayer.start();
                globalv.addmImageUrls(R.drawable.marba);
                globalv.addmNames(jam2);
                globalv.addMrecords(R.raw.jammm);
                initRecyclerView();



            }
        });



        //PLAY ALL


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    final MediaPlayer mediaPlay = MediaPlayer.create(FOODS.this, globalv.getMrecords().get(i));
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

                Intent intent1 = new Intent(FOODS.this,MainActivity.class);
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
    public static void CleanUpMemory(){
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        chocolate2.setText(resources.getString(R.string.chocolate));
        popcorn2.setText(resources.getString(R.string.popcorn));
        biscuit2.setText(resources.getString(R.string.biscuit));
        honey2.setText(resources.getString(R.string.honey));
        icecream2.setText(resources.getString(R.string.icecream));
        jam2.setText(resources.getString(R.string.jam));
        soup2.setText(resources.getString(R.string.soup));
        meat2.setText(resources.getString(R.string.meat));
        bread2.setText(resources.getString(R.string.bread));
        chicken2.setText(resources.getString(R.string.chicken));
        pizza2.setText(resources.getString(R.string.pizza));
        salad2.setText(resources.getString(R.string.salad));
        fish2.setText(resources.getString(R.string.fish));
        sandwich2.setText(resources.getString(R.string.sandwich));
        yogurt2.setText(resources.getString(R.string.yogurt));
        cheese2.setText(resources.getString(R.string.cheese));
        egg2.setText(resources.getString(R.string.egg));
        rice2.setText(resources.getString(R.string.rice));
        fruits2.setText(resources.getString(R.string.fruits));
        vegetables2.setText(resources.getString(R.string.vegetables));



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

