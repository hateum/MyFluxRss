package com.ygl_consulting.myfluxrss.viewmodels;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.ygl_consulting.myfluxrss.BuildConfig;
import com.ygl_consulting.myfluxrss.R;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.network.NewsFactory;
import com.ygl_consulting.myfluxrss.network.NewsItemResponse;
import com.ygl_consulting.myfluxrss.network.NewsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        newsProgress.set(View.VISIBLE);
        isLoading.set(false);
    }

    private void fetchNewsList() {
        isLoading.set(true);
        NewsFactory.create().fetchNews(BuildConfig.RSS_URL).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                isLoading.set(false);
                if (!response.isSuccessful()) {
                    messageLabel.set(context.getString(R.string.error_loading_news));
                    newsProgress.set(View.GONE);
                    newsLabel.set(View.VISIBLE);
                    newsRecycler.set(View.GONE);
                    return;
                }
                changeNewsDataSet(convertToLocalModel(response.body().getNewsList()));
                newsProgress.set(View.GONE);
                newsLabel.set(View.GONE);
                newsRecycler.set(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                isLoading.set(false);
                t.printStackTrace();
                messageLabel.set(context.getString(R.string.error_loading_news));
                newsProgress.set(View.GONE);
                newsLabel.set(View.VISIBLE);
                newsRecycler.set(View.GONE);
            }
        });
    }

    private void changeNewsDataSet(List<News> news) {
        newsList.addAll(news);
        setChanged();
        notifyObservers();
    }

    private ArrayList<News> convertToLocalModel(List<NewsItemResponse> newArticles) {
        ArrayList<News> listNews = new ArrayList<>();
        if (newArticles != null) {
            for (NewsItemResponse article : newArticles) {
                listNews.add(new News(article.getTitle(), article.getDescription(), article.getDate(), article.getLink(), article.getEnclosure().getLink()));
            }
        }
        return listNews;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void reset() {
        context = null;
    }
}