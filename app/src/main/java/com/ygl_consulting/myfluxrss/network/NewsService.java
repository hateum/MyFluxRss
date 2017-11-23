package com.ygl_consulting.myfluxrss.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public interface NewsService {

    @GET
    Call<NewsResponse> fetchNews(@Url String url);
}
