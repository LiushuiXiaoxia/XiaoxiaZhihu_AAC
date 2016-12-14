package cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import cn.mycommons.xiaoxiazhihu.biz.pojo.response.BaseResponse;

/**
 * GetStoryExtraResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class GetStoryExtraResponse extends BaseResponse {

    public static TypeAdapter<GetStoryExtraResponse> typeAdapter(Gson gson) {
        return new AutoValue_GetStoryExtraResponse.GsonTypeAdapter(gson);
    }

    @SerializedName("long_comments")
    public abstract int getLongComments();

    @SerializedName("popularity")
    public abstract int getPopularity();

    @SerializedName("short_comments")
    public abstract int getShortComments();

    @SerializedName("comments")
    public abstract int getComments();
}