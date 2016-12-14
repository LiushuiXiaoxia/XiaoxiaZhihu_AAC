package cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext;

import cn.mycommons.xiaoxiazhihu.biz.pojo.request.BaseRequest;

/**
 * GetThemeRequest <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetThemeRequest extends BaseRequest {

    public int id;

    public GetThemeRequest(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetThemeRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}