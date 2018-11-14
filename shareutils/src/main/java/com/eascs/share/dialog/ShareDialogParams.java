package com.eascs.share.dialog;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @Author luoming
 * @Date 2018/11/6 7:02 PM
 */
public class ShareDialogParams implements Parcelable {
    private ArrayList<ShareItemVM> shareItemVMS;//item 集合
    private int spanCount = 3;//gird 列数

    public ShareDialogParams() {
    }

    public ShareDialogParams(Parcel in) {
        spanCount = in.readInt();
    }

    public static final Creator<ShareDialogParams> CREATOR = new Creator<ShareDialogParams>() {
        @Override
        public ShareDialogParams createFromParcel(Parcel in) {
            return new ShareDialogParams(in);
        }

        @Override
        public ShareDialogParams[] newArray(int size) {
            return new ShareDialogParams[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public ArrayList<ShareItemVM> getShareItemVMS() {
        return shareItemVMS;
    }

    public void setShareItemVMS(ArrayList<ShareItemVM> shareItemVMS) {
        this.shareItemVMS = shareItemVMS;
    }

    public int getSpanCount() {
        return spanCount;
    }

    public void setSpanCount(int spanCount) {
        this.spanCount = spanCount;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(spanCount);
        parcel.writeList(shareItemVMS);
    }
}
