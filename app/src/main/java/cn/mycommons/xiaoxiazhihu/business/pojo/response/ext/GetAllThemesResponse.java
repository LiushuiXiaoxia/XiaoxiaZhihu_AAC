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
    private int limit;

    @SerializedName("subscribed")
    private Object[] subscribed;

    @SerializedName("others")
    private ThemeItem[] others;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Object[] getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Object[] subscribed) {
        this.subscribed = subscribed;
    }

    public ThemeItem[] getOthers() {
        return others;
    }

    public void setOthers(ThemeItem[] others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "GetAllThemesResponse{" +
                "limit=" + limit +
                ", subscribed=" + Arrays.toString(subscribed) +
                ", others=" + Arrays.toString(others) +
                "} " + super.toString();
    }
}