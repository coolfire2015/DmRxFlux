package com.huyingbao.rxflux2.util.imageloader;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestListener;

/**
 * 图片加载参数设置
 * Created by liujunfeng on 2017/1/1.
 *
 * @param <ResourceType>
 */
public class ImageLoader<ResourceType> {
    private float rotate;//旋转角度

    private ResourceType resource;

    private ImageView imgView;

    @DrawableRes
    private int placeHolder;//加载图片过程中显示的图片

    @DrawableRes
    private int errorHolder;//加载失败显示的图片

    private float sizeMultiplier;

    private int width;

    private int height;

    private boolean fitCenter;//true:fitCenter图片压缩居中显示,false:centerInside图片比例正常,超出部分被裁剪

    private boolean netImage;//true:网络图片需要本地缓存(默认),false:不需要本地缓存

    private boolean isCircle;//true:加载圆形,false:不加载圆形(默认)

    private RequestListener requestListener;

    private ImageLoader(Builder<ResourceType> builder) {
        this.resource = builder.resource;
        this.imgView = builder.imgView;
        this.placeHolder = builder.placeHolder;
        this.errorHolder = builder.errorHolder;
        this.sizeMultiplier = builder.sizeMultiplier;
        this.fitCenter = builder.fitCenter;
        this.isCircle = builder.isCircle;
        this.netImage = builder.netImage;
        this.requestListener = builder.requestListener;
        this.width = builder.width;
        this.height = builder.height;
        this.rotate = builder.rotate;
    }

    public ResourceType getResource() {
        return resource;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public int getErrorHolder() {
        return errorHolder;
    }

    public float getSizeMultiplier() {
        return sizeMultiplier;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isFitCenter() {
        return fitCenter;
    }

    public boolean isNetImage() {
        return netImage;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public float getRotate() {
        return rotate;
    }

    public RequestListener getRequestListener() {
        return requestListener;
    }

    public static class Builder<ResourceType> {
        public ResourceType resource;
        public ImageView imgView;
        @DrawableRes
        public int placeHolder;
        @DrawableRes
        public int errorHolder;
        public float sizeMultiplier;
        public boolean fitCenter;
        public boolean netImage;
        public boolean isCircle;
        public RequestListener requestListener;
        public int width;
        public int height;
        public float rotate;

        public Builder() {
            this.fitCenter = true;
            this.netImage = true;
            this.isCircle = false;
            this.sizeMultiplier = 0;
            this.placeHolder = 0;
            this.width = 0;
            this.height = 0;
            this.rotate = 0f;
        }

        public ImageLoader build() {
            return new ImageLoader(this);
        }
    }
}
