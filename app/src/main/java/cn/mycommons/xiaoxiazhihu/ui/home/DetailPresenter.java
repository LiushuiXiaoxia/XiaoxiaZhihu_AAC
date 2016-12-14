package cn.mycommons.xiaoxiazhihu.ui.home;


import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.app.InjectHelp;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import rx.Observable;


/**
 * DetailPresenter <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class DetailPresenter extends BaseMvpPresenter<DetailPresenter.IDetailView> {

    @Inject
    ZhihuDomain domain;

    @Override
    public void create(ILoadDataView loadDataView, IDetailView view) {
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    Observable<GetNewsResponse> doGetNewsResponse(int id) {
        return domain.getNewsById(id);
    }

    Observable<GetStoryExtraResponse> doGetStoryExtra(int id) {
        return domain.getStoryExtraById(id);
    }

    interface IDetailView extends IMvpView {

    }
}