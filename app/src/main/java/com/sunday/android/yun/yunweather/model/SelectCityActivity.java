package com.sunday.android.yun.yunweather.model;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.common.BaseActivity;
import com.sunday.android.yun.yunweather.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectCityActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_city_select;
    }

    @Override
    public void initToolBar() {
        StatusBarUtil.StatusBarLightMode(SelectCityActivity.this);
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

}
