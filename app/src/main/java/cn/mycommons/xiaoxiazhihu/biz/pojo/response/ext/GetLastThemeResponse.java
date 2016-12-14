package cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastTemeTopStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.BaseResponse;

/**
 * GetLastThemeResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class GetLastThemeResponse extends BaseResponse {

    public static TypeAdapter<GetLastThemeResponse> typeAdapter(Gson gson) {
        return new AutoValue_GetLastThemeResponse.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("stories")
    public abstract List<LastThemeStory> getStories();

    @Nullable
    @SerializedName("top_stories")
    public abstract List<LastTemeTopStory> getTopStories();
}