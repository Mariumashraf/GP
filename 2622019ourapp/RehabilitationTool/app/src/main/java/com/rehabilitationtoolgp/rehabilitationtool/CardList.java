package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        db = new SQLite(this);


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
}
