package cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.ThemeEditor;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.BaseResponse;

/**
 * GetThemeResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class GetThemeResponse extends BaseResponse {

    public static TypeAdapter<GetThemeResponse> typeAdapter(Gson gson) {
        return new AutoValue_GetThemeResponse.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("stories")
    public abstract List<LastThemeStory> getStories();

    @Nullable
    @SerializedName("description")
    public abstract String getDescription();

    @Nullable
    @SerializedName("background")
    public abstract String getBackground();

    @SerializedName("color")
    public abstract int getColor();

    @Nullable
    @SerializedName("name")
    public abstract String getName();

    @Nullable
    @SerializedName("image")
    public abstract String getImage();

    @Nullable
    @SerializedName("editors")
    public abstract List<ThemeEditor> getEditors();

    @Nullable
    @SerializedName("image_srouce")
    public abstract String getImageSrouce();
}