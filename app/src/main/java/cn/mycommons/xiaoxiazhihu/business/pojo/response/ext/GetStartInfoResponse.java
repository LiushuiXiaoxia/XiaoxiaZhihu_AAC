package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * StartInfoResponse <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
@AutoValue
public abstract class GetStartInfoResponse extends BaseResponse {

    public static TypeAdapter<GetStartInfoResponse> typeAdapter(Gson gson) {
        return new AutoValue_GetStartInfoResponse.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("text")
    public abstract String getText();

    @Nullable
    @SerializedName("img")
    public abstract String getImg();
}