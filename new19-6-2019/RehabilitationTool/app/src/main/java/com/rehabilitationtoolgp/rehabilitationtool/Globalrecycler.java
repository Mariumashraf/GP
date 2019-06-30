package com.rehabilitationtoolgp.rehabilitationtool;


import android.app.Application;


import java.util.ArrayList;

public class Globalrecycler extends Application {
    private static final String TAG = "Globalrecycler";
    private  ArrayList<String> mNames = new ArrayList<>();
    private  ArrayList<Object> mImageUrls = new ArrayList<>();
    private ArrayList<Object> mrecords = new ArrayList<>();


    public static String getTAG() {
        return TAG;
    }

    public ArrayList<String> getmNames() {
        return mNames;
    }

    public void setmNames(ArrayList<String> mNames) {
        this.mNames = mNames;
    }
    public void addmNames(String mNames) {
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

