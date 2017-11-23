package com.ygl_consulting.myfluxrss.viewmodels;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ygl_consulting.myfluxrss.models.News;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public class NewsDetailsViewModel {

    private News news;

    public NewsDetailsViewModel(News news) {
        this.news = news;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
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

    public String getLink() {
        return news.link.toString();
    }

    public String getPicture() {
        return news.imageUrl.toString();
    }
}
