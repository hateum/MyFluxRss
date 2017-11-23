package com.ygl_consulting.myfluxrss.network;

import android.support.annotation.NonNull;

import com.ygl_consulting.myfluxrss.BuildConfig;
import com.ygl_consulting.myfluxrss.models.News;
import com.ygl_consulting.myfluxrss.network.data.NewsItemResponse;
import com.ygl_consulting.myfluxrss.network.data.NewsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;


/**
 * Created by Hatem Noureddine on 23/11/2017.
 */
public class NewsDataManager {
    private NewsDataManager() {

    }

    @NonNull
    public static NewsDataManager create() {
        return new NewsDataManager();
    }

    private static ArrayList<News> convertToAppModel(List<NewsItemResponse> newArticles) {
        ArrayList<News> listNews = new ArrayList<>();
        if (newArticles != null) {
            for (NewsItemResponse article : newArticles) {
                listNews.add(new News(article.getTitle(), article.getDescription(), article.getDate(), article.getLink(), article.getEnclosure()
                        .getLink()));
            }
        }
        return listNews;
    }

    public void getNewsListAsync(@NonNull final Callback callback) {
        NewsServiceFactory.create()
                .fetchNews(BuildConfig.RSS_URL)
                .enqueue(new retrofit2.Callback<NewsResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<NewsResponse> call, @NonNull Response<NewsResponse> response) {
                        NewsResponse newsResponse = response.body();
                        if (response.isSuccessful() && newsResponse != null) {
                            callback.onSucess(convertToAppModel(newsResponse
                                    .getNewsList()));
                        } else {
                            callback.onFail();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NewsResponse> call, Throwable t) {
                        callback.onFail();
                    }
                });
    }

    public interface Callback {
        void onSucess(@NonNull ArrayList<News> news);

        void onFail();
    }
}
