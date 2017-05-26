package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetLastThemeRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.util.SimpleObserver;

/**
 * HotNewsViewModel <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public class HotNewsViewModel extends ViewModel {

    private final ZhihuApi zhihuDomain;
    private final MutableLiveData<GetLastThemeResponse> lastThemeResponse;

    @Inject
    HotNewsViewModel(ZhihuApi zhihuDomain) {
        this.zhihuDomain = zhihuDomain;
        lastThemeResponse = new MutableLiveData<>();
    }

    LiveData<GetLastThemeResponse> getLastThemeResponse() {
        zhihuDomain.getLastThemeResponse(new GetLastThemeRequest())
                .observeForever(new SimpleObserver<>(lastThemeResponse));

        return lastThemeResponse;
    }
}