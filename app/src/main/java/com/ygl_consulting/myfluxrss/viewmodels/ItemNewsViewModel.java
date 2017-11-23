package com.ygl_consulting.myfluxrss.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.network.RemoteImageManager;
import com.ygl_consulting.myfluxrss.views.DetailsRssActivity;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */
public class ItemNewsViewModel extends BaseObservable {

    private News news;
    private Context context;

    public ItemNewsViewModel(News news, Context context) {
        this.news = news;
        this.context = context;
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(final ImageView imageView, String imageUrl) {
        RemoteImageManager.create().getImageDrawableAsync(imageView.getContext(), imageUrl, new RemoteImageManager.Callback() {
            @Override
            public void onSucess(@NonNull Drawable resource) {
                imageView.setImageDrawable(resource);
            }

            @Override
            public void onFail(@NonNull Drawable errorDrawable) {
                imageView.setImageDrawable(errorDrawable);
            }
        });
    }

    public String getTitle() {
        return news.title;
    }

    public String getDate() {
        return "" + news.date;
    }

    public String getPicture() {
        return news.imageUrl;
    }

    public void onItemClick(View view) {
        context.startActivity(DetailsRssActivity.launchDetail(view.getContext(), news));
    }

    public void setNews(News news) {
        this.news = news;
        notifyChange();
    }
}
