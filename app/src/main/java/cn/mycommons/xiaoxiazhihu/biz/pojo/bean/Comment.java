package cn.mycommons.xiaoxiazhihu.biz.pojo.bean;

import android.support.annotation.*;

import com.google.auto.value.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Comment <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
@AutoValue
public abstract class Comment implements Serializable {

    public static TypeAdapter<Comment> typeAdapter(Gson gson) {
        return new AutoValue_Comment.GsonTypeAdapter(gson);
    }

    @SerializedName("id")
    public abstract int getId();

    @Nullable
    @SerializedName("author")
    public abstract String getAuthor();

    @Nullable
    @SerializedName("content")
    public abstract String getContent();

    @SerializedName("likes")
    public abstract int getLikes();

    @SerializedName("time")
    public abstract long getTime();

    @Nullable
    @SerializedName("avatar")
    public abstract String getAvatar();
}
