package com.ygl_consulting.myfluxrss.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hatem Noureddine on 23/11/2017.
 */

public class News implements Parcelable {

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
    public String title;
    public String description;
    public String date;
    public String link;
    public String imageUrl;

    public News() {
    }

    public News(String title, String description, String date, String link, String imageUrl) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.link = link;
        this.imageUrl = imageUrl;
    }

    protected News(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.date = in.readString();
        this.link = in.readString();
        this.imageUrl = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.date);
        dest.writeString(this.link);
        dest.writeString(this.imageUrl);
    }
}
