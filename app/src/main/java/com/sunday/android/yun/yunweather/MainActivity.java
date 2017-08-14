package com.sunday.android.yun.yunweather;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 首页
* */
public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.img_more)
    ImageView imgMore;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @OnClick(R.id.img_more)
    public void onViewClicked() {

    }
}
