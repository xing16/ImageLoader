package com.example.imageloader;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import java.io.File;

public class ImageLoaderOptions {

    // 上下文context，fragment
    private Context context;
    private Fragment fragment;

    private String url;
    private Integer resId;
    private File file;
    private Uri uri;
    private Integer placeholderResId;
    private Integer errorResId;
    private boolean noFade = false;
    private boolean isCenterCrop = true;
    private boolean isCenterInside = false;
    private boolean skipMemoryCache = false;
    private int targetWidth;
    private int targetHeight;

    public ImageLoaderOptions(Context context) {
        if (fragment != null) {
            throw new IllegalStateException("The ImageLoader had set fragment");
        }
        this.context = context;
    }

    public ImageLoaderOptions(Fragment fragment) {
        if (context != null) {
            throw new IllegalStateException("The ImageLoader had set context");
        }
        this.fragment = fragment;
    }

    public ImageLoaderOptions load(String url) {
        this.url = url;
        return this;
    }

    public ImageLoaderOptions load(Uri uri) {
        this.uri = uri;
        return this;
    }

    public ImageLoaderOptions load(Integer resId) {
        this.resId = resId;
        return this;
    }

    public ImageLoaderOptions load(File file) {
        this.file = file;
        return this;
    }

    public ImageLoaderOptions placeholder(Integer placeholderResId) {
        this.placeholderResId = placeholderResId;
        return this;
    }


    public ImageLoaderOptions error(Integer errorResId) {
        this.errorResId = errorResId;
        return this;
    }

    public ImageLoaderOptions centerCrop(boolean isCenterCrop) {
        this.isCenterCrop = isCenterCrop;
        return this;
    }

    public ImageLoaderOptions centerInside(boolean isCenterInside) {
        this.isCenterInside = isCenterInside;
        return this;
    }

    public ImageLoaderOptions skipMemoryCache(boolean skipMemoryCache) {
        this.skipMemoryCache = skipMemoryCache;
        return this;
    }

    public ImageLoaderOptions resize(int width, int height) {
        this.targetWidth = width;
        this.targetHeight = height;
        return this;
    }

    public ImageLoaderOptions noFade(boolean noFade) {
        this.noFade = noFade;
        return this;
    }

    public void into(ImageView imageView) {
        if (context != null) {
            ImageLoader.getInstance()
                    .getImageLoaderStrategy()
                    .loadImage(context, imageView, this);
        } else if (fragment != null) {
            ImageLoader.getInstance()
                    .getImageLoaderStrategy()
                    .loadImage(fragment, imageView, this);
        }
    }

    public String getUrl() {
        return url;
    }

    public Integer getResId() {
        return resId;
    }

    public File getFile() {
        return file;
    }

    public Uri getUri() {
        return uri;
    }

    public Integer getPlaceholderResId() {
        return placeholderResId;
    }

    public Integer getErrorResId() {
        return errorResId;
    }

    public boolean isNoFade() {
        return noFade;
    }

    public boolean isCenterCrop() {
        return isCenterCrop;
    }

    public boolean isCenterInside() {
        return isCenterInside;
    }

    public boolean isSkipMemoryCache() {
        return skipMemoryCache;
    }

    public int getTargetWidth() {
        return targetWidth;
    }

    public int getTargetHeight() {
        return targetHeight;
    }
}
