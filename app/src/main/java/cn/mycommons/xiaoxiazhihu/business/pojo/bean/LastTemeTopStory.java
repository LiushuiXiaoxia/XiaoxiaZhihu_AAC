package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * LastTemeTopStory <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class LastTemeTopStory implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("type")
    private int type;

    @SerializedName("title")
    private String title;

    @SerializedName("ga_prefix")
    private String gaPrefix;

    @SerializedName("image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "LastTemeTopStory{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", gaPrefix='" + gaPrefix + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}