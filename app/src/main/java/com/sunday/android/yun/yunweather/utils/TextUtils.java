package com.sunday.android.yun.yunweather.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by yun_sheng on 2017/8/15.
 */

public class TextUtils {

    private static AssetManager getAssetManager(Context context){
        AssetManager assetManager = null;
        if (assetManager==null){
            assetManager = context.getAssets();
        }
        return assetManager;
    }

    public static void setTypeface(Context context, TextView textView,String path){
        AssetManager assetManager = getAssetManager(context);
        textView.setTypeface(Typeface.createFromAsset(assetManager, path));
    }
}
