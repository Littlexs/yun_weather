package com.sunday.android.yun.yunweather.customview_test.circle_round;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.sunday.android.yun.yunweather.utils.DeviceUtils;

/**
 * Created by ASUS001 on 2017/9/22.
 * 旋转圆
 */

public class CircleRound extends View{

    private Context context;
    private Paint paint;
    private Path path,movePath;
    private int w,h;
    private int[] center = new int[2];
    private int centerCircleR = 70;
    private float[] tempMovePos = new float[2];
    private float[] tempMoveTan = new float[2];
    private Path _path;

    public CircleRound(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.context = context;

        w = DeviceUtils.getDisplay(context).widthPixels;
        h = DeviceUtils.getDisplay(context).heightPixels;
        center[0] = w/2;
        center[1] = h/2;
        centerCircleR = w/6;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        path = new Path();
        path.moveTo(center[0],center[1]);//屏幕中心

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);

        movePath = new Path();
        movePath.moveTo(center[0],center[1]);
        movePath.addCircle(center[0],center[1],w/3, Path.Direction.CW);

        tempMovePos[0] =w/6;
        tempMovePos[1] =h/2;
        _path = new Path();
        _path.addCircle(tempMovePos[0],tempMovePos[1],60, Path.Direction.CW);
        PathMeasure pathMeasure = new PathMeasure(movePath,true);
        ValueAnimator animator = ValueAnimator.ofFloat(0,pathMeasure.getLength());
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float temp = (float) valueAnimator.getAnimatedValue();
                pathMeasure.getPosTan(temp,tempMovePos,null);

                invalidate();
            }
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(center[0],center[1],centerCircleR,paint);

        canvas.drawPath(movePath,paint);

        _path.reset();
        _path.addCircle(tempMovePos[0],tempMovePos[1],60, Path.Direction.CW);
        canvas.drawPath(_path,paint);

    }
}
