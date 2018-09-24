package com.xing.glidesample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.imageloader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private Context context;
    private List<MeiziBean> dataList = new ArrayList<>();

    private int[] heightList = new int[]{400, 600, 670, 900, 500, 700};
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<MeiziBean> list) {
        this.context = context;
        this.dataList = list;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: i= " + i);
        View itemView = inflater.inflate(R.layout.item_recycler, viewGroup, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Log.d("debugdebug", "onBindViewHolder: i = " + i);
        MeiziBean meiziBean = dataList.get(i);
        if (viewHolder instanceof ItemViewHolder) {
            ViewGroup.LayoutParams lp = ((ItemViewHolder) viewHolder).imageView.getLayoutParams();
            lp.width = (ScreenUtils.getScreenWidth(context) - 3 * 10) / 2;
            lp.height = heightList[new Random().nextInt(heightList.length - 1)];
            ((ItemViewHolder) viewHolder).imageView.setLayoutParams(lp);
            ((ItemViewHolder) viewHolder).bindData(meiziBean, lp);
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
        }

        public void bindData(MeiziBean bean, ViewGroup.LayoutParams lp) {
            String imgUrl = bean.getUrl();

//            RequestOptions options = new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher)
//                    .error(R.mipmap.ic_launcher)
//                    .priority(Priority.HIGH)
//                    .dontAnimate()
//                    .skipMemoryCache(false)
//                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
//
//            Glide.with(context)
//                    .load(imgUrl)
//                    .apply(options)
//                    .into(imageView);


//            if (TextUtils.isEmpty(imgUrl)) {
//                ImageLoader.getInstance()
//                        .with(context).clear(imageView);
//                imageView.setTag(R.id.iv_image, position);
//                return;
//            }
//            Object tag = imageView.getTag(R.id.iv_image);
//            if (tag != null && (int) tag != position) {
//                //如果tag不是Null,并且同时tag不等于当前的position。
//                //说明当前的viewHolder是复用来的
//                ImageLoader.getInstance()
//                        .with(context).clear(imageView);
//            }
//
            ImageLoader.getInstance()
                    .with(context)
                    .load(bean.getUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .centerCrop(true)
                    .noFade(true)
                    .skipMemoryCache(false)
                    .error(R.mipmap.ic_launcher)
                    .into(imageView);
//            //给ImageView设置唯一标记。
//            imageView.setTag(R.id.iv_image, position);


//            String tag = (String) imageView.getTag(R.id.iv_image);
//            if (tag == null) {
//            if (!TextUtils.isEmpty(imgUrl)) {
//
//                ImageLoader.getInstance()
//                        .with(context)
//                        .load(bean.getUrl())
//                        .placeholder(R.mipmap.ic_launcher)
//                        .centerCrop(true)
//                        .noFade(true)
//                        .resize(lp.width, lp.height)
//                        .skipMemoryCache(false)
//                        .error(R.mipmap.ic_launcher)
//                        .into(imageView);
//
//            }
//            imageView.setTag(R.id.iv_image, imgUrl);
//            }
        }
    }

    private int dp2Px(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, new DisplayMetrics());
    }
}
