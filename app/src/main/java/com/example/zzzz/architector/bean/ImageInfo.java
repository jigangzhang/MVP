package com.example.zzzz.architector.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/1/19.
 */

public class ImageInfo implements Parcelable{
    private String advertisementImageUrl;//图片url
    private String advertisementTitle;//图片描述
    private String advertisementH5Url;//图片详情url
    private String advertisementId;

    public ImageInfo(String image, String text, String value,String advertisementId) {
        this.advertisementImageUrl = image;
        this.advertisementTitle = text;
        this.advertisementH5Url = value;
        this.advertisementId=advertisementId;
    }

    protected ImageInfo(Parcel in) {
        advertisementImageUrl = in.readString();
        advertisementTitle = in.readString();
        advertisementH5Url = in.readString();
        advertisementId = in.readString();
    }

    public static final Creator<ImageInfo> CREATOR = new Creator<ImageInfo>() {
        @Override
        public ImageInfo createFromParcel(Parcel in) {
            return new ImageInfo(in);
        }

        @Override
        public ImageInfo[] newArray(int size) {
            return new ImageInfo[size];
        }
    };

    public String getAdvertisementImageUrl() {
        return advertisementImageUrl;
    }

    public void setAdvertisementImageUrl(String advertisementImageUrl) {
        this.advertisementImageUrl = advertisementImageUrl;
    }

    public String getAdvertisementTitle() {
        return advertisementTitle;
    }

    public void setAdvertisementTitle(String advertisementTitle) {
        this.advertisementTitle = advertisementTitle;
    }

    public String getAdvertisementH5Url() {
        return advertisementH5Url;
    }

    public void setAdvertisementH5Url(String advertisementH5Url) {
        this.advertisementH5Url = advertisementH5Url;
    }

    public String getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(String advertisementId) {
        this.advertisementId = advertisementId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(advertisementImageUrl);
        dest.writeString(advertisementTitle);
        dest.writeString(advertisementH5Url);
        dest.writeString(advertisementId);
    }
}
