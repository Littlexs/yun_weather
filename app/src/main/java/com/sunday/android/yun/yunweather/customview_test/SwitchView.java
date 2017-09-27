package com.sunday.android.yun.yunweather.customview_test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.sunday.android.yun.yunweather.utils.ToastUtils;

/**
 * Created by ASUS001 on 2017/9/27.
 */

public class SwitchView extends View  {

    private Context context;
    private Paint paintStorke,paintPoint,paintBg;//边框
    private Path pathStorke,pathPoint;
    private RectF rectF;
    private ValueAnimator animator;
    private float pointMoveLength;//point的移动距离
    private float pointR = 10;//point的半径
    private float temp;//动画返回值

    public SwitchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        rectF = new RectF();
        rectF.left = 100;
        rectF.right = 300;
        rectF.top = 100;
        rectF.bottom = 200;

        paintStorke = new Paint();
        paintStorke.setAntiAlias(true);
        paintStorke.setColor(Color.GRAY);
        paintStorke.setStyle(Paint.Style.STROKE);
        paintStorke.setStrokeWidth(6);

        paintPoint = new Paint();
        paintPoint.setAntiAlias(true);
        paintPoint.setColor(Color.GRAY);

        paintBg = new Paint();
        paintBg.setAntiAlias(true);
        paintBg.setColor(Color.BLUE);

        pathStorke = new Path();
        pathPoint = new Path();

        pointMoveLength = rectF.right-rectF.left-80;//point移动距离

        animator = ValueAnimator.ofFloat(0,1);
        animator.setDuration(200);
        animator.setRepeatCount(0);//重复一次
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                temp = (float) valueAnimator.getAnimatedValue();
                pathPoint.reset();
                if (isOpen){
                    pointR = 30;
                    pointR-=20*temp;
                }else {
                    pointR = 10;
                    pointR+=20*temp;
                }
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pathStorke.addRoundRect(rectF,50, 50, Path.Direction.CW);
        canvas.drawPath(pathStorke,paintStorke);
        if (isOpen){
            pathPoint.addCircle((rectF.right-40)-pointMoveLength*temp,150,pointR, Path.Direction.CW);
        }else {
            pathPoint.addCircle((rectF.left+40)+pointMoveLength*temp,150,pointR, Path.Direction.CW);
        }
        canvas.drawPath(pathPoint,paintPoint);
        if (pointR==10){
            isOpen = false;
        }else if (pointR==30){
            isOpen = true;
        }
        Log.i("---","onDraw  isOpen:"+ isOpen+" "+pointR);
    }

    private boolean isOpen = false;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                animator.start();
                break;
        }
        return true;
    }

    public void setIsOpen(boolean isOpen){
        this.isOpen = isOpen;
    }

}
