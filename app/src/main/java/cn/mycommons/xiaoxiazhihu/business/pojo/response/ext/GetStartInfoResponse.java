package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * StartInfoResponse <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class GetStartInfoResponse extends BaseResponse {

    @SerializedName("text")
    private String text;

    @SerializedName("img")
    private String img;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "StartInfoResponse{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                "} " + super.toString();
    }
}