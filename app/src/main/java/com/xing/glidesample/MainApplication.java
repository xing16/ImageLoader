package com.xing.glidesample;

import android.app.Application;

import com.example.imageloader.ImageLoader;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.getInstance().setImageLoaderStrategy(new GlideLoaderStrategy());
    }
}
