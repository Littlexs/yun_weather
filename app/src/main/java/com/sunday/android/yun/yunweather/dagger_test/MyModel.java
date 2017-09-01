package com.sunday.android.yun.yunweather.dagger_test;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ASUS001 on 2017/8/31.
 */
@Module
public class MyModel {
    MyContract.View view;
    public MyModel(MyContract.View view){
        this.view = view;
    }

    @Provides
    public MyContract.View myView(){
        return view;
    }
}
