package cn.mycommons.xiaoxiazhihu.biz.api.impl.okhttp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import java.io.IOException;

import cn.mycommons.xiaoxiazhihu.app.InjectHelp;
import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.api.impl.OkHttpUtil;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetAllThemesRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetLastThemeRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetLongCommentsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetNewsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetShortCommentsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetStartInfoRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetStoryExtraRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetThemeRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;
import cn.mycommons.xiaoxiazhihu.core.log.AppLog;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * ZhihuApiImpl <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class ZhihuApiOkHttpImpl implements ZhihuApi {

    private OkHttpClient okHttpClient;
    private Gson gson;

    public ZhihuApiOkHttpImpl(OkHttpClient client) {
        okHttpClient = client;
        gson = InjectHelp.appComponent().gson();
    }

    @Override
    public LiveData<GetStartInfoResponse> getStartInfoResponse(GetStartInfoRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getStartInfoResponse request = " + request);

        String url = "https://news-at.zhihu.com/api/4/start-image/%s*%s";
        url = String.format(url, request.width, request.height);

        MutableLiveData<GetStartInfoResponse> data = new MutableLiveData<>();
        call(url, GetStartInfoResponse.class, data);

        return data;
    }

    @Override
    public LiveData<GetAllThemesResponse> getAllThemesResponse(GetAllThemesRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getAllThemesResponse request = " + request);

        String url = "https://news-at.zhihu.com/api/4/themes";

        MutableLiveData<GetAllThemesResponse> data = new MutableLiveData<>();
        call(url, GetAllThemesResponse.class, data);

        return data;
    }

    @Override
    public LiveData<GetLastThemeResponse> getLastThemeResponse(GetLastThemeRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getLastThemeResponse request = " + request);

        String url = "https://news-at.zhihu.com/api/4/news/latest";

        MutableLiveData<GetLastThemeResponse> data = new MutableLiveData<>();
        call(url, GetLastThemeResponse.class, data);

        return data;
    }

    @Override
    public LiveData<GetNewsResponse> getNewsResponse(GetNewsRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getNewsResponse request = " + request);

        String url = "https://news-at.zhihu.com/api/4/news/%s";
        url = String.format(url, request.id);

        MutableLiveData<GetNewsResponse> data = new MutableLiveData<>();
        call(url, GetNewsResponse.class, data);

        return data;
    }

    @Override
    public LiveData<GetThemeResponse> getThemeResponse(GetThemeRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getThemeResponse request = " + request);

        String url = "https://news-at.zhihu.com/api/4/theme/%s";
        url = String.format(url, request.id);

        MutableLiveData<GetThemeResponse> data = new MutableLiveData<>();
        call(url, GetThemeResponse.class, data);

        return data;
    }

    @Override
    public LiveData<GetStoryExtraResponse> getStoryExtraResponse(GetStoryExtraRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getStoryExtraResponse request = " + request);

        String url = "https://news-at.zhihu.com/api/4/story-extra/%s";
        url = String.format(url, request.id);

        MutableLiveData<GetStoryExtraResponse> data = new MutableLiveData<>();
        call(url, GetStoryExtraResponse.class, data);

        return data;
    }

    @Override
    public LiveData<GetShortCommentsResponse> getShortComments(GetShortCommentsRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getShortComments request = " + request);

        String url = "https://news-at.zhihu.com/api/4/story/%s/short-comments";
        url = String.format(url, request.id);

        MutableLiveData<GetShortCommentsResponse> data = new MutableLiveData<>();
        call(url, GetShortCommentsResponse.class, data);

        return data;
    }

    @Override
    public LiveData<GetLongCommentsResponse> getLongComments(GetLongCommentsRequest request) {
        AppLog.d("ZhihuApiOkHttpImpl.getLongComments request = " + request);

        String url = "https://news-at.zhihu.com/api/4/story/%s/long-comments";
        url = String.format(url, request.id);

        MutableLiveData<GetLongCommentsResponse> data = new MutableLiveData<>();
        call(url, GetLongCommentsResponse.class, data);

        return data;
    }

    private <T> void call(final String url, final Class<T> tClass, final MutableLiveData<T> data) {
        AppLog.i("ZhihuApiOkHttpImpl.call url = " + url);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .cacheControl(OkHttpUtil.getCacheControl())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                AppLog.i("ZhihuApiOkHttpImpl.call url = " + url);
                AppLog.e("ZhihuApiOkHttpImpl.call e = " + e, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                AppLog.i("ZhihuApiOkHttpImpl.call url = " + url);

                AppLog.i("response = " + response);

                if (response != null && response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        data.postValue(gson.fromJson(body.string(), tClass));
                    } else {
                        data.postValue(null);
                    }
                }
            }
        });
    }
}