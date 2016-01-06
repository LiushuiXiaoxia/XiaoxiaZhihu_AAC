package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * ThemeEditor <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class ThemeEditor implements Serializable {

    @SerializedName("url")
    public String url;
    @SerializedName("bio")
    public String bio;
    @SerializedName("id")
    public int id;
    @SerializedName("avatar")
    public String avatar;
    @SerializedName("name")
    public String name;

    @Override
    public String toString() {
        return "ThemeEditor{" +
                "url='" + url + '\'' +
                ", bio='" + bio + '\'' +
                ", id=" + id +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}