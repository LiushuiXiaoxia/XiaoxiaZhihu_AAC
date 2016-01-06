package cn.mycommons.xiaoxiazhihu.ui.home;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import rx.Observable;


/**
 * HotnewsPresenter <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class HotnewsPresenter extends BaseMvpPresenter<HotnewsPresenter.IHotnewsView> {

    @Inject
    ZhihuDomain zhihuDomain;

    /**
     * 子类的Presenter必须加上{@link Inject}注解
     *
     * @param loadDataView 载入Data的View模型
     * @param view         子Presenter需要实现的View模型，类型由泛型指定
     */
    @Inject
    public HotnewsPresenter(ILoadDataView loadDataView, IHotnewsView view) {
        super(loadDataView, view);
    }

    public Observable<GetLastThemeResponse> doGetLastTheme() {
        return zhihuDomain.getLastTheme();
    }

    public interface IHotnewsView extends IMvpView {

    }
}