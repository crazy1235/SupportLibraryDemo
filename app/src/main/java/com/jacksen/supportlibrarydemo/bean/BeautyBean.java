package com.jacksen.supportlibrarydemo.bean;

/**
 * Created by jacksen on 2016/3/3.
 */
public class BeautyBean {

    private int imageId;

    private String name;

    private String desc;

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
}
