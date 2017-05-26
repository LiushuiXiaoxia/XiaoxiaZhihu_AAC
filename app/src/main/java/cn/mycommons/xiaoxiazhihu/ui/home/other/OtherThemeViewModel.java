package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetThemeRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;
import cn.mycommons.xiaoxiazhihu.util.SimpleObserver;

/**
 * OtherThemeViewModel <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
public class OtherThemeViewModel extends ViewModel {

    private final ZhihuApi zhihuApi;
    private final MutableLiveData<GetThemeResponse> themeResponse = new MutableLiveData<>();

    @Inject
    OtherThemeViewModel(ZhihuApi zhihuApi) {
        this.zhihuApi = zhihuApi;
    }

    MutableLiveData<GetThemeResponse> getThemeResponse(int id) {
        zhihuApi.getThemeResponse(new GetThemeRequest(id)).observeForever(new SimpleObserver<>(themeResponse));

        return themeResponse;
    }
}