package cn.mycommons.xiaoxiazhihu.app;

import android.app.Application;

/**
 * AppContext <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class AppContext extends Application {

    private static AppContext instance;

    public static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initInject();
    }

    void initInject(){
        InjectHelp.init(this);
    }
}