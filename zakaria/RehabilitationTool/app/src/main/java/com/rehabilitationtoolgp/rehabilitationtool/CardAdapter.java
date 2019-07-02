package com.rehabilitationtoolgp.rehabilitationtool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends ArrayAdapter<Card> {

    Context context;
    int resource;

    public CardAdapter(@NonNull Context context, int resource, @NonNull List<Card> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, parent, false  );
        Card currentContact = getItem(position);


        TextView name = (TextView)convertView.findViewById(R.id.tvName);
        ImageView image = (ImageView)convertView.findViewById(R.id.tvView);
        name.setText(currentContact.Name);
        Bitmap bitmap = BitmapFactory.decodeByteArray(currentContact.Image, 0, currentContact.Image.length);
        image.setImageBitmap(bitmap);






        return convertView;
    }


}
