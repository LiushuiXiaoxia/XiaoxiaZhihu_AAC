package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.callback.SimpleSubscriber;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;

/**
 * HotNewsViewModel <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public class HotNewsViewModel extends ViewModel {

    ZhihuDomain zhihuDomain;

    private final MutableLiveData<GetLastThemeResponse> lastThemeResponse;

    @Inject
    public HotNewsViewModel(ZhihuDomain zhihuDomain) {
        this.zhihuDomain = zhihuDomain;
        lastThemeResponse = new MutableLiveData<>();
    }

    LiveData<GetLastThemeResponse> getLastThemeResponse() {
        zhihuDomain.getLastTheme().subscribe(new SimpleSubscriber<GetLastThemeResponse>() {
            @Override
            public void onHandleSuccess(GetLastThemeResponse response) {
                super.onHandleSuccess(response);

                lastThemeResponse.postValue(response);
            }
        });
        return lastThemeResponse;
    }
}