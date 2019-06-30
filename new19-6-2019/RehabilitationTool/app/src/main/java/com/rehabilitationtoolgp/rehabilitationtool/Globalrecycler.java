package com.rehabilitationtoolgp.rehabilitationtool;


import android.app.Application;
import android.widget.TextView;


import java.util.ArrayList;

public class Globalrecycler extends Application {
    private static final String TAG = "Globalrecycler";
<<<<<<< HEAD
    private ArrayList<TextView> mNames = new ArrayList<TextView>();
    private  ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<Integer> mrecords = new ArrayList<>();
=======
    private  ArrayList<String> mNames = new ArrayList<>();
    private  ArrayList<Object> mImageUrls = new ArrayList<>();
    private ArrayList<Object> mrecords = new ArrayList<>();
>>>>>>> f0cf9b186c6d0b3f8063256bd9283c5b02504fb2


    public static String getTAG() {
        return TAG;
    }

    public ArrayList<TextView> getmNames() {
        return mNames;
    }

    public void setmNames(ArrayList<TextView> mNames) {
        this.mNames = mNames;
    }
    public void addmNames(TextView mNames) {
        this.mNames.add(mNames);
    }

    public ArrayList<Object> getmImageUrls() {
        return mImageUrls;
    }

    public void setmImageUrls(ArrayList<Object> mImageUrls) {
        this.mImageUrls = mImageUrls;
    }
    public void addmImageUrls(Object mImageUrls) {
        this.mImageUrls.add(mImageUrls);
    }

    public ArrayList<Object> getMrecords() {
        return mrecords;
    }

    public void setMrecords(ArrayList<Object> mrecords) {
        this.mrecords = mrecords;
    }
    public void addMrecords(Object mrecords) {
        this.mrecords.add(mrecords);
    }


}

