package com.ygl_consulting.myfluxrss.network;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */
public class RemoteImageManager {
    private RemoteImageManager() {

    }

    @NonNull
    public static RemoteImageManager create() {
        return new RemoteImageManager();
    }

    public void getImageDrawableAsync(@NonNull final Context context, @NonNull final String imageUrl, @NonNull final Callback callback) {
        Glide.with(context).load(imageUrl).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (resource != null)
                    callback.onSucess(resource);
            }

            @Override
            public void onLoadFailed(@NonNull Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                callback.onFail(errorDrawable);
            }
        });
    }

    public interface Callback {
        void onSucess(@NonNull Drawable resource);

        void onFail(@NonNull Drawable errorDrawable);
    }
}
