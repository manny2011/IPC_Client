package com.itheima.ipc_server;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/4/12.
 * 支持序列化
 */

public class Rect implements Parcelable{
    public int left;
    public int top;
    public int right;
    public int bottom;
    public Rect(){}

    protected Rect(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<Rect> CREATOR = new Creator<Rect>() {
        @Override
        public Rect createFromParcel(Parcel in) {

            return new Rect(in);
        }

        @Override
        public Rect[] newArray(int size) {
            return new Rect[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(left);
        dest.writeInt(top);
        dest.writeInt(right);
        dest.writeInt(bottom);
    }
    public void readFromParcel(Parcel in){
        left=in.readInt();
        top=in.readInt();
        right=in.readInt();
        bottom=in.readInt();
    }
}
