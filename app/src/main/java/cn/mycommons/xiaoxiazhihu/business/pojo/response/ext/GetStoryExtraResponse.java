package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetStoryExtraResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetStoryExtraResponse extends BaseResponse {

    @SerializedName("long_comments")
    public int longComments;
    @SerializedName("popularity")
    public int popularity;
    @SerializedName("short_comments")
    public int shortComments;
    @SerializedName("comments")
    public int comments;

    @Override
    public String toString() {
        return "GetStoryExtraResponse{" +
                "longComments=" + longComments +
                ", popularity=" + popularity +
                ", shortComments=" + shortComments +
                ", comments=" + comments +
                "} " + super.toString();
    }
}