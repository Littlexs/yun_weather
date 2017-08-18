package com.sunday.android.yun.yunweather.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yun_sheng on 2017/8/17.
 */

public interface IViewHelper {
    TextView getTextView(View view,int id);
    ImageView getImageView(View view,int id);
}
