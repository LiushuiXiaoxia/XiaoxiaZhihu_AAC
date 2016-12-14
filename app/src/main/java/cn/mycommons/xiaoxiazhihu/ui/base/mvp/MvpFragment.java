package cn.mycommons.xiaoxiazhihu.ui.base.mvp;

import android.os.Bundle;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.core.log.AppLog;
import cn.mycommons.xiaoxiazhihu.ui.base.BaseFragment;


/**
 * MvpFragment <br/>
 * Created by xiaqiulei on 2015-01-25.
 */
public abstract class MvpFragment<P extends BaseMvpPresenter<V>, V extends IMvpView> extends BaseFragment {

    protected MvpActivity mvpActivity;
    protected P presenter;
    protected V view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpActivity = (MvpActivity) getActivity();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        beforeMvpInit(savedInstanceState);

        onMvpInit();

        if (presenter != null) {
            //注册Fragment
            presenter.create(mvpActivity, this.view);
            presenter.registerEventBusListener(this);
        }
    }

    /**
     * 在初始化mvp前，做些事情
     *
     * @param savedInstanceState savedInstanceState
     */
    protected void beforeMvpInit(Bundle savedInstanceState) {

    }

    private void onMvpInit() {
        try {
            initPresenterAndView();
        } catch (Exception e) {
            // 防止子类未使用泛型所可能产生的意外错误
            AppLog.w("onMvpInit fail, e = " + e);
        }
    }

    /**
     * 通过反射获取{@link P}和{@link V}
     */
    protected void initPresenterAndView() {
        MvpHelper<P, V> mvpHelper = new MvpHelper<>(this);
        view = getViewInstance();
        Class<P> pClass = mvpHelper.getPresenterClass();
        if (pClass != null) {
            try {
                presenter = pClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AppLog.d("view = " + view);
        AppLog.d("presenter = " + presenter);
    }

    /**
     * 返回实现{@link V}的实例，默认是当前Activity
     *
     * @return {@link V}的实例
     */
    protected V getViewInstance() {
        try {
            Class<V> vClass = new MvpHelper<P, V>(this).getViewClass();
            if (vClass != null && vClass.isInstance(this)) {
                return (V) this;
            }
        } catch (Exception e) {
            AppLog.w(e.toString());
        }
        return null;
    }

    public void onEvent(Object object) {

    }

    @Override
    public void onDestroy() {
        if (presenter != null) {
            //反注册Fragment
            presenter.unregisterEventBusListener(this);
            presenter.destory();
        }
        mvpActivity = null;
        presenter = null;
        view = null;

        super.onDestroy();
    }
}