package cn.mycommons.xiaoxiazhihu.business.pojo.response.ext;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import cn.mycommons.xiaoxiazhihu.business.pojo.bean.ThemeItem;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.BaseResponse;

/**
 * GetAllThemesResponse <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class GetAllThemesResponse extends BaseResponse {

    @SerializedName("limit")
    public int limit;

    @SerializedName("subscribed")
    public Object[] subscribed;

    @SerializedName("others")
    public ThemeItem[] others;

    @Override
    public String toString() {
        return "GetAllThemesResponse{" +
                "limit=" + limit +
                ", subscribed=" + Arrays.toString(subscribed) +
                ", others=" + Arrays.toString(others) +
                "} " + super.toString();
    }
}