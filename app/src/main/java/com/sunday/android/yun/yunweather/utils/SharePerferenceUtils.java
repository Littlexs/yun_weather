package com.sunday.android.yun.yunweather.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;


/**
 *
 */
public class SharePerferenceUtils {
    private volatile  static SharePerferenceUtils instance;
    private SharedPreferences mSharedPreferences;


    private SharePerferenceUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences("sunday",
                Activity.MODE_PRIVATE);
    }

    public synchronized static SharePerferenceUtils getIns(Context context) {
        if (null == instance) {
            instance = new SharePerferenceUtils(context);
        }

        return instance;
    }

    public void putBoolean(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public void putInt(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).commit();
    }

    public int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    public void putString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).commit();
    }

    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public void putLong(String key, long value) {
        mSharedPreferences.edit().putLong(key, value).commit();
    }

    public long getLong(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

    public void removeKey(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }


    public void saveOAuth(Object object){
        if(object != null){
            String memberString = JSON.toJSONString(object);
            instance.putString("oAuth" ,memberString);
        }
    }

    public String getOAuth(){
        String memberString = instance.getString("oAuth", "");
        if(!TextUtils.isEmpty(memberString)){
            try {
                return memberString;
            }catch (Exception e){
               return null;
            }
        }
        return null;
    }


}
