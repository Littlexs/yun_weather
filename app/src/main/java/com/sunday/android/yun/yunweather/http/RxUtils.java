package com.sunday.android.yun.yunweather.http;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by yun_sheng on 2017/8/7.
 */

public class RxUtils {
    public static <T> ObservableTransformer<T, T> schedulerTransformer(final Scheduler scheduler) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(scheduler)
                        .observeOn(AndroidSchedulers.mainThread(), true);
            }
        };
    }
}
