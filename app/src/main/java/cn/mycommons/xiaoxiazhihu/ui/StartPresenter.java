package cn.mycommons.xiaoxiazhihu.ui;

import com.google.inject.Inject;

import cn.mycommons.xiaoxiazhihu.business.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import rx.Observable;


/**
 * StartPresenter <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class StartPresenter extends BaseMvpPresenter<StartPresenter.IStartView> {

    @Inject
    ZhihuDomain zhihuDomain;

    /**
     * 子类的Presenter必须加上{@link Inject}注解
     *
     * @param loadDataView 载入Data的View模型
     * @param view         子Presenter需要实现的View模型，类型由泛型指定
     */
    @Inject
    public StartPresenter(ILoadDataView loadDataView, IStartView view) {
        super(loadDataView, view);
    }

    public Observable<GetStartInfoResponse> doGetStartInfo() {
        return zhihuDomain.getStartInfo(1080, 1776);
    }

    public interface IStartView extends IMvpView {

    }
}