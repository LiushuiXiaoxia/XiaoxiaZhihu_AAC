package cn.mycommons.xiaoxiazhihu.biz.api.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.mycommons.xiaoxiazhihu.core.log.AppLog;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * OkHttpUtil <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class OkHttpUtil {

    private static final int HTTP_TIME_OUT = 15;

    public static OkHttpClient newOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                AppLog.d("HttpLoggingInterceptor = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // set time out interval
        builder.readTimeout(HTTP_TIME_OUT, TimeUnit.MINUTES);
        builder.connectTimeout(HTTP_TIME_OUT, TimeUnit.MINUTES);
        builder.writeTimeout(HTTP_TIME_OUT, TimeUnit.MINUTES);
        builder.addInterceptor(loggingInterceptor);
        builder.interceptors()
                .add(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response response = chain.proceed(request);
                        AppLog.i("Interceptor:request = %s, response = %s", request, response);
                        return response;
                    }
                });
        return builder.build();
    }

    public static CacheControl getCacheControl() {
        return new CacheControl.Builder().noCache().build();
    }

    private OkHttpUtil() {
    }
}