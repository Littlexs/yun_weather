package com.sunday.android.yun.yunweather.dagger_test.type_inject_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.AClass;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.BClass;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.BSetClass;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.DaggerTest1Component;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.Test1Module;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.Test1Scope;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.Test1Type;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.Test2Module;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Lazy;
import dagger.Provides;

/*
* @Module @Provides @Component
* */
public class Test1Activity extends AppCompatActivity {

    @BindView(R.id.tv1)
    TextView textView;

    @Test1Type("test1")  //标识符，防止依赖迷失
    @Inject
    AClass aClass;

    @Test1Scope  //运行时才实例化
    @Inject
    AClass scopeClass;

    @Inject
    Lazy<AClass> aClassLazy;//构造器只会调用一次，每次get（）都返回缓存中的实例

    @Inject
    Provider<AClass> aClassProvides;//每次调用get()都实例化一个，如果存在@Scope注解，那么get()不会生成新的对象

    @Inject
    Set<AClass> aClassSet;  //@IntoSet 和@ElementsIntoSet 标注的方法返回的实例都将注入到该变量中

    @Inject
    BSetClass bSetClass;    //@IntoSet 和@ElementsIntoSet 标注的方法返回的实例都将注入到该变量中

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);

        DaggerTest1Component.builder()
                .test1Module(new Test1Module(new AClass()))
                .test2Module(new Test2Module(new BClass("test b")))
                .build()
                .inject(this);

        //textView.setText(scopeClass.getStr1()+"  "+aClass.getStr1()+"   "+aClassLazy.get().getStr2()+"  "+aClassProvides.get().getStr1());

        //textView.setText(aClassSet+"");

        //textView.setText(bSetClass.bClassSet+"");
    }
}
