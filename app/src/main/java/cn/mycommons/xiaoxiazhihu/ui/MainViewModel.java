package cn.mycommons.xiaoxiazhihu.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.biz.pojo.request.ext.GetAllThemesRequest;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.util.SimpleObserver;

/**
 * MainViewModel <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public class MainViewModel extends ViewModel {

    private ZhihuApi zhihuApi;
    private final MutableLiveData<GetAllThemesResponse> allThemeResponse = new MutableLiveData<>();

    @Inject
    MainViewModel(ZhihuApi zhihuApi) {
        this.zhihuApi = zhihuApi;
    }

    LiveData<GetAllThemesResponse> loadAllTheme() {
        zhihuApi.getAllThemesResponse(new GetAllThemesRequest())
                .observeForever(new SimpleObserver<>(allThemeResponse));
        return allThemeResponse;
    }
}