package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rehabilitationtoolgp.rehabilitationtool.Helper.LocalHelper;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.paperdb.Paper;


public class CREATCARD extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }
    Button  btnRecord, btnStop, Save, ShowCards;
    EditText editName;
    ImageView imageViewImage, TakePhoto, ChoosePhoto;
    TextView imagee,recordd,nam;


    public static SQLite db;
    private MediaRecorder mRecorder;
    private MediaPlayer mPlayer;
    private String outputFile = null;
    ///////////////////////////////////م
    byte[] record = null;
    byte[] image = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatcard);
        initiateView();
        db = new SQLite(CREATCARD.this);
        imagee = (TextView)findViewById(R.id.image);
        recordd = (TextView)findViewById(R.id.record);
        nam = (TextView)findViewById(R.id.nam);
        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        // db.QueryData("CREATE TABLE IF NOT EXISTS GP(id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR, Image BLOB, Record BLOB)");

        //TAKE PHOTO
        TakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeTakePhoto();
            }
        });
        //SELECT PHOTO
        ChoosePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        //RECORD AUDIO
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/marium.3gpp";
                mRecorder = new MediaRecorder();
                mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
                mRecorder.setOutputFile(outputFile);

                start(v);
            }
        });

        //STOP AUDIO
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);
            }
        });

        //SAVE DATA
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editName.getText().toString();
                image = ImageView_To_Byte(imageViewImage);
                record = FileLocal_To_Byte(outputFile);
                Card contact = new Card(name,  image);

                db.addContact(contact,record);

                  ResetCard();

                Toast.makeText(CREATCARD.this,"تم الحفظ",Toast.LENGTH_LONG).show();
            }
        });

        ShowCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CardList.class);
                startActivity(intent);

            }
        });

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(CREATCARD.this,Main2Activity.class);
                startActivity(intent1);
            }
        });



    }
     public void initiateView(){
        TakePhoto = (ImageView)findViewById(R.id.take);
        ChoosePhoto = (ImageView)findViewById(R.id.choose);
        btnRecord = (Button)findViewById(R.id.btnrecord);
        btnStop = (Button)findViewById(R.id.btnstop);
        Save = (Button)findViewById(R.id.updata);
        ShowCards = (Button)findViewById(R.id.display);
        editName = (EditText)findViewById(R.id.editNam);
        imageViewImage = (ImageView)findViewById(R.id.ViewImage);
     }



    public void start(View view){
        try{
            mRecorder.prepare();
            mRecorder.start();

        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        Toast.makeText(CREATCARD.this,"يبدأ التسجيل",Toast.LENGTH_SHORT).show();

    }


    public void stop(View view){
        try{
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;

            Toast.makeText(CREATCARD.this,"ايقاف التسجيل",Toast.LENGTH_SHORT).show();

        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public void play(View view){
        try {
            mPlayer = new MediaPlayer();
            mPlayer.setDataSource(outputFile);
            mPlayer.prepare();
            mPlayer.start();

            Toast.makeText(CREATCARD.this,"تشغيل التسجيل",Toast.LENGTH_SHORT).show();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public byte[] FileLocal_To_Byte(String path){
        File file = new File(path);
        int size = (int) file.length();
        byte [] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes,0,bytes.length);
            buf.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }
        return bytes;
    }

    public void activeTakePhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            startActivityForResult(takePictureIntent, 1);
        }


    }


    public void selectImage(){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 2);
    }
    public void ResetCard(){
        imageViewImage.setImageResource(R.drawable.card);
        editName.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    imageViewImage.setImageBitmap(bitmap);
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
//                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
  //                  imageViewImage.setImageBitmap(bitmap);
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        imageViewImage.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
        }

            super.onActivityResult(requestCode, resultCode, data);

    }

    public byte [] ImageView_To_Byte(ImageView Image){
        //  Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.);
        BitmapDrawable drawable = (BitmapDrawable) Image.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }

    private void updateView(String lang) {
        Context context = LocalHelper.setLocale(this,lang);
        Resources resources = context.getResources();
        imagee.setText(resources.getString(R.string.addimage));
        recordd.setText(resources.getString(R.string.addrecord));
        nam.setText(resources.getString(R.string.addname));




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

