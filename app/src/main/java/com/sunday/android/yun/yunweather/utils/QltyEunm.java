package com.sunday.android.yun.yunweather.utils;

import com.sunday.android.yun.yunweather.R;

/**
 * Created by yun_sheng on 2017/8/17.
 * 空气质量
 */

public enum QltyEunm {
    //优，良，轻度污染，中度污染，重度污染，严重污染
    NICE("优", R.drawable.ic_nice_sky);


    private String name;
    private int index;
    private QltyEunm(String name,int i){
        this.name = name;
        this.index = i;
    }
    @Override
    public String toString() {
        return this.index+"--"+this.name;
    }
}
