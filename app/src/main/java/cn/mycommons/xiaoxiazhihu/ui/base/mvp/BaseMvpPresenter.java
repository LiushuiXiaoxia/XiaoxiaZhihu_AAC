package cn.mycommons.xiaoxiazhihu.ui.base.mvp;

import android.content.Context;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

public class BaseMvpPresenter<V extends IMvpView> implements IMvpPresenter<V> {

    protected ILoadDataView loadDataView;
    protected V view;
    protected Context context;
    private EventBus eventBus;

    public void create(ILoadDataView loadDataView, V view) {
        this.loadDataView = loadDataView;
        this.view = view;
        this.context = loadDataView.getContext();
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