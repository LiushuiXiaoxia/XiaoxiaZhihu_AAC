package cn.mycommons.xiaoxiazhihu.ui.base.mvp;

/**
 * 基础Presenter
 */
public interface IMvpPresenter<V extends IMvpView> {

    void create(ILoadDataView loadDataView, V mvpView);

    void destory();
}