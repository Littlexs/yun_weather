package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by ASUS001 on 2017/9/5.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Test1Type {
    String value() default "";
}
