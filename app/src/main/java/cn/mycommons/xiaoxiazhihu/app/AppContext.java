package cn.mycommons.xiaoxiazhihu.app;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

/**
 * AppContext <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class AppContext extends Application {

    private static AppContext instance;

    public static AppContext getInstance() {
        return instance;
    }

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initInject();
    }

    void initInject() {
        InjectHelp.init(this);
    }

    public ViewModelProvider.Factory getViewModelFactory() {
        return factory;
    }
}