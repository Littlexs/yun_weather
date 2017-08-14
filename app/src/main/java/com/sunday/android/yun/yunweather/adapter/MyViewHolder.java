package com.sunday.android.yun.yunweather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liu on 2017/4/14.
 */

abstract public class MyViewHolder<T> extends RecyclerView.ViewHolder{

    public MyViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(int position){

    }

    public void bind(int position ,T item){

    }

}
