package cn.mycommons.xiaoxiazhihu.ui.home.detail;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.callback.SimpleSubscriber;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;

/**
 * DetailViewModel <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
public class DetailViewModel extends ViewModel {

    private final ZhihuDomain domain;
    private final MutableLiveData<GetNewsResponse> getNewsResponse = new MutableLiveData<>();
    private final MutableLiveData<GetStoryExtraResponse> getStoryExtra = new MutableLiveData<>();

    @Inject
    public DetailViewModel(ZhihuDomain domain) {
        this.domain = domain;
    }

    public MutableLiveData<GetNewsResponse> getGetNewsResponse(int id) {
        domain.getNewsById(id)
                .subscribe(new SimpleSubscriber<GetNewsResponse>() {
                    @Override
                    public void onHandleSuccess(GetNewsResponse response) {
                        super.onHandleSuccess(response);

                        getNewsResponse.setValue(response);
                    }
                });
        return getNewsResponse;
    }

    public MutableLiveData<GetStoryExtraResponse> getGetStoryExtra(int id) {
        domain.getStoryExtraById(id).subscribe(new SimpleSubscriber<GetStoryExtraResponse>() {

            @Override
            public void onHandleSuccess(GetStoryExtraResponse response) {
                super.onHandleSuccess(response);
                getStoryExtra.setValue(response);
            }
        });
        return getStoryExtra;
    }
}