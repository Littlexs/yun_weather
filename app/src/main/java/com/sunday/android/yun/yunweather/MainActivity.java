package com.sunday.android.yun.yunweather;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.adapter.IndexAdapter;
import com.sunday.android.yun.yunweather.common.BaseActivity;
import com.sunday.android.yun.yunweather.entity.Weather;
import com.sunday.android.yun.yunweather.http.ApiClient;
import com.sunday.android.yun.yunweather.http.RxUtils;
import com.sunday.android.yun.yunweather.utils.DeviceUtils;
import com.sunday.android.yun.yunweather.utils.StatusBarUtil;
import com.sunday.android.yun.yunweather.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
    @BindView(R.id.rBar)
    RelativeLayout relativeLayout;

    private IndexAdapter indexAdapter;
    private LinearLayoutManager layoutManager;
    private Weather weather;
    private List<Weather.HeWeather5Bean> weather5BeanList = new ArrayList<>();
    private String NET_OK = "ok";

    private int w, colorAccent, colorTrans;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initToolBar() {
        w = DeviceUtils.getDisplay(mContext).widthPixels;
        colorAccent = Color.parseColor("#71c5ec");
        colorTrans = Color.TRANSPARENT;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.setMargins(0, StatusBarUtil.getStatusBarHeight(getApplicationContext()), 0, 0);
        relativeLayout.setBackgroundColor(colorAccent);
        layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        indexAdapter = new IndexAdapter(getApplicationContext(), weather5BeanList);
        recyclerView.setAdapter(indexAdapter);
        recyclerView.addOnScrollListener(onScrollListener);
        refreshLayout.setOnRefreshListener(()->loadData());
    }

    public void loadData() {
        ApiClient.create().getMainInfo("杭州", ApiClient.APP_KEY)
                .doOnSubscribe((disposable)->refreshLayout.setRefreshing(true))
                .compose(RxUtils.schedulerTransformer(Schedulers.io()))
                .subscribe(weather1 -> showData(weather1),
                        throwable -> {
                            ToastUtils.showToast(getApplicationContext(), "网络异常");
                            refreshLayout.setRefreshing(false);
                        });
    }

    public void showData(Weather weather) {
        this.weather = weather;
        refreshLayout.setRefreshing(false);
        weather5BeanList.clear();
        weather5BeanList.addAll(weather.getHeWeather5());
        if (weather5BeanList.get(0).getStatus().equals(NET_OK)) {
            indexAdapter.notifyDataSetChanged();
        } else
            ToastUtils.showToast(getApplicationContext(), "获取失败，请重新加载");
    }

    @OnClick(R.id.img_more)
    public void onViewClicked() {
        ToastUtils.showToast(getApplicationContext(), "more");
    }

    private int y = 0;
    private boolean type;//滚动类型,如果一直朝一个方向滑动，则bar只需要设置一次背景
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            y += dy;
            if (y > w - 110) {
                StatusBarUtil.setColor(MainActivity.this, colorAccent, 0);
                relativeLayout.setBackgroundColor(colorAccent);
            } else {
                transStatus();
                relativeLayout.setBackgroundColor(colorTrans);
            }
        }
    };
}
