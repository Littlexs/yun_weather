package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ASUS001 on 2017/9/5.
 */

@Module
public class Test1Module {
    private AClass aClass;//测试类
    public Test1Module(AClass aClass){
        this.aClass = aClass;
    }

    @Test1Type("test1")
    @Provides
    public AClass getAClass(){
        return this.aClass;
    }

    @Test1Type("test2")
    @Provides
    public AClass getAClass2(){
        return this.aClass;
    }
}
