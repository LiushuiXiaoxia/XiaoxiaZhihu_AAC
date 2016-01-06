package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Comment <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
public class Comment implements Serializable {

    @SerializedName("id")
    public int id;
    @SerializedName("author")
    public String author;
    @SerializedName("content")
    public String content;
    @SerializedName("likes")
    public int likes;
    @SerializedName("time")
    public long time;
    @SerializedName("avatar")
    public String avatar;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", time=" + time +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
