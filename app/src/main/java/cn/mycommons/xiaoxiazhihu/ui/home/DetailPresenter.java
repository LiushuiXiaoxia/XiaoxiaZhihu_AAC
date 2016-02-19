package cn.mycommons.xiaoxiazhihu.ui.home;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import rx.Observable;


/**
 * DetailPresenter <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class DetailPresenter extends BaseMvpPresenter<DetailPresenter.IDetailView> {

    @Inject
    ZhihuDomain domain;

    Observable<GetNewsResponse> doGetNewsResponse(int id) {
        return domain.getNewsById(id);
    }

    Observable<GetStoryExtraResponse> doGetStoryExtra(int id) {
        return domain.getStoryExtraById(id);
    }

    public interface IDetailView extends IMvpView {

    }
}