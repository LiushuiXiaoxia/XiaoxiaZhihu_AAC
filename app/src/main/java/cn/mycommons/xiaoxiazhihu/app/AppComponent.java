package cn.mycommons.xiaoxiazhihu.app;

import com.google.gson.Gson;

import javax.inject.Singleton;

import cn.mycommons.xiaoxiazhihu.ui.MainActivity;
import cn.mycommons.xiaoxiazhihu.ui.MainViewModel;
import cn.mycommons.xiaoxiazhihu.ui.StartViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.CommentsViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.detail.DetailViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.hot.HotNewsViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.other.OtherThemeViewModel;
import dagger.Component;

/**
 * AppCompoent <br/>
 * Created by xiaqiulei on 2016-06-29.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Gson gson();

    void inject(AppContext context);

    void inject(StartViewModel model);

    void inject(MainViewModel model);

    void inject(HotNewsViewModel model);

    void inject(OtherThemeViewModel model);

    void inject(DetailViewModel model);

    void inject(CommentsViewModel model);

    void inject(MainActivity mainActivity);
}