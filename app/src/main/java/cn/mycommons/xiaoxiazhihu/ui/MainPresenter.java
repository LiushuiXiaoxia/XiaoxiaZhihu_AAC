package cn.mycommons.xiaoxiazhihu.ui;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import rx.Observable;


/**
 * MainPresenter <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class MainPresenter extends BaseMvpPresenter<MainPresenter.IMenuListView> {

    @Inject
    ZhihuDomain zhihuDomain;

    /**
     * 子类的Presenter必须加上{@link Inject}注解
     *
     * @param loadDataView 载入Data的View模型
     * @param view         子Presenter需要实现的View模型，类型由泛型指定
     */
    @Inject
    public MainPresenter(ILoadDataView loadDataView, IMenuListView view) {
        super(loadDataView, view);
    }

    public Observable<GetAllThemesResponse> doGetAllThemesResponse() {
        return zhihuDomain.getAllThemes();
    }

    public interface IMenuListView extends IMvpView {

    }
}