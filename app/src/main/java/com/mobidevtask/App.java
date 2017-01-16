package com.mobidevtask;

import android.app.Application;
import android.content.Context;


public class App extends Application {

    public static final String BUILD_TIME_KEY = "BUILD_TIME";
    public static final String GIT_SHA_KEY = "GIT_SHA";

    private static Application sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return sApplication.getApplicationContext();
    }

}
