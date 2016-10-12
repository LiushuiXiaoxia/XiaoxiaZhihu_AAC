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
    private Comment[] comments;

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "GetShortCommentsResponse{" +
                "comments=" + Arrays.toString(comments) +
                "} " + super.toString();
    }
}