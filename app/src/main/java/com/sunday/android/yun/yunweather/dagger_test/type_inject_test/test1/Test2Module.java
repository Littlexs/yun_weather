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
public class Test2Module {
    private BClass bClass;          //测试类
    public Test2Module(BClass bClass){
        this.bClass = bClass;
    }

    @Test1Type("test1")
    @Provides
    public BClass getBClass(){
        return this.bClass;
    }

    @Test1Type("test2")
    @Provides
    public BClass getBClass2(){
        return this.bClass;
    }

    @Provides
    @IntoSet        //注入单个实例到set
    public BClass getB1(){
        return new BClass("b1");
    }

    @Provides
    @ElementsIntoSet   //将子Set<T>注入到Set
    public Set<BClass> getBSet(){
        Set<BClass> bClasses = new HashSet<>();
        bClasses.add(new BClass("set b1"));
        bClasses.add(new BClass("set b2"));
        return bClasses;
    }
}
