package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class UpdateCard extends AppCompatActivity {
    TextView textimage,textrecord,textname;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase,"ar"));
    }

    SQLite db;
    int id;
    Button Record, Stop, update;
    EditText editNam;
    ImageView ViewImage, Take, Choose;
    private MediaRecorder mRecorder;
    private MediaPlayer mPlayer;
    private String outputFile = null;
    ///////////////////////////////////م
    byte[] record = null;
    byte[] image = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_card);

        textimage = (TextView)findViewById(R.id.textimage);
        textname = (TextView)findViewById(R.id.textname);
        textrecord = (TextView)findViewById(R.id.textrecord);

        Paper.init(this);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");


        updateView((String)Paper.book().read("language"));


        id = getIntent().getIntExtra("id", 0);
        db = new SQLite(this);
        Card contact = db.getContactById2(id);


        Record = (Button)findViewById(R.id.recordd) ;
        Stop = (Button)findViewById(R.id.stop) ;
        update = (Button)findViewById(R.id.updata);
        editNam = (EditText)findViewById(R.id.editNam);
        ViewImage =(ImageView)findViewById(R.id.ViewImage);
        Take =(ImageView)findViewById(R.id.take);
        Choose =(ImageView)findViewById(R.id.choose);

        editNam.setText(contact.Name);

        Bitmap bitmap = BitmapFactory.decodeByteArray(contact.Image, 0, contact.Image.length);
        ViewImage.setImageBitmap(bitmap);
        image = getBytes(bitmap);

        Record.setOnClickListener(new View.OnClickListener() {
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

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);

            }
        });
        Take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeTakePhoto();

            }
        });
        Choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editNam.getText().toString();

                image = ImageView_To_Byte(ViewImage);
              //  record = FileLocal_To_Byte(outputFile);
                Card contact = new Card(id,name,image);

                db.updateContact(contact);


                Toast.makeText(UpdateCard.this, "تم التحديث بنجاح", Toast.LENGTH_LONG).show();
                finish();



            }
        });
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(UpdateCard.this,CardList.class);
                startActivity(intent1);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_delet:

                showAlert();

                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void showAlert() {

        AlertDialog.Builder alertBilder = new AlertDialog.Builder(this);
        alertBilder.setTitle("تأكيد الحذف")
                .setMessage("هل انت متأكد؟")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // delete contact
                        db.deletContact(id);
                        finish();
                    }
                })
                .setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = alertBilder.create();
        dialog.show();

    }

    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
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
        Toast.makeText(UpdateCard.this,"يبدأ التسجيل",Toast.LENGTH_SHORT).show();

    }


    public void stop(View view){
        try{
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;

            Toast.makeText(UpdateCard.this,"ايقاف التسجيل",Toast.LENGTH_SHORT).show();

        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (RuntimeException e){
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    ViewImage.setImageBitmap(bitmap);
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
//                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    //                  imageViewImage.setImageBitmap(bitmap);
                    Uri selectedImage = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        ViewImage.setImageBitmap(bitmap);
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
        textrecord.setText(resources.getString(R.string.addrecord));
        textname.setText(resources.getString(R.string.addname));
        textimage.setText(resources.getString(R.string.addimage));





    }

}
