package com.sunday.android.yun.yunweather.model;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.common.BaseActivity;
import com.sunday.android.yun.yunweather.utils.StatusBarUtil;

public class CityManageActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_city_manage;
    }

    @Override
    public void initToolBar() {
        StatusBarUtil.StatusBarLightMode(CityManageActivity.this);
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }
}
