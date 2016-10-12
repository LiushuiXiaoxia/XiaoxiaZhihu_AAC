package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetStoryExtraResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetStoryExtraResponse extends BaseResponse {

    @SerializedName("long_comments")
    private int longComments;

    @SerializedName("popularity")
    private int popularity;

    @SerializedName("short_comments")
    private int shortComments;

    @SerializedName("comments")
    private int comments;

    public int getLongComments() {
        return longComments;
    }

    public void setLongComments(int longComments) {
        this.longComments = longComments;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getShortComments() {
        return shortComments;
    }

    public void setShortComments(int shortComments) {
        this.shortComments = shortComments;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

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