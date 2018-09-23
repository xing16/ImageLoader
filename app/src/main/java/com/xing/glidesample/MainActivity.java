package com.xing.glidesample;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.imageloader.ImageLoader;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.iv_image);


//        Glide.with(this)
//                .load("http://img1.3lian.com/2015/w22/87/d/105.jpg")
//
//                .into(imageView);

//        Picasso.get().load()

        ImageLoader.getInstance().setImageLoaderStrategy(new GlideLoaderStrategy());
        ImageLoader.getInstance()
                .with(this)
                .load("http://img1.3lian.com/2015/w22/87/d/105.jpg")
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop(false)
//                .centerInside(false)
                .skipMemoryCache(false)
                .error(R.mipmap.ic_launcher)
                .resize(500, 500)
                .into(imageView);


    }
}




