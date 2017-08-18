package com.sunday.android.yun.yunweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.entity.Weather;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yun_sheng on 2017/8/14.
 */

public class CityManageAdapter extends RecyclerView.Adapter implements IViewHelper {

    private Context mContext;
    private List<Weather.HeWeather5Bean> heWeather5;

    public CityManageAdapter(Context context, List<Weather.HeWeather5Bean> heWeather5) {
        this.mContext = context;
        this.heWeather5 = heWeather5;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.city_manage_item, parent, false);
        return new MyContentHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (heWeather5.isEmpty()) {
            return;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public TextView getTextView(View view, int id) {
        return ButterKnife.findById(view, id);
    }

    @Override
    public ImageView getImageView(View view, int id) {
        return ButterKnife.findById(view, id);
    }

    public class MyContentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_simple_info)
        TextView tvSimpleInfo;
        @BindView(R.id.imgClose)
        ImageView imgClose;
        public MyContentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
