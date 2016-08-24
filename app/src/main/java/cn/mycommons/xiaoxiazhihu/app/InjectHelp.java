package cn.mycommons.xiaoxiazhihu.app;

import android.app.Application;

import de.greenrobot.event.EventBus;

/**
 * InjectHelp <br/>
 * Created by xiaqiulei on 2015-06-01.
 */
public class InjectHelp {

    private static AppComponent appComponent;

    static synchronized void init(Application application) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
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
}