package com.sunday.android.yun.yunweather.dagger_test.http_test;

import com.sunday.android.yun.yunweather.BaseApp;
import com.sunday.android.yun.yunweather.http.Api;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by ASUS001 on 2017/9/7.
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    BaseApp getBaseApp();
    Retrofit getRetrofit();
    OkHttpClient getHttpClient();
    Api getApi();

}
