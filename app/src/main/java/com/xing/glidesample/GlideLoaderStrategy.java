package com.xing.glidesample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.imageloader.ImageLoaderOptions;
import com.example.imageloader.ImageLoaderStrategy;

public class GlideLoaderStrategy implements ImageLoaderStrategy {

    @Override
    public void loadImage(Context context, ImageView imageView, ImageLoaderOptions options) {
        GlideRequest<Drawable> glideRequest = GlideApp.with(context)
                .load(options.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);
        if (options.isCenterCrop()) {
            glideRequest.centerCrop();
        }
        if (options.isCenterInside()) {
            glideRequest.centerInside();
        }

        if (options.isSkipMemoryCache()) {
            glideRequest.skipMemoryCache(true);
        }
        if (!options.isNoFade()) {
            glideRequest.transition(DrawableTransitionOptions.withCrossFade());
        }
        if (options.getTargetWidth() > 0 && options.getTargetHeight() > 0) {
            glideRequest.override(options.getTargetWidth(), options.getTargetHeight());
        }
        glideRequest.into(imageView);
    }

    @Override
    public void loadImage(Fragment fragment, ImageView imageView, ImageLoaderOptions options) {
        GlideRequest<Drawable> glideRequest = GlideApp.with(fragment)
                .load(options.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);
        if (options.isCenterCrop()) {
            glideRequest.centerCrop();
        }
        if (options.isCenterInside()) {
            glideRequest.centerInside();
        }

        if (options.isSkipMemoryCache()) {
            glideRequest.skipMemoryCache(true);
        }
        if (!options.isNoFade()) {
            glideRequest.transition(DrawableTransitionOptions.withCrossFade());
        }
        if (options.getTargetWidth() > 0 && options.getTargetHeight() > 0) {
            glideRequest.override(options.getTargetWidth(), options.getTargetHeight());
        }
        glideRequest.into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }

    @Override
    public void clearDiskCache() {

    }
}
