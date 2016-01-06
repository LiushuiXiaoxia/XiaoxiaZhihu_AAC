package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

/**
 * LastThemeStory <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class LastThemeStory implements Serializable {

    @SerializedName("id")
    public int id;

    @SerializedName("type")
    public int type;

    @SerializedName("title")
    public String title;

    @SerializedName("ga_prefix")
    public String gaPrefix;

    @SerializedName("images")
    public String[] images;

    @Override
    public String toString() {
        return "LastThemeStory{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", gaPrefix='" + gaPrefix + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}