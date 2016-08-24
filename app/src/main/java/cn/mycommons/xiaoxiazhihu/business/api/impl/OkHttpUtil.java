package cn.mycommons.xiaoxiazhihu.business.api.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.mycommons.xiaoxiazhihu.core.log.XLog;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttpUtil <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class OkHttpUtil {

    private static final int HTTP_TIME_OUT = 15;

    public static OkHttpClient newOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // set time out interval
        builder.readTimeout(HTTP_TIME_OUT, TimeUnit.MINUTES);
        builder.connectTimeout(HTTP_TIME_OUT, TimeUnit.MINUTES);
        builder.writeTimeout(HTTP_TIME_OUT, TimeUnit.MINUTES);
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                XLog.i("Interceptor:request = %s, response = %s", request, response);
                return response;
            }
        });
        return builder.build();
    }

    public static CacheControl getCacheControl() {
        return new CacheControl.Builder().noCache().build();
    }
}