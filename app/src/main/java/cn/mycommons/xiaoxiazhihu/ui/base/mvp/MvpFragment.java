package cn.mycommons.xiaoxiazhihu.ui.base.mvp;

import android.os.Bundle;
import android.view.View;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.mycommons.xiaoxiazhihu.core.log.XLog;
import cn.mycommons.xiaoxiazhihu.ui.base.BaseFragment;
import roboguice.RoboGuice;


/**
 * MvpFragment <br/>
 * Created by xiaqiulei on 2015-01-25.
 */
public abstract class MvpFragment<P extends BaseMvpPresenter, V extends IMvpView> extends BaseFragment {

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
            presenter.registerEventBusListener(this);
            presenter.create(savedInstanceState);
            presenter.initInFragment(savedInstanceState, getArguments());
        }
    }

    /**
     * 在初始化mvp前，做些事情
     *
     * @param savedInstanceState
     */
    protected void beforeMvpInit(Bundle savedInstanceState) {

    }

    private void onMvpInit() {
        try {
            injectPresenterAndViewLayer();
        } catch (Exception e) {
            // 防止子类未使用泛型所可能产生的意外错误
            XLog.w("onMvpInit fail.");
            XLog.e("", e);
        }
    }

    /**
     * 注入泛型指定的{@link P}和{@link V}
     */
    protected void injectPresenterAndViewLayer() {
        Injector injector = RoboGuice.getInjector(getContext()).createChildInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(ILoadDataView.class).toInstance(mvpActivity);

                Object view = getViewInstance();
                Class<V> viewClass = getViewClass();
                if (view != null && viewClass != null && viewClass.isInstance(view)) {
                    bind(viewClass).toInstance((V) view);
                } else {
                    XLog.i("viewClass = " + viewClass);
                    XLog.i("view = " + view);
                }
            }
        });

        if (getViewClass() != null) {
            view = injector.getInstance(getViewClass());
        }
        if (getPresenterClass() != null) {
            try {
                presenter = injector.getInstance(getPresenterClass());
            } catch (Exception e) {
                XLog.w(e.toString());
            } finally {
                if (presenter == null) {
                    XLog.e("******************************");
                    XLog.e("******************************");
                    XLog.e("******************************");
                    XLog.e("presenter's class is not null,but presenter'value is null,do you forget add @Inject on Presenter ???");
                    XLog.e("******************************");
                    XLog.e("******************************");
                    XLog.e("******************************");
                }
            }
        }

        XLog.d("view = " + view);
        XLog.d("presenter = " + presenter);
    }

    /**
     * 返回实现{@link P}的class，子类没有实现则为null
     *
     * @return
     */
    protected Class<P> getPresenterClass() {
        Class<P> pClass = null;

        do {
            Type genType = getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 1) {
                break;
            }
            if (params[0] != null && params[0] instanceof Class) {
                pClass = (Class<P>) params[0];
            }
        } while (false);

        return pClass;
    }

    /**
     * 返回实现{@link V}的class，子类没有实现则为null
     *
     * @return
     */
    protected Class<V> getViewClass() {
        Class<V> vClass = null;

        do {
            Type genType = getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 2) {
                break;
            }
            if (params[1] != null && params[1] instanceof Class) {
                vClass = (Class<V>) params[1];
            }
        } while (false);

        return vClass;
    }

    /**
     * 返回实现{@link V}的实例，默认是当前Activity
     *
     * @return {@link V}的实例
     */
    protected V getViewInstance() {
        try {
            Class<V> vClass = getViewClass();
            if (vClass != null && vClass.isInstance(this)) {
                return (V) this;
            }
        } catch (Exception e) {
            XLog.w(e.toString());
        }
        return null;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.pause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //反注册Fragment
            presenter.unregisterEventBusListener(this);
            presenter.destory();
        }
    }
}