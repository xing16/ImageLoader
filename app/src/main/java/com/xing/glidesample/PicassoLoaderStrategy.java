package com.xing.glidesample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.example.imageloader.ImageLoaderOptions;
import com.example.imageloader.ImageLoaderStrategy;

public class PicassoLoaderStrategy implements ImageLoaderStrategy {


    @Override
    public void loadImage(Context context, ImageView imageView, ImageLoaderOptions options) {
    }

    @Override
    public void loadImage(Fragment fragment, ImageView imageView, ImageLoaderOptions options) {

    }

    @Override
    public void clear(ImageView imageView) {

    }

    @Override
    public void clearMemoryCache() {

    }

    @Override
    public void clearDiskCache() {

    }
}
