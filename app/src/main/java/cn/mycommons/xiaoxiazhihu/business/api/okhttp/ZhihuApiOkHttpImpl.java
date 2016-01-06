package cn.mycommons.xiaoxiazhihu.business.api.okhttp;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import cn.mycommons.xiaoxiazhihu.business.api.ZhihuApi;
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

/**
 * ZhihuApiImpl <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class ZhihuApiOkHttpImpl implements ZhihuApi {

    OkHttpClient okHttpClient;
    Gson gson;

    public ZhihuApiOkHttpImpl() {
        okHttpClient = OkHttpUtil.newOkHttpClient();
        gson = new Gson();
    }

    @Override
    public GetStartInfoResponse getStartInfoResponse(GetStartInfoRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getStartInfoResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/start-image/%d*%d";
        url = String.format(url, request.width, request.height);
        GetStartInfoResponse response = get(url, GetStartInfoResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    @Override
    public GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getAllThemesResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/themes";
        GetAllThemesResponse response = get(url, GetAllThemesResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    @Override
    public GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getLastThemeResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/news/latest";
        GetLastThemeResponse response = get(url, GetLastThemeResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    @Override
    public GetNewsResponse getNewsResponse(GetNewsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getNewsResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/news/%s";
        url = String.format(url, request.id);
        GetNewsResponse response = get(url, GetNewsResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    @Override
    public GetThemeResponse getThemeResponse(GetThemeRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getThemeResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/theme/%s";
        url = String.format(url, request.id);
        GetThemeResponse response = get(url, GetThemeResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    @Override
    public GetStoryExtraResponse getStoryExtraResponse(GetStoryExtraRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getStoryExtraResponse request = " + request);

        String url = "http://news-at.zhihu.com/api/4/story-extra/%s";
        url = String.format(url, request.id);
        GetStoryExtraResponse response = get(url, GetStoryExtraResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    @Override
    public GetShortCommentsResponse getShortComments(GetShortCommentsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getShortComments request = " + request);

        String url = "http://news-at.zhihu.com/api/4/story/%s/short-comments";
        url = String.format(url, request.id);
        GetShortCommentsResponse response = get(url, GetShortCommentsResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    @Override
    public GetLongCommentsResponse getLongComments(GetLongCommentsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getLongComments request = " + request);

        String url = "http://news-at.zhihu.com/api/4/story/%s/long-comments";
        url = String.format(url, request.id);
        GetLongCommentsResponse response = get(url, GetLongCommentsResponse.class);

        XLog.i("req = %s, resp = %s", request, response);

        return response;
    }

    <T> T get(String url, Class<T> tClass) throws NetWorkException {
        XLog.i("ZhihuApiOkHttpImpl.get url = " + url);
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
            XLog.e("ZhihuApiOkHttpImpl.get e = " + e, e);
            throw new NetWorkException(e);
        }
        return t;
    }
}