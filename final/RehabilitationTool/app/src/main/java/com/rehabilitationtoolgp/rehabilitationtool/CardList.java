package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class CardList extends AppCompatActivity {

    ListView lvCard;
    SQLite db;
    Globalrecycler globalv;
    private static final String TAG = "CardList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        db = new SQLite(this);
        Button back = (Button) findViewById(R.id.back);
        ImageButton play = (ImageButton) findViewById(R.id.playall);
        globalv=(Globalrecycler)getApplicationContext();
        initRecyclerView();

        lvCard = (ListView)findViewById(R.id.cardList);
        lvCard.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Card selected_contact = (Card) parent.getItemAtPosition(position);

                Intent intent = new Intent(CardList.this, UpdateCard.class);

                intent.putExtra("id", selected_contact.Id);

                startActivity(intent);
                return false;
            }
        });
        lvCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<byte[]> audios = db.getaudio();

                playMp3FromByte(audios.get(position));
               // Toast.makeText(CardList.this, "التسجيل يعمل" ,Toast.LENGTH_SHORT).show();
                ArrayList<Card> contacts = db.getAllContacts();
                Bitmap bitmap = BitmapFactory.decodeByteArray(contacts.get(position).Image, 0, contacts.get(position).Image.length);
                globalv.addmImageUrls(bitmap );
                globalv.addmNames(contacts.get(position).Name);

                globalv.addMrecords(audios.get(position));
                initRecyclerView();

            }
        });



//BACK
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalv.getmImageUrls();
                globalv.getmNames();
                globalv.getMrecords();

                Intent intent1 = new Intent(CardList.this,Main2Activity.class);
                startActivity(intent1);
            }
        });



        //PLAY ALL
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<  globalv.getMrecords().size();i++) {
                    /*final MediaPlayer mediaPlay = MediaPlayer.create(MainActivity.this, globalv.getMrecords().get(i));
                    mediaPlay.start();*/

                    if (globalv.getMrecords().get(i) instanceof Integer) {
                        // The Object is an instance of a String
                        Integer M = (Integer) globalv.getMrecords().get(i);

                        MediaPlayer mediaPlayer=MediaPlayer.create(view.getContext(),M);
                        mediaPlayer.start();
                    }
                    else if (globalv.getMrecords().get(i) instanceof byte[]) {
                        // The Object is an instance of a Double
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
   /* public void onClick(DialogInterface dialog, int id)
    {
        myDB = new SQLite(getContext());
        myDB.deleteItem(user.getBillID());
        users.remove(position);
        notifyDataSetChanged();

    }*/
   @Override
   protected void onResume() {
       super.onResume();


       ArrayList<Card> contacts = db.getAllContacts();


       CardAdapter contactAdapter = new CardAdapter(this, R.layout.card_item, contacts);

       lvCard.setAdapter(contactAdapter);
   }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,  globalv.getmNames(), globalv.getmImageUrls(),globalv.getMrecords());
        recyclerView.setAdapter(adapter);
    }
}
