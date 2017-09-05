package com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ASUS001 on 2017/9/5.
 *
 * @Scope 为作用域
 *
 * 在注入实例时，是控制注入器调用缓存的实例还是重新实例
 *类被@Scope注解，那么其Component必须被相同的Scope注解
 *
 * @Singleton是@Scope的一个特例，或者是说是@Scope的一种实现方式。
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Test1Scope {
}
