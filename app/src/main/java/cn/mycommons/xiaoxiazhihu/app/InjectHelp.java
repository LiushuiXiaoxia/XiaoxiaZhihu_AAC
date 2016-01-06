package cn.mycommons.xiaoxiazhihu.app;

import android.app.Application;
import android.content.Context;

import com.google.inject.Injector;
import com.google.inject.Module;

import de.greenrobot.event.EventBus;
import roboguice.RoboGuice;

/**
 * InjectHelp <br/>
 * Created by xiaqiulei on 2015-06-01.
 */
public class InjectHelp {

    static void init(Application application) {
        // 关闭 RoboGuice 3.+ 编译时生成代码功能。仅使用反射。
        RoboGuice.setUseAnnotationDatabases(false);

        RoboGuice.getOrCreateBaseApplicationInjector(
                application,
                RoboGuice.DEFAULT_STAGE,
                RoboGuice.newDefaultRoboModule(application),
                new BindImplModule()
        );
    }

    public static AppContext getAppContext() {
        return AppContext.getInstance();
    }

    public static <T> T getInjectInstance(Class<T> tClass) {
        return RoboGuice.getInjector(getAppContext()).getInstance(tClass);
    }

    public static EventBus getEventBus() {
        return EventBus.getDefault();
    }

    public static void injectMembersWithoutViews(Object object) {
        RoboGuice.getInjector(getAppContext()).injectMembersWithoutViews(object);
    }

    public static Injector createChildInjector(Context context, Module... modules) {
        return RoboGuice.getInjector(context).createChildInjector(modules);
    }
}