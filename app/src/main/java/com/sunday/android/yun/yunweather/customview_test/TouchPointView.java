package com.sunday.android.yun.yunweather.customview_test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.sunday.android.yun.yunweather.utils.ToastUtils;

import java.util.jar.Attributes;

/**
 * Created by ASUS001 on 2017/9/8.
 */

public class TouchPointView extends View {

    private Context context;
    private Paint paintPoint,paintCircle;
    private Path path;
    private int circleR = 58,statusH = 0;
    int[] position = new int[2];

    public TouchPointView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.context = context;
        init();
    }

    public void init(){

        paintPoint = new Paint();
        paintPoint.setAntiAlias(true);
        paintPoint.setColor(Color.BLUE);
        paintPoint.setStyle(Paint.Style.FILL);

        paintCircle = new Paint();
        paintCircle.setAntiAlias(true);
        paintCircle.setColor(Color.BLUE);
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setStrokeWidth(10);
        paintCircle.setAlpha(1);

        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        statusH = context.getResources().getDimensionPixelSize(resourceId);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getLocationOnScreen(position);
        Log.i("-----",getWidth()+"  "+getHeight()+" "+position[0]+" "+position[1]);
        canvas.drawCircle(position[0]+getWidth()/2,position[1]+getHeight()/2-statusH,50,paintPoint);
        canvas.drawCircle(position[0]+getWidth()/2,position[1]+getHeight()/2-statusH,circleR+temp,paintCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                anim();
                if (itemClick!=null){
                    itemClick.click();
                }
                break;
        }
        return true;
    }

    int temp = 0;
    private void anim(){
        ValueAnimator animator = ValueAnimator.ofInt(0,10);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                temp = (int)valueAnimator.getAnimatedValue();
                paintCircle.setAlpha((int) (255-25.5*temp));
                invalidate();
            }
        });
        animator.setDuration(500);
        animator.setRepeatCount(0);
//        animator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                ToastUtils.showToast(context,"sd");
//            }
//        });
        animator.start();
    }

    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick){
        this.itemClick = itemClick;
    }
    public interface ItemClick{
        void click();
    }
}
