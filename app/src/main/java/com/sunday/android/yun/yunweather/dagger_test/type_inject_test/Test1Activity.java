package com.sunday.android.yun.yunweather.dagger_test.type_inject_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.AClass;
import com.sunday.android.yun.yunweather.dagger_test.type_inject_test.test1.DaggerTest1Component;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* @Module @Provides @Component
* */
public class Test1Activity extends AppCompatActivity {

    @BindView(R.id.tv1)
    TextView textView;

    @Inject
    AClass aClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);

        DaggerTest1Component.builder().build().inject(this);
        textView.setText(aClass.getStr1());
    }
}
