package cn.mycommons.xiaoxiazhihu.business.api.impl.okhttp;

import com.google.gson.Gson;

import java.io.IOException;

import cn.mycommons.xiaoxiazhihu.business.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.business.api.impl.OkHttpUtil;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetAllThemesRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetLastThemeRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetLongCommentsRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetNewsRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetShortCommentsRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetStartInfoRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetStoryExtraRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetThemeRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetThemeResponse;
import cn.mycommons.xiaoxiazhihu.core.log.XLog;
import cn.mycommons.xiaoxiazhihu.core.net.NetWorkException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ZhihuApiImpl <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class ZhihuApiOkHttpImpl implements ZhihuApi {

    private static final String MSG = "req = %s, resp = %s";

    private OkHttpClient okHttpClient;
    private Gson gson;

    public ZhihuApiOkHttpImpl(OkHttpClient client) {
        okHttpClient = client;
        gson = new Gson();
    }

    @Override
    public GetStartInfoResponse getStartInfoResponse(GetStartInfoRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getStartInfoResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/start-image/%d*%d";
        url = String.format(url, request.width, request.height);
        GetStartInfoResponse response = call(url, GetStartInfoResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getAllThemesResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/themes";
        GetAllThemesResponse response = call(url, GetAllThemesResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getLastThemeResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/news/latest";
        GetLastThemeResponse response = call(url, GetLastThemeResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetNewsResponse getNewsResponse(GetNewsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getNewsResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/news/%s";
        url = String.format(url, request.id);
        GetNewsResponse response = call(url, GetNewsResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetThemeResponse getThemeResponse(GetThemeRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getThemeResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/theme/%s";
        url = String.format(url, request.id);
        GetThemeResponse response = call(url, GetThemeResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetStoryExtraResponse getStoryExtraResponse(GetStoryExtraRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getStoryExtraResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/story-extra/%s";
        url = String.format(url, request.id);
        GetStoryExtraResponse response = call(url, GetStoryExtraResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetShortCommentsResponse getShortComments(GetShortCommentsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getShortComments request = " + request);

        String url = "http://news-at.zhihu.com/api/4/story/%s/short-comments";
        url = String.format(url, request.id);
        GetShortCommentsResponse response = call(url, GetShortCommentsResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetLongCommentsResponse getLongComments(GetLongCommentsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getLongComments request = " + request);

        String url = "http://news-at.zhihu.com/api/4/story/%s/long-comments";
        url = String.format(url, request.id);
        GetLongCommentsResponse response = call(url, GetLongCommentsResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    <T> T call(String url, Class<T> tClass) throws NetWorkException {
        XLog.i("ZhihuApiOkHttpImpl.call url = " + url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .cacheControl(OkHttpUtil.getCacheControl())
                .build();

        T t = null;
        try {
            Response response = okHttpClient.newCall(request).execute();
            XLog.i("response = " + response);
            if (response != null && response.isSuccessful()) {
                String body = response.body().string();
                t = gson.fromJson(body, tClass);
            }
        } catch (IOException e) {
            XLog.e("ZhihuApiOkHttpImpl.call e = " + e, e);
            throw new NetWorkException(e);
        }
        return t;
    }
}