package com.ygl_consulting.myfluxrss.network;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public class NewsResponse {

    @SerializedName("items")
    private ArrayList<NewsItemResponse> newsList;

    public ArrayList<NewsItemResponse> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<NewsItemResponse> newsList) {
        this.newsList = newsList;
    }
}
