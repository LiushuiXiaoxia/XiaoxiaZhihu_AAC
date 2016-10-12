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
    private int id;
    @SerializedName("type")
    private int type;
    @SerializedName("title")
    private String title;
    @SerializedName("image")
    private String image;
    @SerializedName("image_source")
    private String imageSource;
    @SerializedName("body")
    private String body;
    @SerializedName("share_url")
    private String shareUrl;
    @SerializedName("css")
    private String[] css;
    @SerializedName("js")
    private String[] js;
    @SerializedName("ga_prefix")
    private String gaPrefix;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String[] getCss() {
        return css;
    }

    public void setCss(String[] css) {
        this.css = css;
    }

    public String[] getJs() {
        return js;
    }

    public void setJs(String[] js) {
        this.js = js;
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

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