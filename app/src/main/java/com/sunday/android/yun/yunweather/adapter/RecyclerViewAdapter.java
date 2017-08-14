package com.sunday.android.yun.yunweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.sunday.android.yun.yunweather.R;

import java.util.List;

/**
 * Created by Pual's PC on 2016/10/9.
 */
abstract public class RecyclerViewAdapter<T> extends RecyclerView.Adapter {
    protected List<T> list;
    private Integer itemView;
    protected View.OnClickListener onClickListener;
    protected Context mContext;

    public RecyclerViewAdapter(Context mContext ,List<T> list, Integer itemView) {
        this.list = list;
        this.itemView = itemView;
        this.mContext = mContext;
    }

    public RecyclerViewAdapter(List<T> list, int itemView) {
        this.list = list;
        this.itemView = itemView;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    abstract public RecyclerView.ViewHolder onCreateViewHolder(View itemView, int viewType);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(itemView, parent, false);
        return onCreateViewHolder(view, viewType);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        if (list != null) {
            viewHolder.bind(position ,list.get(position));
            viewHolder.bind(position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setText(TextView text, Object object) {
        String content = String.valueOf(object);
        if (TextUtils.isEmpty(content) || content.equals("null")) {
            text.setText("");
        } else {
            text.setText(content);
        }
    }


    public void setImage(ImageView imageView, String imagePath, int width, int height) {
        if (TextUtils.isEmpty(imagePath)) {
            imagePath = "http";
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Picasso.with(imageView.getContext())
                .load(imagePath).resize(width, height)
                .centerCrop()
                .placeholder(R.drawable.ic_default_64dp)
                .into(imageView);
    }

}
