package cn.mycommons.xiaoxiazhihu.ui.base.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.mycommons.xiaoxiazhihu.app.InjectHelp;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Presenter基类，与BaseActivity配合使用，能自动通过泛型绑定对应Presenrer和View。<p/>
 * <b>子类的构造方法必须添加@Inject注解</b>
 * <p/>
 */
public class BaseMvpPresenter<V extends IMvpView> implements IMvpPresenter {

    protected ILoadDataView loadDataView;
    /**
     * View层模型
     */
    protected V view;
    protected Context context;
    private EventBus eventBus;

    public BaseMvpPresenter() {
        super();
    }

    public void initMvpPresenter(ILoadDataView loadDataView, V view) {
        this.loadDataView = loadDataView;
        this.view = view;
        this.context = loadDataView.getContext();
    }

    /**
     * Call in {@link android.app.Activity#onCreate(Bundle)} after Presenter created.
     *
     * @param savedInstanceState Bundle from {@link android.app.Activity#onCreate(Bundle)}
     * @param activityIntent     Bundle from {@link android.app.Activity#getIntent()}
     */
    public void initInActivity(Bundle savedInstanceState, Intent activityIntent) {
        // NO OP
    }

    /**
     * Call in {@link android.app.Fragment#onViewCreated(android.view.View, Bundle)}
     * after Presenter created.
     *
     * @param savedInstanceState Bundle from {@link android.app.Fragment#onCreate(Bundle)}
     * @param fragmentArguments  Bundle from {@link android.app.Fragment#getArguments()}
     */
    public void initInFragment(Bundle savedInstanceState, Bundle fragmentArguments) {
        // NO OP
    }


    @Override
    public void create(Bundle savedInstanceState) {
        //注册Presenter
        registerEventBusListener(this);
    }

    @Override
    public void start() {
        // NO OP
    }

    @Override
    public void resume() {
        // NO OP
    }

    @Override
    public void pause() {
        // NO OP
    }

    @Override
    public void stop() {
        // NO OP
    }

    @Override
    public void destory() {
        unregisterEventBusListener(this);
        this.loadDataView = null;
        this.view = null;
        this.context = null;
        this.eventBus = null;
    }

    /**
     * 所有子类通过此方法获取EventBus，这样子类可以通过复写此方法获取自己的EventBus
     *
     * @return eventBus
     */
    public EventBus getEventBus() {
        if (eventBus == null) {
            eventBus = EventBus.getDefault();
        }
        return eventBus;
    }

    public void registerEventBusListener(Object object) {
        if (getEventBus() != null) {
            try {
                getEventBus().register(object);
            } catch (EventBusException eventBusException) {
                // 如果object没有任何onEvent等订阅，会导致EventBusException，此处try-catch防止崩溃
            }
        }
    }

    public void unregisterEventBusListener(Object object) {
        if (getEventBus() != null) {
            getEventBus().unregister(object);
        }
    }

    public void onEvent(Object object) {
    }
}