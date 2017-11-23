package com.ygl_consulting.myfluxrss.viewmodels;

import android.databinding.BindingAdapter;
import android.webkit.WebView;

import com.ygl_consulting.myfluxrss.models.News;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class NewsDetailsWebViewModel {

    private News news;

    public NewsDetailsWebViewModel(News news) {
        this.news = news;
    }

    @BindingAdapter({"sourceUrl"})
    public static void loadSource(final WebView webView, String sourceUrl) {
        webView.loadUrl(sourceUrl);
    }

    public String getLink() {
        return news.link;
    }
}
