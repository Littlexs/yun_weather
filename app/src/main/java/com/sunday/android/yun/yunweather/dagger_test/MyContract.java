package com.sunday.android.yun.yunweather.dagger_test;

/**
 * Created by ASUS001 on 2017/8/31.
 */

public interface MyContract {
    interface View{
        void show(Object o);
    }

    interface Presenter{
        void loadData(String pram);
    }
}
