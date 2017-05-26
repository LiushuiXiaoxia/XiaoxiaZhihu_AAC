package cn.mycommons.xiaoxiazhihu.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetLongCommentsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetShortCommentsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.util.SimpleObserver;

/**
 * CommentsViewModel <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
public class CommentsViewModel extends ViewModel {

    private final ZhihuApi zhihuApi;
    private boolean isLoadShort = false;
    private final MutableLiveData<GetShortCommentsResponse> shortCommentsResponse = new MutableLiveData<>();
    private final MutableLiveData<GetLongCommentsResponse> longCommentsResponse = new MutableLiveData<>();

    @Inject
    CommentsViewModel(ZhihuApi zhihuApi) {
        this.zhihuApi = zhihuApi;
    }

    MutableLiveData<GetLongCommentsResponse> getLongCommentsResponse(int id) {
        zhihuApi.getLongComments(new GetLongCommentsRequest(id))
                .observeForever(new SimpleObserver<>(longCommentsResponse));

        return longCommentsResponse;
    }

    MutableLiveData<GetShortCommentsResponse> getShortCommentsResponse(int id) {
        isLoadShort = true;
        zhihuApi.getShortComments(new GetShortCommentsRequest(id))
                .observeForever(new SimpleObserver<>(shortCommentsResponse));

        return shortCommentsResponse;
    }

    boolean isLoadShort() {
        return isLoadShort;
    }
}