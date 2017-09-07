package com.sunday.android.yun.yunweather.dagger_test.http_test;

import com.sunday.android.yun.yunweather.dagger_test.MyContract;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.BClass;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ASUS001 on 2017/9/7.
 */
@ActivityScoped
@Module
public class ActivityTest1Module {
    private BClass activity;

    public ActivityTest1Module(BClass activity) {
        this.activity = activity;
    }

    @Provides
    public BClass provideActivity() {
        return activity;
    }
}
