package cn.mycommons.xiaoxiazhihu.ui.home;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import rx.Observable;


/**
 * DetailPresenter <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class DetailPresenter extends BaseMvpPresenter<DetailPresenter.IDetailView> {

    @Inject
    ZhihuDomain domain;

    /**
     * 子类的Presenter必须加上{@link Inject}注解
     *
     * @param loadDataView 载入Data的View模型
     * @param view         子Presenter需要实现的View模型，类型由泛型指定
     */
    @Inject
    public DetailPresenter(ILoadDataView loadDataView, IDetailView view) {
        super(loadDataView, view);
    }

    Observable<GetNewsResponse> doGetNewsResponse(int id) {
        return domain.getNewsById(id);
    }

    Observable<GetStoryExtraResponse> doGetStoryExtra(int id) {
        return domain.getStoryExtraById(id);
    }

    public interface IDetailView extends IMvpView {

    }
}