package cn.mycommons.xiaoxiazhihu.business.pojo.bean;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * ThemeItem <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
@AutoValue
public abstract class ThemeItem implements Serializable {

    public static TypeAdapter<ThemeItem> typeAdapter(Gson gson) {
        return new AutoValue_ThemeItem.GsonTypeAdapter(gson);
    }

    @SerializedName("id")
    public abstract int getId();

    @Nullable
    @SerializedName("name")
    public abstract String getName();

    @Nullable
    @SerializedName("thumbnail")
    public abstract String getThumbnail();

    @Nullable
    @SerializedName("description")
    public abstract String getDescription();

    @SerializedName("color")
    public abstract int getColor();
}