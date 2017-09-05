package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.Test1Activity;

import dagger.Component;

/**
 * Created by ASUS001 on 2017/9/4.
 */
@Component
public interface Test1Component {
    void inject(Test1Activity testActivity);
}
