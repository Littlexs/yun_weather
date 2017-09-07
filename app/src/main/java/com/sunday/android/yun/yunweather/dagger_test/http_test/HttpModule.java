package com.sunday.android.yun.yunweather.dagger_test.http_test;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sunday.android.yun.yunweather.http.Api;
import com.sunday.android.yun.yunweather.http.converter.FastJsonConverterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by ASUS001 on 2017/9/7.
 */

@Module
public class HttpModule {

    private static String BASE_URL = "https://free-api.heweather.com/";//和风天气API ： https://www.heweather.com/
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

    @Singleton
    @Provides
    public OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(interceptor)
                .build();
        return mOkHttpClient;
    }

    @Singleton
    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    public Api getApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }
}
