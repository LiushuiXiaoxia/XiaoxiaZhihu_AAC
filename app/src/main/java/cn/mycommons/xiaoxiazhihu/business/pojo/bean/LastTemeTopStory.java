package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * LastTemeTopStory <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class LastTemeTopStory implements Serializable {

    @SerializedName("id")
    public int id;

    @SerializedName("type")
    public int type;

    @SerializedName("title")
    public String title;

    @SerializedName("ga_prefix")
    public String gaPrefix;

    @SerializedName("image")
    public String image;

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