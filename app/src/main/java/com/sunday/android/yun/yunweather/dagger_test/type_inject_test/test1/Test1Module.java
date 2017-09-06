package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;

/**
 * Created by ASUS001 on 2017/9/5.
 */

@Module
public class Test1Module {
    private AClass aClass;          //测试类
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

    @Provides
    @IntoSet  //注入单个实例到set
    public AClass getA1(){
        return new AClass();
    }

    @Provides
    @ElementsIntoSet    //将子Set<T>注入到Set
    public Set<AClass> getASet(){
        Set<AClass> aClasses = new HashSet<>();
        aClasses.add(new AClass());
        aClasses.add(new AClass());
        return aClasses;
    }
}
