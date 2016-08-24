package cn.mycommons.xiaoxiazhihu.app;

import javax.inject.Singleton;

import cn.mycommons.xiaoxiazhihu.ui.MainPresenter;
import cn.mycommons.xiaoxiazhihu.ui.StartPresenter;
import cn.mycommons.xiaoxiazhihu.ui.home.CommentsPresenter;
import cn.mycommons.xiaoxiazhihu.ui.home.DetailPresenter;
import cn.mycommons.xiaoxiazhihu.ui.home.HotnewsPresenter;
import cn.mycommons.xiaoxiazhihu.ui.home.OtherThemePresenter;
import dagger.Component;

/**
 * AppCompoent <br/>
 * Created by xiaqiulei on 2016-06-29.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(CommentsPresenter presenter);

    void inject(DetailPresenter presenter);

    void inject(HotnewsPresenter presenter);

    void inject(OtherThemePresenter presenter);

    void inject(MainPresenter presenter);

    void inject(StartPresenter presenter);
}