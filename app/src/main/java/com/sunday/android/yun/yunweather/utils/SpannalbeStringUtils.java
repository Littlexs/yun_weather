package com.sunday.android.yun.yunweather.utils;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

/**
 * 富文本  转换 工具类
 * <p>
 * txtInfo.setMovementMethod(LinkMovementMethod.getInstance()); //实现文本的滚动
 */

public class SpannalbeStringUtils {

    //	  	标识符
//	    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE  前后都不包括
    private static final int flag = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE;

    /**
     * 改变字体颜色
     *
     * @param text 文字
     * @param color    颜色值
     */
    public static SpannableString setTextColor(String text, int color) {
        SpannableString ss;
        if(TextUtils.isEmpty(text)){
            text = "普通用户";
        }
        ss = new SpannableString(text);
        ss.setSpan(new ForegroundColorSpan(color), 0, text.length(), flag);
        return ss;
    }

    /**
     * 改变字体背景颜色
     *
     * @param text 文字
     * @param color    颜色值
     */
    public static SpannableString setTextBackgroudColor(String text, int color) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new BackgroundColorSpan(color), 0, text.length(), flag);
        return ss;
    }

    /**
     * 设置字体大小（绝对值,单位：像素）
     *
     * @param text text 文字
     * @param size    size
     */
    public static SpannableString setTextSizePx(String text, int size) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new AbsoluteSizeSpan(size), 0, text.length(), flag);
        return ss;
    }

    /**
     * 设置字体大小（绝对值,单位：dip）
     *
     * @param text text 文字
     * @param size    size
     */
    public static SpannableString setTextSizeDp(String text, int size,int start) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new AbsoluteSizeSpan(size, true), start, text.length(), flag); //第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，
        return ss;
    }

    /**
     * 设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
     *
     * @param text text 文字
     * @param size    size
     */
    public static SpannableString setTextSizePx(String text, float size) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new RelativeSizeSpan(size), 0, text.length(), flag); //2.0f表示默认字体大小的两倍
        return ss;
    }

    /**
     * 设置下标签
     *
     * @param text text 文字
     */
    public static SpannableString setSubscript(String text) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new SubscriptSpan(), 0, text.length(), flag);
        return ss;
    }

    /**
     * 设置上标签
     *
     * @param text text 文字
     */
    public static SpannableString setSuperscript(String text) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new SuperscriptSpan(), 0, text.length(), flag);
        return ss;
    }


    /**
     * 使用删除线标记文本
     *
     * @param text 文字
     */
    public static SpannableString setDeleteLine(String text) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new StrikethroughSpan(), 0, text.length(), flag);
        return ss;
    }

    /**
     * 使用下划线标记
     *
     * @param text 文字
     */
    public static SpannableString setUnderLine(String text) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new UnderlineSpan(), 0, text.length(), flag);
        return ss;
    }

    /**
     * 设置字体的样式
     *
     * @param text 文字
     * @param style    样式
     *               Typeface.BOLD  粗体    1
     *               Typeface.BOLD_ITALIC 粗斜体 3
     *               Typeface.ITALIC  斜体  2
     */
    public static SpannableString setTextStyle(String text, int style) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new StyleSpan(style), 0, text.length(), flag);
        return ss;
    }


    /**
     * 设置打电话的链接
     *
     * @param text 文字
     * @param phone 电话号码
     */
    public static SpannableString setCallPhone(String text, String phone) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new URLSpan("tel:" + phone), 0, text.length(), flag);
        return ss;
    }

    /**
     * 设置超文本链接
     * 超级链接（需要添加setMovementMethod方法附加响应）
     * msp.setSpan(new URLSpan("tel:4155551212"), 37, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     电话
     * msp.setSpan(new URLSpan("mailto:webmaster@google.com"), 39, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     邮件
     * msp.setSpan(new URLSpan("http://www.baidu.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     网络
     * msp.setSpan(new URLSpan("sms:4155551212"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);    短信   使用sms:或者smsto:
     * msp.setSpan(new URLSpan("mms:4155551212"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     彩信   使用mms:或者mmsto:
     * msp.setSpan(new URLSpan("geo:38.899533,-77.036476"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);   地图
     *
     * @param text 文字
     * @param path 链接路径
     */
    public static SpannableString setURL(String text, String path) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new URLSpan(path), 0, text.length(), flag);
        return ss;
    }

    /**
     * 用图片替换文字
     *
     * @param text   文字
     * @param d 图片资源
     */
    public static SpannableString setImage(String text, Drawable d) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ImageSpan(d), 0, text.length(), flag);
        return ss;
    }

    /**
     * 用图片替换文字
     *
     * @param text  文字
     * @param id     图片资源id
     * @param ctx 上下文
     */
    public static SpannableString setImage(String text, int id, Context ctx) {
        SpannableString ss = new SpannableString(text);
        Drawable d = ctx.getResources().getDrawable(id);
        ss.setSpan(new ImageSpan(d), 0, text.length(), flag);
        return ss;
    }


}
