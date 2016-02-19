package cn.mycommons.xiaoxiazhihu.ui.home;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import rx.Observable;


/**
 * HotnewsPresenter <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class HotnewsPresenter extends BaseMvpPresenter<HotnewsPresenter.IHotnewsView> {

    @Inject
    ZhihuDomain zhihuDomain;

    public Observable<GetLastThemeResponse> doGetLastTheme() {
        return zhihuDomain.getLastTheme();
    }

    public interface IHotnewsView extends IMvpView {

    }
}