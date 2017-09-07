package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ASUS001 on 2017/9/7.
 */
@Component(modules = Test1Module.class)
public interface ParentTest1Component {

    ChildTest1Component.ChildBuilder childTest1Component();

}
