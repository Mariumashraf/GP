package com.rehabilitationtoolgp.rehabilitationtool;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


public class CREATCARD extends AppCompatActivity {
    Button  btnRecord, btnStop, Save, ShowCards;
    EditText editName;
    ImageView imageViewImage, TakePhoto, ChoosePhoto;
    int REQUEST_CODE = 124;
    int REQUEST_CODE2 = 125;

    private Bitmap bp;
    public static SQLite db;
    private MediaRecorder mRecorder;
    private MediaPlayer mPlayer;
    private String outputFile = null;
    ///////////////////////////////////م
    byte[] record = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatcard);
        initiateView();

        db = new SQLite(CREATCARD.this,"Cards.sqlite",null,1);
        db.QueryData("CREATE TABLE IF NOT EXISTS GP(id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR, Image BLOB, Record BLOB)");

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
                //play(v);

                String name = editName.getText().toString();
                db.INSERT_GP(
                        name,
                        ImageView_To_Byte(imageViewImage),
                        FileLocal_To_Byte(outputFile)
                );
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



     }
     public void initiateView(){
        TakePhoto = (ImageView)findViewById(R.id.takephoto);
        ChoosePhoto = (ImageView)findViewById(R.id.pic);
        btnRecord = (Button)findViewById(R.id.btnrecord);
        btnStop = (Button)findViewById(R.id.btnstop);
        Save = (Button)findViewById(R.id.save);
        ShowCards = (Button)findViewById(R.id.display);
        editName = (EditText)findViewById(R.id.editName);
        imageViewImage = (ImageView)findViewById(R.id.imageViewImage);
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







}

