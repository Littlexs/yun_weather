package com.sunday.android.yun.yunweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.sunday.android.yun.yunweather.entity.Weather;

import java.util.List;

/**
 * Created by yun_sheng on 2017/8/14.
 */

public class IndexAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Weather.HeWeather5Bean> heWeather5;

    public IndexAdapter(Context context,List<Weather.HeWeather5Bean> heWeather5){
        this.mContext = context;
        this.heWeather5 = heWeather5;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyHolder extends MyViewHolder<Weather.HeWeather5Bean>{

        public MyHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(int position, Weather.HeWeather5Bean item) {
            super.bind(position, item);
        }
    }
}
