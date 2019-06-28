package com.rehabilitationtoolgp.rehabilitationtool;


import android.app.Application;


import java.util.ArrayList;

public class Globalrecycler extends Application {
    private static final String TAG = "Globalrecycler";
    private  ArrayList<String> mNames = new ArrayList<>();
    private  ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<Integer> mrecords = new ArrayList<>();


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

    public ArrayList<Integer> getmImageUrls() {
        return mImageUrls;
    }

    public void setmImageUrls(ArrayList<Integer> mImageUrls) {
        this.mImageUrls = mImageUrls;
    }
    public void addmImageUrls(Integer mImageUrls) {
        this.mImageUrls.add(mImageUrls);
    }

    public ArrayList<Integer> getMrecords() {
        return mrecords;
    }

    public void setMrecords(ArrayList<Integer> mrecords) {
        this.mrecords = mrecords;
    }
    public void addMrecords(Integer mrecords) {
        this.mrecords.add(mrecords);
    }


}

