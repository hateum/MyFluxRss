package com.ygl_consulting.myfluxrss.network.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 *
 * @version 1.0
 */

public class NewsItemResponse {

    @SerializedName("title")
    private String title;
    @SerializedName("pubDate")
    private String date;
    @SerializedName("link")
    private String link;
    @SerializedName("description")
    private String description;
    @SerializedName("enclosure")
    private NewsEnclosureResponse enclosure;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NewsEnclosureResponse getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(NewsEnclosureResponse enclosure) {
        this.enclosure = enclosure;
    }
}
