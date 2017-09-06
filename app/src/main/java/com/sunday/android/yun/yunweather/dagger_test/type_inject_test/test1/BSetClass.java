package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import java.util.Set;

import javax.inject.Inject;

/**
 * Created by ASUS001 on 2017/9/6.
 */

public class BSetClass {

    public Set<BClass> bClassSet;

    @Inject
    public BSetClass(Set<BClass> bClassSet){
        this.bClassSet = bClassSet;
    }

    @Override
    public String toString() {
        return bClassSet+"";
    }
}
