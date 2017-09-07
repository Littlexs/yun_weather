package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.Test1Activity;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by ASUS001 on 2017/9/7.
 */
@Subcomponent(modules = Test2Module.class)
public interface ChildTest1Component {

    void inject(Test1Activity test1Activity);

    @Subcomponent.Builder
    interface ChildBuilder{
        ChildBuilder childBuilder(Test2Module test2Module);
        ChildTest1Component build();
    }
}
