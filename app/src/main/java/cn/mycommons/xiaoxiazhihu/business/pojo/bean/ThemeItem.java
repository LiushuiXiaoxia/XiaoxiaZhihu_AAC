package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * ThemeItem <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class ThemeItem implements Serializable {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("thumbnail")
    public String thumbnail;
    @SerializedName("description")
    public String description;
    @SerializedName("color")
    public int color;

    @Override
    public String toString() {
        return "ThemeItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", description='" + description + '\'' +
                ", color=" + color +
                '}';
    }
}