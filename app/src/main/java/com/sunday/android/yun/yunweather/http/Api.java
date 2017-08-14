package com.sunday.android.yun.yunweather.http;


import com.sunday.android.yun.yunweather.entity.Weather;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yun_sheng on 2017/8/2.
 */

public interface Api {

    @GET("/v5/weather")
    Observable<Weather> getMainInfo(@Query("city") String city, @Query("key") String key);

}
