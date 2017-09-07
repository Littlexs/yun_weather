package com.sunday.android.yun.yunweather.dagger_test.http_test;


import com.sunday.android.yun.yunweather.BaseApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ASUS001 on 2017/9/7.
 */

@Module
public class AppModule {

    private BaseApp baseApp;

    public AppModule(BaseApp baseApp){
        this.baseApp = baseApp;
    }

    @Singleton
    @Provides
    BaseApp getBaseApp(){
        return this.baseApp;
    }

}
