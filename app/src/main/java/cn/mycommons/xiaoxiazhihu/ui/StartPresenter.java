package cn.mycommons.xiaoxiazhihu.ui;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import rx.Observable;


/**
 * StartPresenter <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class StartPresenter extends BaseMvpPresenter<StartPresenter.IStartView> {

    @Inject
    ZhihuDomain zhihuDomain;

    public Observable<GetStartInfoResponse> doGetStartInfo() {
        return zhihuDomain.getStartInfo(1080, 1776);
    }

    public interface IStartView extends IMvpView {

    }
}