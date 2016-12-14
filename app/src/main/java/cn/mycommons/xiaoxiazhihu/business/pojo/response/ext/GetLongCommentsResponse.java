package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import cn.mycommons.xiaoxiazhihu.business.pojo.bean.Comment;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetLongCommentsResponse <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
@AutoValue
public abstract class GetLongCommentsResponse extends BaseResponse {

    public static TypeAdapter<GetLongCommentsResponse> typeAdapter(Gson gson) {
        return new AutoValue_GetLongCommentsResponse.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("comments")
    public abstract List<Comment> getComments();
}