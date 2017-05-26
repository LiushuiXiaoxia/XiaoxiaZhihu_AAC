package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.biz.callback.SimpleSubscriber;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;

/**
 * OtherThemeViewModel <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
public class OtherThemeViewModel extends ViewModel {

    ZhihuDomain zhihuDomain;

    private final MutableLiveData<GetThemeResponse> themeResponse = new MutableLiveData<>();

    @Inject
    public OtherThemeViewModel(ZhihuDomain zhihuDomain) {
        this.zhihuDomain = zhihuDomain;
    }

    MutableLiveData<GetThemeResponse> getThemeResponse(int id) {
        zhihuDomain.getThemeById(id)
                .subscribe(new SimpleSubscriber<GetThemeResponse>() {
                    @Override
                    public void onHandleSuccess(GetThemeResponse response) {
                        super.onHandleSuccess(response);
                        themeResponse.setValue(response);
                    }
                });
        return themeResponse;
    }
}