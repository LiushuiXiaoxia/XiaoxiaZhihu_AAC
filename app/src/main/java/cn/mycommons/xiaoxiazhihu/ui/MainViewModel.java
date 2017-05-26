package cn.mycommons.xiaoxiazhihu.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.callback.SimpleSubscriber;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetAllThemesResponse;

/**
 * MainViewModel <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public class MainViewModel extends ViewModel {

    ZhihuDomain zhihuDomain;

    private final MutableLiveData<GetAllThemesResponse> allThemeResponse;

    @Inject
    public MainViewModel(ZhihuDomain zhihuDomain) {
        this.zhihuDomain = zhihuDomain;
        allThemeResponse = new MutableLiveData<>();
    }

    void loadAllTheme() {
        zhihuDomain.getAllThemes().subscribe(new SimpleSubscriber<GetAllThemesResponse>() {
            @Override
            public void onHandleSuccess(GetAllThemesResponse response) {
                super.onHandleSuccess(response);

                allThemeResponse.postValue(response);
            }
        });
    }

    MutableLiveData<GetAllThemesResponse> getAllThemeResponse() {
        return allThemeResponse;
    }
}