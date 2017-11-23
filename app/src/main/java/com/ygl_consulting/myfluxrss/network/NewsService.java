package com.ygl_consulting.myfluxrss.network;

import com.ygl_consulting.myfluxrss.network.data.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public interface NewsService {

    @GET
    Call<NewsResponse> fetchNews(@Url String url);
}
