package cn.mycommons.xiaoxiazhihu.ui.home.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetNewsRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetStoryExtraRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.util.SimpleObserver;

/**
 * DetailViewModel <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
public class DetailViewModel extends ViewModel {

    private final ZhihuApi zhihuApi;
    private final MutableLiveData<GetNewsResponse> getNewsResponse = new MutableLiveData<>();
    private final MutableLiveData<GetStoryExtraResponse> getStoryExtra = new MutableLiveData<>();

    @Inject
    DetailViewModel(ZhihuApi zhihuApi) {
        this.zhihuApi = zhihuApi;
    }

    LiveData<GetNewsResponse> getGetNewsResponse(int id) {
        zhihuApi.getNewsResponse(new GetNewsRequest(id))
                .observeForever(new SimpleObserver<>(getNewsResponse));

        return getNewsResponse;
    }

    LiveData<GetStoryExtraResponse> getGetStoryExtra(int id) {
        zhihuApi.getStoryExtraResponse(new GetStoryExtraRequest(id))
                .observeForever(new SimpleObserver<>(getStoryExtra));

        return getStoryExtra;
    }
}