package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.DialogInterface;
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
    ArrayList<Card> mangCard;
    ArrayList<byte[]> mangAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        lvCard = (ListView)findViewById(R.id.cardList);

        mangCard = new ArrayList<Card>();
        mangAudio = new ArrayList<byte[]>();


        Cursor meroCard = CREATCARD.db.GetData("SELECT * FROM GP");
        while (meroCard.moveToNext()){
            // Log.d("AAA",meroCard.getString(1));
            mangCard.add(new Card(
                    meroCard.getString(1),
                    meroCard.getBlob(2)));
            mangAudio.add(meroCard.getBlob(3));
        }

        CardAdapter adapter = new CardAdapter(
                getApplicationContext(),
                R.layout.card_item,
                mangCard
        );
        lvCard.setAdapter(adapter);

        lvCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playMp3FromByte(mangAudio.get(position));
                Toast.makeText(CardList.this, "التسجيل يعمل" ,Toast.LENGTH_SHORT).show();

               /* Toast.makeText(getApplicationContext(),
                        "التسجيل يعمل" + mangGhiChu.get(position),
                        Toast.LENGTH_LONG).show();*/
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
}
