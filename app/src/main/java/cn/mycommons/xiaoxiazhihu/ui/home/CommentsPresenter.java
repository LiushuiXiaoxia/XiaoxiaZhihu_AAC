package cn.mycommons.xiaoxiazhihu.ui.home;


import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.app.InjectHelp;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import rx.Observable;


/**
 * CommentsPresenter <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
public class CommentsPresenter extends BaseMvpPresenter<CommentsPresenter.ICommentsView> {

    @Inject
    ZhihuDomain zhihuDomain;

    private boolean isLoadShort = false;

    @Override
    public void create(ILoadDataView loadDataView, ICommentsView view) {
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    Observable<GetShortCommentsResponse> doGetShortComments(int id) {
        isLoadShort = true;
        return zhihuDomain.getShortCommentsById(id);
    }

    Observable<GetLongCommentsResponse> doGetLongCommentsById(int id) {
        return zhihuDomain.getLongCommentsById(id);
    }

    boolean isLoadShort() {
        return isLoadShort;
    }

    interface ICommentsView extends IMvpView {

    }
}