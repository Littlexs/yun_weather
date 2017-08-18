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
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CityManageActivity extends BaseActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.imgRight)
    ImageView imgRight;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.imgAddCity)
    ImageView imgAddCity;

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

    @Override
    public void loadData() {

    }

    @OnClick({R.id.imgBack, R.id.imgAddCity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgAddCity:

                break;
        }
    }
}
