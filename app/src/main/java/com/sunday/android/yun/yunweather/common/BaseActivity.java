package com.sunday.android.yun.yunweather.common;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yun_sheng on 2017/8/9.
 */

public abstract class BaseActivity extends RxAppCompatActivity {
    protected String TAG = getClass().getSimpleName();
    private Unbinder bind;
    protected Intent intent;
    protected Context mContext;
    protected boolean isFinish = false;

    ArrayList<Activity> activities = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        mContext = this;
        MobclickAgent.openActivityDurationTrack(false);
        activities.add(this);
        beforeInitView();
        initToolBar();
        initViews(savedInstanceState);
        loadData();
    }

    public void transStatus(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();

    /*
    * 数据的初始化
    * */
    public void beforeInitView(){}

    /**
     * 初始化toolbar
     */
    public abstract void initToolBar();

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);

    /**
     * 加载数据
     */
    public void loadData() {
    }

    /**
     * 设置数据显示
     */
    public void showData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        isFinish = true;
        activities.remove(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(mContext);
    }

    /**
     * @param cls
     */
    public void openActivity(Class<?> cls) {
        startActivity(new Intent(mContext, cls));
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(mContext);
    }

    public void back(View v) {
        finish();
    }

}
