package cn.mycommons.xiaoxiazhihu.business.api.okhttp;


import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.OkHttpClient;

/**
 * OkHttpUtil <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class OkHttpUtil {

    private static final int HTTP_TIME_OUT = 15;

    public static OkHttpClient newOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(HTTP_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public static CacheControl getCacheControl() {
        return new CacheControl.Builder().noCache().build();
    }
}