package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * LastThemeStory <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class LastThemeStory implements Serializable {

    public static TypeAdapter<LastThemeStory> typeAdapter(Gson gson) {
        return new AutoValue_LastThemeStory.GsonTypeAdapter(gson);
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
    @SerializedName("images")
    public abstract List<String> getImages();
}