package cn.mycommons.xiaoxiazhihu.biz.pojo.bean;

import android.support.annotation.*;

import com.google.auto.value.*;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * ThemeEditor <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class ThemeEditor implements Serializable {

    public static TypeAdapter<ThemeEditor> typeAdapter(Gson gson) {
        return new AutoValue_ThemeEditor.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("url")
    public abstract String getUrl();

    @Nullable
    @SerializedName("bio")
    public abstract String getBio();

    @SerializedName("id")
    public abstract int getId();

    @Nullable
    @SerializedName("avatar")
    public abstract String getAvatar();

    @Nullable
    @SerializedName("name")
    public abstract String getName();
}