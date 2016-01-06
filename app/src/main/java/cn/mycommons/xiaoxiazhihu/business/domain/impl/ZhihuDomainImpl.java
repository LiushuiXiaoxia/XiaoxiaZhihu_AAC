package cn.mycommons.xiaoxiazhihu.business.domain.impl;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
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
import cn.mycommons.xiaoxiazhihu.core.net.NetWorkException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * ZhihuDomainImpl <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class ZhihuDomainImpl implements ZhihuDomain {

    @Inject
    ZhihuApi zhihuApi;

    @Override
    public Observable<GetStartInfoResponse> getStartInfo(final int width, final int height) {
        return Observable.just(new GetStartInfoRequest(width, height))
                .flatMap(new Func1<GetStartInfoRequest, Observable<GetStartInfoResponse>>() {
                    @Override
                    public Observable<GetStartInfoResponse> call(GetStartInfoRequest request) {
                        try {
                            GetStartInfoResponse response = zhihuApi.getStartInfoResponse(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<GetAllThemesResponse> getAllThemes() {
        return Observable.just(new GetAllThemesRequest())
                .flatMap(new Func1<GetAllThemesRequest, Observable<GetAllThemesResponse>>() {
                    @Override
                    public Observable<GetAllThemesResponse> call(GetAllThemesRequest request) {
                        try {
                            GetAllThemesResponse response = zhihuApi.getAllThemesResponse(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<GetLastThemeResponse> getLastTheme() {
        return Observable.just(new GetLastThemeRequest())
                .flatMap(new Func1<GetLastThemeRequest, Observable<GetLastThemeResponse>>() {
                    @Override
                    public Observable<GetLastThemeResponse> call(GetLastThemeRequest request) {
                        try {
                            GetLastThemeResponse response = zhihuApi.getLastThemeResponse(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<GetNewsResponse> getNewsById(int id) {
        return Observable.just(new GetNewsRequest(id))
                .flatMap(new Func1<GetNewsRequest, Observable<GetNewsResponse>>() {
                    @Override
                    public Observable<GetNewsResponse> call(GetNewsRequest request) {
                        try {
                            GetNewsResponse response = zhihuApi.getNewsResponse(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<GetThemeResponse> getThemeById(int id) {
        return Observable.just(new GetThemeRequest(id))
                .flatMap(new Func1<GetThemeRequest, Observable<GetThemeResponse>>() {
                    @Override
                    public Observable<GetThemeResponse> call(GetThemeRequest request) {
                        try {
                            GetThemeResponse response = zhihuApi.getThemeResponse(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<GetStoryExtraResponse> getStoryExtraById(int id) {
        return Observable.just(new GetStoryExtraRequest(id))
                .flatMap(new Func1<GetStoryExtraRequest, Observable<GetStoryExtraResponse>>() {
                    @Override
                    public Observable<GetStoryExtraResponse> call(GetStoryExtraRequest request) {
                        try {
                            GetStoryExtraResponse response = zhihuApi.getStoryExtraResponse(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<GetShortCommentsResponse> getShortCommentsById(int id) {
        return Observable.just(new GetShortCommentsRequest(id))
                .flatMap(new Func1<GetShortCommentsRequest, Observable<GetShortCommentsResponse>>() {
                    @Override
                    public Observable<GetShortCommentsResponse> call(GetShortCommentsRequest request) {
                        try {
                            GetShortCommentsResponse response = zhihuApi.getShortComments(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<GetLongCommentsResponse> getLongCommentsById(int id) {
        return Observable.just(new GetLongCommentsRequest(id))
                .flatMap(new Func1<GetLongCommentsRequest, Observable<GetLongCommentsResponse>>() {
                    @Override
                    public Observable<GetLongCommentsResponse> call(GetLongCommentsRequest request) {
                        try {
                            GetLongCommentsResponse response = zhihuApi.getLongComments(request);
                            return Observable.just(response);
                        } catch (NetWorkException e) {
                            return Observable.error(e);
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}