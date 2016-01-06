package cn.mycommons.xiaoxiazhihu.business.api.okhttp;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * OkHttpUtil <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class OkHttpUtil {

    static final int HTTP_TIME_OUT = 15;

    public static OkHttpClient newOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.setReadTimeout(HTTP_TIME_OUT, TimeUnit.SECONDS);
        return client;
    }

    public static CacheControl getCacheControl() {
        return new CacheControl.Builder().noCache().build();
    }
}