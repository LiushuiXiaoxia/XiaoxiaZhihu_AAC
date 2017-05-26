package cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit;


import android.arch.lifecycle.LiveData;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
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

/**
 * ZhihuApiRetrofitImpl <br/>
 * Created by xiaqiulei on 2016-01-10.
 */
public final class ZhihuApiRetrofitImpl implements ZhihuApi {

    private final IZhihuRetrofitApi httpApi;

    public ZhihuApiRetrofitImpl(IZhihuRetrofitApi httpApi) {
        this.httpApi = httpApi;
    }

    @Override
    public LiveData<GetStartInfoResponse> getStartInfoResponse(GetStartInfoRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.getStartInfoResponse request = " + request);

        return httpApi.getStartInfoResponse(request.width, request.height);
    }

    @Override
    public LiveData<GetAllThemesResponse> getAllThemesResponse(GetAllThemesRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.getAllThemesResponse request = " + request);
        return httpApi.getAllThemesResponse();
    }

    @Override
    public LiveData<GetLastThemeResponse> getLastThemeResponse(GetLastThemeRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.getLastThemeResponse request = " + request);

        return httpApi.getLastThemeResponse();
    }

    @Override
    public LiveData<GetNewsResponse> getNewsResponse(GetNewsRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.getNewsResponse request = " + request);

        return httpApi.getNewsResponse(request.id);
    }

    @Override
    public LiveData<GetThemeResponse> getThemeResponse(GetThemeRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.getThemeResponse request = " + request);

        return httpApi.getThemeResponse(request.id);
    }

    @Override
    public LiveData<GetStoryExtraResponse> getStoryExtraResponse(GetStoryExtraRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.getStoryExtraResponse request = " + request);

        return httpApi.getStoryExtraResponse(request.id);
    }

    @Override
    public LiveData<GetShortCommentsResponse> getShortComments(GetShortCommentsRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.getShortComments request = " + request);

        return httpApi.getShortComments(request.id);
    }

    @Override
    public LiveData<GetLongCommentsResponse> getLongComments(GetLongCommentsRequest request) {
        AppLog.i("ZhihuApiRetrofitImpl.GetStartInfoResponse request = " + request);

        return httpApi.getLongComments(request.id);
    }
}