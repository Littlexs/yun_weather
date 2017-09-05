package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import javax.inject.Inject;

/**
 * Created by ASUS001 on 2017/9/1.
 */

public class AClass {

    private String str1;
    private String str2;

    @Inject
    public AClass() {
        this.str1 = "str1";
        this.str2 = "str2";
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}
