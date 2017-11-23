package com.ygl_consulting.myfluxrss.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public class NewsEnclosureResponse {

    @SerializedName("link")
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
