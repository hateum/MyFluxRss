package com.ygl_consulting.myfluxrss.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.views.DetailsRssActivity;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public class ItemNewsViewModel extends BaseObservable {

    private News news;
    private Context context;

    public ItemNewsViewModel(News news, Context context) {
        this.news = news;
        this.context = context;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public String getTitle() {
        return news.title;
    }

    public String getDate() {
        return "" + news.date;
    }

    public String getPicture() {
        return news.imageUrl.toString();
    }

    public void onItemClick(View view) {
        context.startActivity(DetailsRssActivity.launchDetail(view.getContext(), news));
    }

    public void setNews(News news) {
        this.news = news;
        notifyChange();
    }
}
