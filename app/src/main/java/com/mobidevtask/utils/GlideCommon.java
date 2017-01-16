package com.mobidevtask.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mobidevtask.R;

public class GlideCommon {

    private GlideCommon() {
    }

    public static void load(@NonNull Context context, @NonNull ImageView imageView, @Nullable ProgressBar progressBar,
                            @Nullable String url, boolean centerCrop, @Nullable Transformation transformation) {
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);

        DrawableRequestBuilder requestBuilder = Glide.with(context).load(url);

        if (centerCrop) {
            requestBuilder.centerCrop();
        }

        if (transformation != null) {
            requestBuilder.bitmapTransform(transformation);
        }

        requestBuilder
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .error(R.drawable.ic_cloud_off)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target,
                                               boolean isFirstResource) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model,
                                                   Target<GlideDrawable> target, boolean isFromMemoryCache,
                                                   boolean isFirstResource) {
                        if (progressBar != null)
                            progressBar.setVisibility(View.GONE);
                        return false;
                    }
                }).into(imageView);
    }

}
