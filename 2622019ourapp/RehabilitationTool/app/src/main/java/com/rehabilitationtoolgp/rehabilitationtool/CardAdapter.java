package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends BaseAdapter {

    Context myContext;
    int myLayout;
    List<Card> arrayCard;

    public CardAdapter(Context myContext, int myLayout, List<Card> arrayCard) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayCard = arrayCard;
    }

    @Override
    public int getCount() {
        return arrayCard.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout,null);

        TextView name = (TextView)convertView.findViewById(R.id.tvName);
        name.setText(arrayCard.get(position).Name);

        ImageView image = (ImageView)convertView.findViewById(R.id.tvView);
        byte [] cardImage = arrayCard.get(position).Image;

        Bitmap bitmap = BitmapFactory.decodeByteArray (cardImage, 0, cardImage.length);
        image.setImageBitmap (bitmap);
    //    image.setImageBitmap(convertToBitmap(arrayCard.get(position).Image));



        return convertView;
    }

    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }
}
