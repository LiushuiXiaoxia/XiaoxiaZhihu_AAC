package cn.mycommons.xiaoxiazhihu.app;

import cn.mycommons.xiaoxiazhihu.ui.MainViewModel;
import cn.mycommons.xiaoxiazhihu.ui.StartViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.CommentsViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.detail.DetailViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.hot.HotNewsViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.other.OtherThemeViewModel;
import dagger.Subcomponent;

/**
 * ViewModelSubComponent <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    StartViewModel startViewModel();

    MainViewModel mainViewModel();

    HotNewsViewModel hotNewsViewModel();

    OtherThemeViewModel otherThemeViewModel();

    DetailViewModel detailViewModel();

    CommentsViewModel commentsViewModel();
}