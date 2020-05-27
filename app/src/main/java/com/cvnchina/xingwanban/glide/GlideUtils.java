package com.cvnchina.xingwanban.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.cvnchina.xingwanban.application.App;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * @author huqiang
 * @date 2018/6/11
 * @describe glide工具类
 * @org 十米科技(shimi.com)
 */
public class GlideUtils {

    /**
     * 普通加网络图片带占位符
     *
     * @param context
     * @param view       显示控件
     * @param url        网络地址
     * @param defaultImg 默认图
     */
    public static void showPlaceholder(Context context, ImageView view, String url, int defaultImg) {
        RequestOptions options = new RequestOptions();
        options.placeholder(defaultImg);
        options.error(defaultImg);
        options.centerCrop();
        Glide.with(context).load(url).apply(options).into(view);

    }

    /**
     * 简单动画加载图片
     *
     * @param view
     * @param url
     * @param defaultImg
     */
    public static void showAnimation(ImageView view, String url, int defaultImg) {
        RequestOptions options = new RequestOptions();
        options.placeholder(defaultImg);
        options.error(defaultImg);
        options.centerCrop();
        Glide.with(App.instance).load(url).transition(withCrossFade()).apply(options).into(view);

    }

    /**
     * 加载圆形图片
     *
     * @param url        请求地址
     * @param view       图片控件
     * @param defaultImg 默认图
     */
    public static void showCircle(ImageView view, String url, int defaultImg) {
        RequestOptions options = RequestOptions.circleCropTransform();
        options.placeholder(defaultImg);
        options.error(defaultImg);
        options.centerCrop();
        Glide.with(App.instance).load(TextUtils.isEmpty(url) ? defaultImg : url).apply(options).into(view);
    }

    /**
     * 加载圆形图片，带边框的
     *
     * @param view
     * @param url
     * @param defaultImg
     * @param BorderColor
     */
    public static void showCircleWithBorder(ImageView view, String url, int defaultImg, int BorderColor) {
        RequestOptions options = new RequestOptions();
        options.placeholder(defaultImg);
        options.error(defaultImg);
        options.centerCrop();
        options.transform(new GlideCircleTransform(3, BorderColor));
        Glide.with(App.instance).load(url).apply(options).into(view);
    }


    /**
     * jia加载圆角
     * @param imageView
     * @param url
     * @param defaultImg
     * @param radius
     */
    public static void loadRoundImg(ImageView imageView, String url, @DrawableRes int defaultImg, int radius) {

        Glide.with(imageView.getContext()).load(url)
                .apply(new RequestOptions().placeholder(defaultImg).error(defaultImg).centerCrop()
                        .transform(new GlideRoundTransform(radius)))
                .thumbnail(loadTransform(imageView.getContext(), defaultImg, radius))
                .thumbnail(loadTransform(imageView.getContext(), defaultImg, radius))
                .into(imageView);
    }

    private static RequestBuilder<Drawable> loadTransform(Context context, @DrawableRes int placeholderId, int radius) {

        return Glide.with(context)
                .load(placeholderId)
                .apply(new RequestOptions().centerCrop()
                        .transform(new GlideRoundTransform(radius)));

    }


    /**
     * 模糊加载图片
     *
     * @param view
     * @param url
     * @param defaultImg
     */
    public static void showIndistinct(ImageView view, String url, int defaultImg) {
        Glide.with(App.instance).load(url).apply(RequestOptions.bitmapTransform(new GlideBlurformation(App.instance))).into(view);
    }

    public static void loadGif(ImageView view,int gifImage ){
        Glide.with(App.instance).load(gifImage).listener(new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                if (resource instanceof GifDrawable) {
                    //加载一次
                    ((GifDrawable)resource).setLoopCount(20);
                }
                return false;
            }

        }).into(view);

    }


}
