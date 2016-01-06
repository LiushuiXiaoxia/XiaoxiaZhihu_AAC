package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * StartInfoResponse <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class GetStartInfoResponse extends BaseResponse {

    @SerializedName("text")
    public String text;

    @SerializedName("img")
    public String img;

    @Override
    public String toString() {
        return "StartInfoResponse{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                "} " + super.toString();
    }
}