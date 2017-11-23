package com.ygl_consulting.myfluxrss.views;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.ygl_consulting.myfluxrss.R;
import com.ygl_consulting.myfluxrss.databinding.ActivityDetailsWebviewRssBinding;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.viewmodels.NewsDetailsWebViewModel;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class DetailsWebViewRssActivity extends AppCompatActivity {

    private static final String EXTRA_NEWS = "EXTRA_NEWS";

    private ActivityDetailsWebviewRssBinding activityDetailsWebviewRssBinding;

    public static Intent launchDetailWebView(Context context, News news) {
        Intent intent = new Intent(context, DetailsWebViewRssActivity.class);
        intent.putExtra(EXTRA_NEWS, news);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailsWebviewRssBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_details_webview_rss);
        setSupportActionBar(activityDetailsWebviewRssBinding.toolbar);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
    }

    private void displayHomeAsUpEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle(R.string.details_news_title);
    }

    private void getExtrasFromIntent() {
        News news = getIntent().getParcelableExtra(EXTRA_NEWS);
        NewsDetailsWebViewModel newsDetailsViewModel = new NewsDetailsWebViewModel(news);
        activityDetailsWebviewRssBinding.setNewsDetailsWebViewModel(newsDetailsViewModel);
    }
}