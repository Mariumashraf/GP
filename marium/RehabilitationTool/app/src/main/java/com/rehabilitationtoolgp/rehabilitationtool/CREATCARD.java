package com.rehabilitationtoolgp.rehabilitationtool;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class CREATCARD extends AppCompatActivity {
Button btnRecord , btnStopRecord, btnPlay,btnStop;
String pathsave="";
MediaRecorder mediaRecorder;
MediaPlayer mediaPlayer;
final int REQUEST_PERMISSION_CODE=1000;
Button insert;
EditText number;
DataBaseHandler db;
private static  final int PICK_IMAGE=1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatcard);
    insert=(Button)findViewById(R.id.insert);
    number=(EditText)findViewById(R.id.number);
    db = new DataBaseHandler(this);

    insert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(Intent.ACTION_PICK, Uri.parse("content://media/internal/images/media"));
            startActivityForResult(intent,PICK_IMAGE);

        }
    });



        if (!checkpermissionForDevice())
            requestPermission();

        btnPlay= (Button)findViewById(R.id.btnPlay);
       btnRecord= (Button)findViewById(R.id.btnStartRecord);
        btnStop= (Button)findViewById(R.id.btnStop);
        btnStopRecord= (Button)findViewById(R.id.btnStopRecord);




            btnRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkpermissionForDevice()) {
                        pathsave = Environment.getExternalStorageDirectory()
                                .getAbsolutePath() + "/"
                                + UUID.randomUUID().toString() + "_audio_record.3gp";
                        setupMediaRecorder();
                        try {
                            mediaRecorder.prepare();
                            mediaRecorder.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        btnPlay.setEnabled(false);
                        btnStop.setEnabled(false);
                        Toast.makeText(CREATCARD.this, "Recording.....", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        requestPermission();
                    }

                }
            });
              btnStopRecord.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      mediaRecorder.stop();
                      btnStopRecord.setEnabled(false);
                      btnPlay.setEnabled(true);
                      btnRecord.setEnabled(true);
                      btnStop.setEnabled(false);
                  }
              });
              btnPlay.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      btnStop.setEnabled(true);
                      btnStopRecord.setEnabled(false);
                      btnRecord.setEnabled(false);

                      mediaPlayer = new MediaPlayer();
                      try{
                          mediaPlayer.setDataSource(pathsave);
                          mediaPlayer.prepare();
                      }catch (IOException e){
                          e.printStackTrace();
                      }
                     mediaPlayer.start();
                      Toast.makeText(CREATCARD.this,"playing.....",Toast.LENGTH_SHORT).show();


                  }
              });
              btnStop.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      btnStopRecord.setEnabled(false);
                      btnRecord.setEnabled(true);
                      btnStop.setEnabled(false);
                      btnPlay.setEnabled(true);
                      if(mediaPlayer!=null){
                          mediaPlayer.stop();
                          mediaPlayer.release();
                          setupMediaRecorder();
                      }

                  }
              });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode == RESULT_OK && requestCode==PICK_IMAGE){
            Uri uri = data.getData();
            String x = getPath(uri);
            Integer num = Integer.parseInt(number.getText().toString());
            if (db.insertImage(x,num)){
                Toast.makeText(getApplicationContext(),"Succesfull",Toast.LENGTH_SHORT).show();

            }
            else {
                Toast.makeText(getApplicationContext(),"Not Succesfull",Toast.LENGTH_SHORT).show();
            }
        }
    }
     public String getPath(Uri uri){
        if (uri==null)return null;
        String[] projection={MediaStore.Images.Media.DATA};
         Cursor cursor=managedQuery(uri,projection,null,null,null);
         if (cursor!=null){
             int column_index=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
             cursor.moveToFirst();
             return cursor.getString(column_index);
         }
             return  uri.getPath();
     }


    private void setupMediaRecorder() {
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(pathsave);
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, REQUEST_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        { case REQUEST_PERMISSION_CODE:
        if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            Toast.makeText(this,"permission Granted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"permission Denied",Toast.LENGTH_SHORT).show();
            break;
        }


    }


    private boolean checkpermissionForDevice(){
        int write_external_storage_result= ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_aduio_result=ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO);
        return write_external_storage_result== PackageManager.PERMISSION_GRANTED&&record_aduio_result==PackageManager.PERMISSION_GRANTED;
    }


}
