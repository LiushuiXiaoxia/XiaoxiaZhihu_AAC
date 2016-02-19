package cn.mycommons.xiaoxiazhihu.ui.home;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
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

    public Observable<GetShortCommentsResponse> doGetShortComments(int id) {
        isLoadShort = true;
        return zhihuDomain.getShortCommentsById(id);
    }

    public Observable<GetLongCommentsResponse> doGetLongCommentsById(int id) {
        return zhihuDomain.getLongCommentsById(id);
    }

    public boolean isLoadShort() {
        return isLoadShort;
    }

    public interface ICommentsView extends IMvpView {

    }
}