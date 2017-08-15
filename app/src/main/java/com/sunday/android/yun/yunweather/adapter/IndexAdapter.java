package com.sunday.android.yun.yunweather.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.entity.Weather;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yun_sheng on 2017/8/14.
 */

public class IndexAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Weather.HeWeather5Bean> heWeather5;

    public IndexAdapter(Context context, List<Weather.HeWeather5Bean> heWeather5) {
        this.mContext = context;
        this.heWeather5 = heWeather5;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.index_01, parent, false);
            return new MyHeadHolder(view);
        }else if (viewType == 1){
            view = LayoutInflater.from(mContext).inflate(R.layout.index_day_item_parent, parent, false);
            return new MyDayHolder(view);
        }else {
            view = LayoutInflater.from(mContext).inflate(R.layout.index_02, parent, false);
            return new MyContentHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {

        } else if (position == 1) {
            MyDayHolder dayHolder = (MyDayHolder) holder;

            ConstraintLayout constraintLayout;
            for (int i = 0;i<3;i++){
                constraintLayout = (ConstraintLayout) LayoutInflater.from(mContext).inflate(R.layout.index_day_item, null);
                ViewGroup viewGroup = (ViewGroup) constraintLayout.getParent();
                if (viewGroup!=null){viewGroup.removeAllViews();}
                dayHolder.lMain.addView(constraintLayout);
            }

        } else if (position == 2) {
            MyContentHolder contentHolder = (MyContentHolder) holder;
            contentHolder.tvTitle.setText("未来小时预报");

            ConstraintLayout constraintLayout;
            for (int i = 0;i<3;i++){
                constraintLayout = (ConstraintLayout) LayoutInflater.from(mContext).inflate(R.layout.index_out_item, null);
                ViewGroup viewGroup = (ViewGroup) constraintLayout.getParent();
                if (viewGroup!=null){viewGroup.removeAllViews();}
                contentHolder.lContent.addView(constraintLayout);
            }

        } else if (position == 3) {
            MyContentHolder contentHolder = (MyContentHolder) holder;
            contentHolder.tvTitle.setText("出行建议");

            ConstraintLayout constraintLayout;
            for (int i = 0;i<3;i++){
                constraintLayout = (ConstraintLayout) LayoutInflater.from(mContext).inflate(R.layout.index_out_item, null);
                ViewGroup viewGroup = (ViewGroup) constraintLayout.getParent();
                if (viewGroup!=null){viewGroup.removeAllViews();}
                contentHolder.lContent.addView(constraintLayout);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyHeadHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_now_sky)
        TextView tvNowSky;
        @BindView(R.id.tv_now_temp)
        TextView tvNowTemp;
        @BindView(R.id.tv_now_quality)
        TextView tvNowQuality;
        @BindView(R.id.tv_now_wind)
        TextView tvNowWind;
        @BindView(R.id.tv_now_humidity)
        TextView tvNowHumidity;
        @BindView(R.id.tv_now_feel)
        TextView tvNowFeel;

        public MyHeadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class MyDayHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.l_main)
        LinearLayout lMain;
        public MyDayHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class MyContentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.space)
        View space;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.h_line)
        View hLine;
        @BindView(R.id.l_content)
        LinearLayout lContent;
        public MyContentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
