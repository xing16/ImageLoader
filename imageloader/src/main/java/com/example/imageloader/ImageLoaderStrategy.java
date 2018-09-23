package com.example.imageloader;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

public interface ImageLoaderStrategy {

    // 加载图片
    void loadImage(Context context, ImageView imageView, ImageLoaderOptions options);

    void loadImage(Fragment fragment, ImageView imageView, ImageLoaderOptions options);

    // 清除内存缓存
    void clearMemoryCache();

    // 清除硬盘缓存
    void clearDiskCache();


}
