package com.jacksen.supportlibrarydemo.bean;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by jacksen on 2016/2/29.
 */
public class ActivityDetails {

    private int titleId;
    private int descriptionId;
    private Class<? extends AppCompatActivity> activityClass;

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public Class<? extends AppCompatActivity> getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Class<? extends AppCompatActivity> activityClass) {
        this.activityClass = activityClass;
    }

    /**
     * constructor
     *
     * @param titleId
     * @param descriptionId
     * @param activityClass
     */
    public ActivityDetails(int titleId, int descriptionId, Class<? extends AppCompatActivity> activityClass) {
        super();
        this.titleId = titleId;
        this.descriptionId = descriptionId;
        this.activityClass = activityClass;
    }

}
