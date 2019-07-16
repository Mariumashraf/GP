package com.rehabilitationtoolgp.rehabilitationtool;

import android.app.Application;
import android.content.Context;

import com.rehabilitationtoolgp.rehabilitationtool.Helper.LocalHelper;

/**
 * Created by lenovo on 6/29/2019.
 */
public class MainApplication extends Application {
    //press ctrl+o
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocalHelper.onAttach(base,"ar"));
    }
}
