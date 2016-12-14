package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import android.support.annotation.*;

import com.google.auto.value.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * LastTemeTopStory <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class LastTemeTopStory implements Serializable {

    public static TypeAdapter<LastTemeTopStory> typeAdapter(Gson gson) {
        return new AutoValue_LastTemeTopStory.GsonTypeAdapter(gson);
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