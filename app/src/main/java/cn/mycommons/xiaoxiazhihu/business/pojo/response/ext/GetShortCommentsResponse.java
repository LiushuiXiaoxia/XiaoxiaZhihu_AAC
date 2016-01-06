package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import cn.mycommons.xiaoxiazhihu.business.pojo.bean.Comment;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetShortCommentsResponse <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
public class GetShortCommentsResponse extends BaseResponse {

    @SerializedName("comments")
    public Comment[] comments;

    @Override
    public String toString() {
        return "GetShortCommentsResponse{" +
                "comments=" + Arrays.toString(comments) +
                "} " + super.toString();
    }
}