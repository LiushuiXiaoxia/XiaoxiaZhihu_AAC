package cn.mycommons.xiaoxiazhihu.app;

import de.greenrobot.event.EventBus;

/**
 * InjectHelp <br/>
 * Created by xiaqiulei on 2015-06-01.
 */
public class InjectHelp {

    private static AppComponent appComponent;

    static synchronized void init(AppContext appContext) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        appComponent.inject(appContext);
    }

    public static AppComponent appComponent() {
        return appComponent;
    }

    public static AppContext getAppContext() {
        return AppContext.getInstance();
    }

    public static EventBus getEventBus() {
        return EventBus.getDefault();
    }

    private InjectHelp() {
    }
}