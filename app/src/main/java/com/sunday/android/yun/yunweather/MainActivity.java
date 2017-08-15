package com.sunday.android.yun.yunweather;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.adapter.IndexAdapter;
import com.sunday.android.yun.yunweather.common.BaseActivity;
import com.sunday.android.yun.yunweather.entity.Weather;
import com.sunday.android.yun.yunweather.utils.StatusBarUtil;
import com.sunday.android.yun.yunweather.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

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

    private IndexAdapter indexAdapter;
    private LinearLayoutManager layoutManager;
    private Weather weather;
    private List<Weather.HeWeather5Bean> weather5BeanList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        indexAdapter = new IndexAdapter(mContext,weather5BeanList);
        recyclerView.setAdapter(indexAdapter);
    }

    @OnClick(R.id.img_more)
    public void onViewClicked() {
        ToastUtils.showToast(getApplicationContext(),"more");
    }
}
