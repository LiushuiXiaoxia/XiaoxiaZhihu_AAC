package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetNewsResponse <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetNewsResponse extends BaseResponse {
    @SerializedName("id")
    public int id;
    @SerializedName("type")
    public int type;
    @SerializedName("title")
    public String title;
    @SerializedName("image")
    public String image;
    @SerializedName("image_source")
    public String imageSource;
    @SerializedName("body")
    public String body;
    @SerializedName("share_url")
    public String shareUrl;
    @SerializedName("css")
    public String[] css;
    @SerializedName("js")
    public String[] js;
    @SerializedName("ga_prefix")
    public String gaPrefix;

    @Override
    public String toString() {
        return "GetNewsResponse{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", imageSource='" + imageSource + '\'' +
                ", body='" + body + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", css=" + Arrays.toString(css) +
                ", js=" + Arrays.toString(js) +
                ", gaPrefix='" + gaPrefix + '\'' +
                "} " + super.toString();
    }
}