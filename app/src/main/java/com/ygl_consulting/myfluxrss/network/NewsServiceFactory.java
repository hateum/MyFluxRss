package com.ygl_consulting.myfluxrss.network;

import com.ygl_consulting.myfluxrss.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class NewsServiceFactory {

    static NewsService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.RSS_URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(NewsService.class);
    }
}
