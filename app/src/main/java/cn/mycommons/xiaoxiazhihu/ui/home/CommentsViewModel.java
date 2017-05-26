package cn.mycommons.xiaoxiazhihu.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.callback.SimpleSubscriber;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;

/**
 * CommentsViewModel <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
public class CommentsViewModel extends ViewModel {

    private final ZhihuDomain zhihuDomain;
    private boolean isLoadShort = false;
    private final MutableLiveData<GetShortCommentsResponse> shortCommentsResponse = new MutableLiveData<>();
    private final MutableLiveData<GetLongCommentsResponse> longCommentsResponse = new MutableLiveData<>();

    @Inject
    public CommentsViewModel(ZhihuDomain zhihuDomain) {
        this.zhihuDomain = zhihuDomain;
    }

    MutableLiveData<GetLongCommentsResponse> getLongCommentsResponse(int id) {
        zhihuDomain.getLongCommentsById(id)
                .subscribe(new SimpleSubscriber<GetLongCommentsResponse>() {
                    @Override
                    public void onHandleSuccess(GetLongCommentsResponse response) {
                        super.onHandleSuccess(response);

                        longCommentsResponse.setValue(response);
                    }
                });
        return longCommentsResponse;
    }

    MutableLiveData<GetShortCommentsResponse> getShortCommentsResponse(int id) {
        isLoadShort = true;
        zhihuDomain.getShortCommentsById(id)
                .subscribe(new SimpleSubscriber<GetShortCommentsResponse>() {
                    @Override
                    public void onHandleSuccess(GetShortCommentsResponse response) {
                        super.onHandleSuccess(response);

                        shortCommentsResponse.setValue(response);
                    }
                });
        return shortCommentsResponse;
    }

    boolean isLoadShort() {
        return isLoadShort;
    }
}