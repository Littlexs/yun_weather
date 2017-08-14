package com.sunday.android.yun.yunweather.common;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yun_sheng
 */
public abstract class LazyBaseFragment extends RxFragment {
    protected View rootView;
    protected Context mContext;
    protected Intent intent;
    protected boolean isFinish = false;
    protected Bundle activityBundle;//获取来自activity的数据，使用时需要判断是否为空

    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible = false,isFirst = true,isCreate = false;
    private Unbinder bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        activityBundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
        bind = ButterKnife.bind(this, rootView);
        isCreate = true;
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initToolBar();
        initViews(savedInstanceState);
        if (isVisible && isFirst && isCreate){
            isFirst = false;//是否第一次加载
            lazyLoad();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        isVisible = isVisibleToUser;
        if (isVisible && isFirst && isCreate){
            isFirst = false;//是否第一次加载
            lazyLoad();
        }
    }

    /**
     * 设置布局layout
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化toolbar
     */
    public abstract void initToolBar();

    /**
     * 初始化views
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);


    /**
     * 延迟加载
     */
    protected abstract void lazyLoad();


    /**
     * 设置数据显示
     */
    public void showData() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        isFinish = true;
    }
}
