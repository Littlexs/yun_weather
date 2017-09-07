package com.sunday.android.yun.yunweather.dagger_test.leak_test;

import android.content.Context;
import android.util.Log;

public class LoginManager {
    private static LoginManager mInstance;
    private Context mContext;

    private LoginManager(Context context) {
        this.mContext = context;
    }


    public static LoginManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (LoginManager.class) {
                if (mInstance == null) {
                    mInstance = new LoginManager(context);
                }
            }
        }
        return mInstance;
    }

    public void dealData() {
        Log.i("----","  leak test");
    }

}