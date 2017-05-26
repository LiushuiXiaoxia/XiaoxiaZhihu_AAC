package cn.mycommons.xiaoxiazhihu.biz.pojo.bean;

import android.support.annotation.*;

import com.google.auto.value.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * LastThemeTopStory <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class LastThemeTopStory implements Serializable {

    public static TypeAdapter<LastThemeTopStory> typeAdapter(Gson gson) {
        return new AutoValue_LastThemeTopStory.GsonTypeAdapter(gson);
    }

    @SerializedName("id")
    public abstract int getId();

    @SerializedName("type")
    public abstract int getType();

    @Nullable
    @SerializedName("title")
    public abstract String getTitle();

    @Nullable
    @SerializedName("ga_prefix")
    public abstract String getGaPrefix();

    @Nullable
    @SerializedName("image")
    public abstract String getImage();
}