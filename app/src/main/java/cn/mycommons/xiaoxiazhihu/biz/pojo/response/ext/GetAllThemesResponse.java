package cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.ThemeItem;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.BaseResponse;

/**
 * GetAllThemesResponse <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
@AutoValue
public abstract class GetAllThemesResponse extends BaseResponse {

    public static TypeAdapter<GetAllThemesResponse> typeAdapter(Gson gson) {
        return new AutoValue_GetAllThemesResponse.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("others")
    public abstract List<ThemeItem> getOthers();
}