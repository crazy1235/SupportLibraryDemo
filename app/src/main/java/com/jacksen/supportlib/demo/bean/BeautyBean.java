package com.jacksen.supportlib.demo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jacksen on 2016/3/3.
 */
public class BeautyBean implements Parcelable{

    private int imageId;

    private String name;

    private String desc;

    protected BeautyBean(Parcel in) {
        imageId = in.readInt();
        name = in.readString();
        desc = in.readString();
    }

    public static final Creator<BeautyBean> CREATOR = new Creator<BeautyBean>() {
        @Override
        public BeautyBean createFromParcel(Parcel in) {
            return new BeautyBean(in);
        }

        @Override
        public BeautyBean[] newArray(int size) {
            return new BeautyBean[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @param desc
     * @param name
     * @param imageId
     */
    public BeautyBean(String desc, String name, int imageId) {
        this.desc = desc;
        this.name = name;
        this.imageId = imageId;
    }

    /**
     * @param name
     * @param desc
     */
    public BeautyBean(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(name);
        dest.writeString(desc);
    }
}
