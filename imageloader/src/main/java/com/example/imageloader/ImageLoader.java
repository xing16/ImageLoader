package com.example.imageloader;

import android.content.Context;
import android.support.v4.app.Fragment;

public class ImageLoader {

    private static ImageLoader instance;
    private ImageLoaderStrategy imageLoaderStrategy;

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    public ImageLoaderOptions with(Context context) {
        return new ImageLoaderOptions(context);
    }

    public ImageLoaderOptions with(Fragment fragment) {
        return new ImageLoaderOptions(fragment);
    }

    public void setImageLoaderStrategy(ImageLoaderStrategy imageLoaderStrategy) {
        if (imageLoaderStrategy != null) {
            this.imageLoaderStrategy = imageLoaderStrategy;
        }
    }

    public ImageLoaderStrategy getImageLoaderStrategy() {
        return imageLoaderStrategy;
    }

}
