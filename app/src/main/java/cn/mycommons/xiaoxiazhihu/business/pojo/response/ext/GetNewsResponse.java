package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetNewsResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
@AutoValue
public abstract class GetNewsResponse extends BaseResponse {

    public static TypeAdapter<GetNewsResponse> typeAdapter(Gson gson) {
        return new AutoValue_GetNewsResponse.GsonTypeAdapter(gson);
    }

    @SerializedName("id")
    public abstract int getId();

    @SerializedName("type")
    public abstract int getType();

    @Nullable
    @SerializedName("title")
    public abstract String getTitle();

    @Nullable
    @SerializedName("image")
    public abstract String getImage();

    @Nullable
    @SerializedName("image_source")
    public abstract String getImageSource();

    @Nullable
    @SerializedName("body")
    public abstract String getBody();

    @Nullable
    @SerializedName("share_url")
    public abstract String getShareUrl();

    @Nullable
    @SerializedName("css")
    public abstract List<String> getCss();

    @Nullable
    @SerializedName("js")
    public abstract List<String> getJs();

    @Nullable
    @SerializedName("ga_prefix")
    public abstract String getGaPrefix();
}