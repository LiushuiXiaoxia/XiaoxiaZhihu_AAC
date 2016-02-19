package cn.mycommons.xiaoxiazhihu.ui.base.mvp;

/**
 * 描述用于载入数据的View的接口
 */
public interface ILoadDataView extends IView {

    /**
     * loading对话框的默认类型
     */
    int LOADING_TYPE_DEFAULT = 101;

    /**
     * 使用LOADING_TYPE_DEFAULT显示loading对话框
     */
    void showLoading();

    void showLoading(int loadingType);

    /**
     * 隐藏所有正在显示的loading对话框
     */
    void hideLoading();

    void hideLoading(int loadingType);

    void showError(String message);
}