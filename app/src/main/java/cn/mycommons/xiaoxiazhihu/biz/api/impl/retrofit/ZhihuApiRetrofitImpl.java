package cn.mycommons.xiaoxiazhihu.biz.api.impl.retrofit;


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
import cn.mycommons.xiaoxiazhihu.core.net.AppException;

/**
 * ZhihuApiRetrofitImpl <br/>
 * Created by xiaqiulei on 2016-01-10.
 */
public class ZhihuApiRetrofitImpl implements ZhihuApi {

    private IZhihuRetrofitApi httpApi;

    public ZhihuApiRetrofitImpl(IZhihuRetrofitApi httpApi) {
        this.httpApi = httpApi;
    }

    @Override
    public GetStartInfoResponse getStartInfoResponse(final GetStartInfoRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.getStartInfoResponse request = " + request);

        return new RetrofitAdapter<GetStartInfoResponse>() {
            @Override
            GetStartInfoResponse call() throws Exception {
                return httpApi.getStartInfoResponse(request.width, request.height).execute().body();
            }
        }.get();
    }

    @Override
    public GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.getAllThemesResponse request = " + request);
        return new RetrofitAdapter<GetAllThemesResponse>() {
            @Override
            GetAllThemesResponse call() throws Exception {
                return httpApi.getAllThemesResponse().execute().body();
            }
        }.get();
    }

    @Override
    public GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.getLastThemeResponse request = " + request);
        return new RetrofitAdapter<GetLastThemeResponse>() {
            @Override
            GetLastThemeResponse call() throws Exception {
                return httpApi.getLastThemeResponse().execute().body();
            }
        }.get();
    }

    @Override
    public GetNewsResponse getNewsResponse(final GetNewsRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.getNewsResponse request = " + request);
        return new RetrofitAdapter<GetNewsResponse>() {
            @Override
            GetNewsResponse call() throws Exception {
                return httpApi.getNewsResponse(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetThemeResponse getThemeResponse(final GetThemeRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.getThemeResponse request = " + request);
        return new RetrofitAdapter<GetThemeResponse>() {
            @Override
            GetThemeResponse call() throws Exception {
                return httpApi.getThemeResponse(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetStoryExtraResponse getStoryExtraResponse(final GetStoryExtraRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.getStoryExtraResponse request = " + request);
        return new RetrofitAdapter<GetStoryExtraResponse>() {
            @Override
            GetStoryExtraResponse call() throws Exception {
                return httpApi.getStoryExtraResponse(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetShortCommentsResponse getShortComments(final GetShortCommentsRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.getShortComments request = " + request);
        return new RetrofitAdapter<GetShortCommentsResponse>() {
            @Override
            GetShortCommentsResponse call() throws Exception {
                return httpApi.getShortComments(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetLongCommentsResponse getLongComments(final GetLongCommentsRequest request) throws AppException {
        AppLog.i("ZhihuApiRetrofitImpl.GetStartInfoResponse request = " + request);
        return new RetrofitAdapter<GetLongCommentsResponse>() {
            @Override
            GetLongCommentsResponse call() throws Exception {
                return httpApi.getLongComments(request.id).execute().body();
            }
        }.get();
    }
}