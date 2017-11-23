package com.ygl_consulting.myfluxrss.viewmodels;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.ygl_consulting.myfluxrss.R;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.network.NewsDataManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public class NewsViewModel extends Observable {

    public ObservableInt newsProgress;
    public ObservableInt newsRecycler;
    public ObservableInt newsLabel;
    public ObservableBoolean isLoading;
    public ObservableField<String> messageLabel;

    private List<News> newsList;
    private Context context;

    public NewsViewModel(@NonNull Context context) {
        this.context = context;
        this.newsList = new ArrayList<>();
        newsProgress = new ObservableInt(View.GONE);
        newsRecycler = new ObservableInt(View.GONE);
        newsLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_loading_news));
        isLoading = new ObservableBoolean(false);
    }

    public void onCreate() {
        Log.e("TAG", "onCreate");
        initializeViews();
        fetchNewsList();
    }

    public void onRefresh() {
        fetchNewsList();
    }

    //It is "public" to show an example of test
    public void initializeViews() {
        newsLabel.set(View.GONE);
        newsRecycler.set(View.GONE);
        showLoading();
    }

    private void showLoading() {
        newsProgress.set(View.VISIBLE);
        isLoading.set(false);
    }

    private void fetchNewsList() {
        isLoading.set(true);

        NewsDataManager.create()
                .getNewsListAsync(new NewsDataManager.Callback() {
                    @Override
                    public void onSucess(@NonNull final ArrayList<News> news) {
                        hideLoading();
                        newsLabel.set(View.GONE);
                        newsRecycler.set(View.VISIBLE);
                        changeNewsDataSet(news);
                    }

                    @Override
                    public void onFail() {
                        hideLoading();
                        messageLabel.set(context.getString(R.string.error_loading_news));
                        newsLabel.set(View.VISIBLE);
                        newsRecycler.set(View.GONE);

                    }
                });

    }

    /*inner*/ void hideLoading() {
        isLoading.set(false);
        newsProgress.set(View.GONE);
    }

    private void changeNewsDataSet(List<News> news) {
        newsList.clear();
        newsList.addAll(news);
        setChanged();
        notifyObservers();
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void reset() {
        context = null;
    }
}