package cn.mycommons.xiaoxiazhihu.ui;


import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.app.InjectHelp;
import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import rx.Observable;


/**
 * MainPresenter <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class MainPresenter extends BaseMvpPresenter<MainPresenter.IMenuListView> {

    @Inject
    ZhihuDomain zhihuDomain;

    @Override
    public void create(ILoadDataView loadDataView, IMenuListView view) {
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    public Observable<GetAllThemesResponse> doGetAllThemesResponse() {
        return zhihuDomain.getAllThemes();
    }

    public interface IMenuListView extends IMvpView {

    }
}