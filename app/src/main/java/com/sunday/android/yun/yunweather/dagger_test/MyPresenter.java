package com.sunday.android.yun.yunweather.dagger_test;


import javax.inject.Inject;

/**
 * Created by ASUS001 on 2017/8/31.
 */

public class MyPresenter implements MyContract.Presenter {
    private MyContract.View view;

    @Inject
    public MyPresenter(MyContract.View view){
        this.view = view;
    }

    @Override
    public void loadData(String pram) {
        view.show("test");
    }
}
