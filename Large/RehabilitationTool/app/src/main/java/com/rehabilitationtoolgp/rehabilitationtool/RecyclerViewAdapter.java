package com.rehabilitationtoolgp.rehabilitationtool;


import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import io.paperdb.Paper;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
   private TextToSpeech textToSpeech;

    //vars
    private ArrayList<Object> mNames = new ArrayList<>();
    private ArrayList<Object> mImageUrls = new ArrayList<>();
    private ArrayList<Object> mrecords = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Object> names, ArrayList<Object> imageUrls, ArrayList<Object> records) {
        mNames = names;
        mImageUrls = imageUrls;
        mrecords = records;

        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        textToSpeech = new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
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
                }
            }
        });
        Paper.init(mContext);

        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","ar");

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        //IMAGES
        if (mImageUrls.get(position) instanceof Integer) {
            // The Object is an instance of a String
            Integer i = (Integer) mImageUrls.get(position);

            Picasso.with(mContext)
                    .load(i)
                    .into(holder.image);
        }
        else if (mImageUrls.get(position) instanceof Bitmap) {
            // The Object is an instance of a Double
            Bitmap g = (Bitmap) mImageUrls.get(position);
            holder.image.setImageBitmap(g);
        }

        //NAMES
        if (mNames.get(position) instanceof TextView) {
            // The Object is an instance of a String
            TextView i = (TextView) mNames.get(position);
            holder.name.setText(( i.getText().toString()));

        }
        else if (mNames.get(position) instanceof String) {
            // The Object is an instance of a Double
            String g = (String) mNames.get(position);
            holder.name.setText(g);
        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image: " + mNames.get(position) + mrecords.get(position));
//                Toast.makeText(mContext, (CharSequence) mNames.get(position), Toast.LENGTH_SHORT).show();
                Paper.init(mContext);

                String language = Paper.book().read("language");
                if(language == null)
                    Paper.book().write("language","ar");


                if (mNames.get(position) instanceof TextView) {
                    // The Object is an instance of a String
                    TextView M = (TextView) mNames.get(position);

                    int x =1;
                    switch (x){

                        case 1 :if (mrecords.get(position) instanceof Integer &&  Locale.getDefault().getLanguage().equals("en"));
                        {
                            Integer i = (Integer)mrecords.get(position);

                            String data = (String)M.getText().toString();
                            int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);}

                        case 2 :if (mrecords.get(position) instanceof Integer&& Locale.getDefault().getLanguage().equals("ar")){
                            Integer i = (Integer)mrecords.get(position);
                            MediaPlayer mediaPlayer=MediaPlayer.create(view.getContext(),i);
                            mediaPlayer.start();
                        }}

                }
                else if (mNames.get(position) instanceof String) {
                    // The Object is an instance of a Double
                    byte[] g = (byte[]) mrecords.get(position);
                    playMp3FromByte(g);
                }















                   // String data = (String)mNames.get(position).toString();
                    //int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                //}



            }
        });
        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // remove poistion from image larray
                mImageUrls.remove(mImageUrls.get(position));


                //remove poistion from records array
                mrecords.remove(mrecords.get(position));

                //removepoistion from names array
                mNames.remove(mNames.get(position));

                // remove poistion from adapter and noitfay it
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,mImageUrls.size());



            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        public ImageButton mRemoveButton;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
            mRemoveButton=itemView.findViewById(R.id.remove);


        }
    }
    private void playMp3FromByte(byte[] mp3SoundByteArray) {
        try {
            File tempMp3 = File.createTempFile("kurchina", "mp3", mContext.getCacheDir());
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

}

