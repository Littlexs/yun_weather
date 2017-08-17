package com.sunday.android.yun.yunweather.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sunday.android.yun.yunweather.http.converter.FastJsonConverterFactory;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by yun_sheng on 2017/8/2.
 */

public class ApiClient {

    private static String BASE_URL = "https://free-api.heweather.com/";//和风天气API ： https://www.heweather.com/
    public static String ICON_URL = "https://cdn.heweather.com/cond_icon/";
    public Api api;
    private static Retrofit mApi = null;
    private static OkHttpClient mOkHttpClient;
    public static String APP_KEY = "f451fc1ac7fa4ac39a2730fcc362e7b3";//和风天气key
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

    static {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (ApiClient.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(10, TimeUnit.SECONDS)
                            .addInterceptor(loggingInterceptor)
                            .addInterceptor(interceptor)
                            .build();
                }
            }
        }
    }

    public static Api create() {
        mApi = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return mApi.create(Api.class);
    }

    public static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }
        return ssfFactory;
    }

    static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {}

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
    }

}
