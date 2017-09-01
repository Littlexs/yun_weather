package com.sunday.android.yun.yunweather.dagger_test;

import dagger.Component;

/**
 * Created by ASUS001 on 2017/8/31.
 */
@Component(modules = MyModel.class)
public interface MyComponent {
    void inject(TestActivity activity);
}
