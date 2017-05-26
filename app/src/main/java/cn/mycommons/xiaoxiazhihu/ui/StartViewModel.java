package cn.mycommons.xiaoxiazhihu.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.VisibleForTesting;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.callback.SimpleSubscriber;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStartInfoResponse;

/**
 * StartViewModel <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public class StartViewModel extends ViewModel {

    private ZhihuDomain zhihuDomain;

    @VisibleForTesting
    private final MutableLiveData<GetStartInfoResponse> startInfo = new MutableLiveData<>();

    @Inject
    public StartViewModel(ZhihuDomain zhihuDomain) {
        this.zhihuDomain = zhihuDomain;
    }

    LiveData<GetStartInfoResponse> getStartInfo() {
        zhihuDomain.getStartInfo(1080, 1776)
                .subscribe(new SimpleSubscriber<GetStartInfoResponse>() {
                    @Override
                    public void onHandleSuccess(GetStartInfoResponse response) {
                        super.onHandleSuccess(response);

                        startInfo.setValue(getResponse());
                    }
                });
        return startInfo;
    }
}