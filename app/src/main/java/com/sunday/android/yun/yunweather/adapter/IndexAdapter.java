package com.sunday.android.yun.yunweather.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunday.android.yun.yunweather.R;
import com.sunday.android.yun.yunweather.entity.Weather;
import com.sunday.android.yun.yunweather.utils.DeviceUtils;
import com.sunday.android.yun.yunweather.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yun_sheng on 2017/8/14.
 */

public class IndexAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Weather.HeWeather5Bean> heWeather5;
    private String[] days = {"今天","明天","后天"};

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
        if (heWeather5.isEmpty()){return;}
        if (position == 0) {
            MyHeadHolder headHolder = (MyHeadHolder) holder;
            Weather.HeWeather5Bean.NowBean nowBean = heWeather5.get(0).getNow();
            Weather.HeWeather5Bean.AqiBean aqiBean = heWeather5.get(0).getAqi();
            headHolder.tvNowTemp.setText(nowBean.getTmp());
            headHolder.tvNowSky.setText(nowBean.getCond().getTxt());
            headHolder.tvNowQuality.setText(aqiBean.getCity().getQlty());
            headHolder.tvNowWind.setText(String.format("%s\n%s",nowBean.getWind().getDir(),nowBean.getWind().getSc()));
            headHolder.tvNowHumidity.setText(String.format("相对湿度\n%s",nowBean.getHum()));
            headHolder.tvNowFeel.setText(String.format("体感温度\n%s°",nowBean.getFl()));
        } else if (position == 1) {
            List<Weather.HeWeather5Bean.DailyForecastBean> dailyForecastBeanList = heWeather5.get(0).getDaily_forecast();
            MyDayHolder dayHolder = (MyDayHolder) holder;
            dayHolder.lMain.removeAllViews();
            ConstraintLayout constraintLayout;
            int i = 0;
            for (Weather.HeWeather5Bean.DailyForecastBean bean : dailyForecastBeanList){
                constraintLayout = (ConstraintLayout) LayoutInflater.from(mContext).inflate(R.layout.index_day_item, null);
                ViewGroup viewGroup = (ViewGroup) constraintLayout.getParent();
                if (viewGroup!=null){viewGroup.removeAllViews();}
                ImageView imageView = ButterKnife.findById(constraintLayout,R.id.imageView);
                TextView day = ButterKnife.findById(constraintLayout,R.id.tv_day);
                TextView simpleInfo = ButterKnife.findById(constraintLayout,R.id.tv_simple_info);
                TextView temp = ButterKnife.findById(constraintLayout,R.id.tv_temp);
                day.setText(days[i]);
                simpleInfo.setText(String.format("%s",bean.getCond().getTxt_d()));
                temp.setText(String.format("%s° / %s°",bean.getTmp().getMax(),bean.getTmp().getMin()));
                imageView.setImageResource(R.drawable.ic_cloud);
                dayHolder.lMain.addView(constraintLayout);
                i++;
            }
        } else if (position == 2) {
            List<Weather.HeWeather5Bean.HourlyForecastBean> hourlyForecastBeanList =  heWeather5.get(0).getHourly_forecast();
            MyContentHolder contentHolder = (MyContentHolder) holder;
            contentHolder.tvTitle.setText("未来小时预报");
            contentHolder.lContent.removeAllViews();
            ConstraintLayout constraintLayout;
            for (Weather.HeWeather5Bean.HourlyForecastBean bean : hourlyForecastBeanList){
                constraintLayout = (ConstraintLayout) LayoutInflater.from(mContext).inflate(R.layout.index_out_item, null);
                ViewGroup viewGroup = (ViewGroup) constraintLayout.getParent();
                if (viewGroup!=null){viewGroup.removeAllViews();}
                ImageView imageView = ButterKnife.findById(constraintLayout,R.id.imageView);
                TextView day = ButterKnife.findById(constraintLayout,R.id.tv_day);
                TextView simpleInfo = ButterKnife.findById(constraintLayout,R.id.tv_simple_info);
                imageView.setImageResource(R.drawable.ic_sport);
                day.setText(bean.getDate().substring(bean.getDate().length()-6,bean.getDate().length()));
                simpleInfo.setText(String.format("%s | %s",bean.getCond().getTxt(),bean.getWind().getSc()));
                contentHolder.lContent.addView(constraintLayout);
            }

        } else if (position == 3) {
            Weather.HeWeather5Bean.SuggestionBean suggestionBean = heWeather5.get(0).getSuggestion();
            MyContentHolder contentHolder = (MyContentHolder) holder;
            contentHolder.tvTitle.setText("出行建议");
            contentHolder.lContent.removeAllViews();
            ConstraintLayout constraintLayout;
            for (int i = 0;i<4;i++){
                constraintLayout = (ConstraintLayout) LayoutInflater.from(mContext).inflate(R.layout.index_suggest_item, null);
                ViewGroup viewGroup = (ViewGroup) constraintLayout.getParent();
                if (viewGroup!=null){viewGroup.removeAllViews();}
                ImageView imageView = ButterKnife.findById(constraintLayout,R.id.imageView);
                TextView day = ButterKnife.findById(constraintLayout,R.id.tv_day);
                TextView simpleInfo = ButterKnife.findById(constraintLayout,R.id.tv_simple_info);
                switch (i){
                    case 0:
                        imageView.setImageResource(R.drawable.ic_clothes);
                        day.setText("穿衣 "+suggestionBean.getDrsg().getBrf());
                        simpleInfo.setText(suggestionBean.getDrsg().getTxt());
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.ic_sport);
                        day.setText("户外 "+suggestionBean.getSport().getBrf());
                        simpleInfo.setText(suggestionBean.getSport().getTxt());
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.ic_feel);
                        day.setText("舒适度 "+suggestionBean.getComf().getBrf());
                        simpleInfo.setText(suggestionBean.getComf().getTxt());
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.ic_car);
                        day.setText("洗车 "+suggestionBean.getCw().getBrf());
                        simpleInfo.setText(suggestionBean.getCw().getTxt());
                        break;
                }
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
        @BindView(R.id.cMain)
        ConstraintLayout cMain;
        public MyHeadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            TextUtils.setTypeface(mContext,tvNowTemp,"fonts/mi.ttf");
            cMain.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DeviceUtils.getDisplay(mContext).widthPixels));
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
