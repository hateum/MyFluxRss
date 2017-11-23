package com.ygl_consulting.myfluxrss.network.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */
public class NewsResponse {

    @SerializedName("items")
    private ArrayList<NewsItemResponse> newsList;

    public ArrayList<NewsItemResponse> getNewsList() {
        return newsList;
    }
}
