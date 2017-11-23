package com.ygl_consulting.myfluxrss.viewmodels;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.network.RemoteImageManager;
import com.ygl_consulting.myfluxrss.views.DetailsWebViewRssActivity;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class NewsDetailsViewModel {

    private News news;
    private Context context;

    public NewsDetailsViewModel(News news, Context context) {
        this.news = news;
        this.context = context;
    }

    @BindingAdapter({"imageUrl"})
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

    public String getDescription() {
        return news.description;
    }

    public String getDate() {
        return "" + news.date;
    }

    //ici pas de toString.
    public String getLink() {
        return news.link;
    }

    //ici pour quoi un ToString?
    public String getPicture() {
        return news.imageUrl;
    }

    public void onButtonSourceClick(View view) {
        context.startActivity(DetailsWebViewRssActivity.launchDetailWebView(view.getContext(), news));
    }
}
