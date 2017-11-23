package com.ygl_consulting.myfluxrss.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ygl_consulting.myfluxrss.R;
import com.ygl_consulting.myfluxrss.databinding.ActivityListRssBinding;
import com.ygl_consulting.myfluxrss.viewmodels.NewsViewModel;

import java.util.Observable;
import java.util.Observer;

public class ListRssActivity extends AppCompatActivity implements Observer {

    private ActivityListRssBinding activityListRssBinding;
    private NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        setSupportActionBar(activityListRssBinding.toolbar);
        setupListNewsView(activityListRssBinding.listNews);
        setupObserver(newsViewModel);
    }

    private void initDataBinding() {
        activityListRssBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_rss);
        newsViewModel = new NewsViewModel(this);
        activityListRssBinding.setNewsViewModel(newsViewModel);
    }

    private void setupListNewsView(RecyclerView listNews) {
        NewsAdapter adapter = new NewsAdapter();
        listNews.setAdapter(adapter);
        listNews.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setupObserver(Observable observable) {
        observable.addObserver(this);
        newsViewModel.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        newsViewModel.reset();
    }

    @Override
    public void update(Observable observable, Object data) {
        Log.e("TAG", "update");
        if (observable instanceof NewsViewModel) {
            NewsAdapter newsAdapter = (NewsAdapter) activityListRssBinding.listNews.getAdapter();
            NewsViewModel newsViewModel = (NewsViewModel) observable;
            newsAdapter.setNewsList(newsViewModel.getNewsList());
        }
    }
}