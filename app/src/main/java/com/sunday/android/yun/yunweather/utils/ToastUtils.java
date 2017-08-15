package com.sunday.android.yun.yunweather.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 *
 */
public class ToastUtils
{
    public static int LENGTH_LONG = Toast.LENGTH_LONG;
    public static int LENGTH_SHORT = Toast.LENGTH_SHORT;
    private static Toast mToast;  
    
    /**
     * 
     * Methods Name: showToast
     * @author FU ZHIXUE
     * Description: 普通文本消息提示
     * @param context
     * @param text
     * @param duration
     * Comments:
     */
    public static void showToast(Context context,CharSequence text,int duration){
        mToast = makeText(context, text, duration);
        if(mToast!=null){
            mToast.show();
        }
    }

    /**
     * HUANG JUNHAO 2015-2-10
     * @param context
     * @param resourceId 资源文件中的id
     */
    public static void showToast(Context context,int resourceId)
    {
        mToast = makeText(context, resourceId, Toast.LENGTH_SHORT);
        if(mToast!=null){
            mToast.show();
        }
    }
    
    private static Toast makeText(Context context,CharSequence text,int duration){
        //创建一个Tost提示消息
        Toast toast = null;
        if(null != context && !TextUtils.isEmpty(text))
        {
            toast = Toast.makeText(context, text, duration);
        }
        return toast;
    }

    private static Toast makeText(Context context,int resourceId,int duration) {
        //创建一个Tost提示消息
        Toast toast = null;
        if(null != context){
            toast = Toast.makeText(context, resourceId, duration);
        }
        return toast;
    }

    public static void showToast(Context context,String text) {  
    	   if(mToast == null) {  
    	       mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);  
    	    } else {  
    	    	mToast.setText(text);       
    	    	mToast.setDuration(Toast.LENGTH_SHORT);  
            }
    	    mToast.show();  
    	} 

}
