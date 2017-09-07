package com.sunday.android.yun.yunweather.dagger_test.http_test;

import dagger.Component;

/**
 * Created by ASUS001 on 2017/9/7.
 */
@ActivityScoped
@Component(modules = ActivityTest1Module.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(HttpTest1Activity activity);
}
