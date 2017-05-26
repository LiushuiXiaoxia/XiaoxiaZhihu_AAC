package cn.mycommons.xiaoxiazhihu.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.VisibleForTesting;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetStartInfoRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.util.SimpleObserver;

/**
 * StartViewModel <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public class StartViewModel extends ViewModel {

    private ZhihuApi zhihuApi;

    @VisibleForTesting
    private final MutableLiveData<GetStartInfoResponse> startInfo = new MutableLiveData<>();

    @Inject
    StartViewModel(ZhihuApi zhihuApi) {
        this.zhihuApi = zhihuApi;
    }

    LiveData<GetStartInfoResponse> getStartInfo() {
        zhihuApi.getStartInfoResponse(new GetStartInfoRequest(1080, 1776))
                .observeForever(new SimpleObserver<>(startInfo));
        return startInfo;
    }
}