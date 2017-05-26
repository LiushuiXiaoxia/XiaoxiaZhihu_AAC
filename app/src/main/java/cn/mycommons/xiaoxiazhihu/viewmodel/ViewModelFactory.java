package cn.mycommons.xiaoxiazhihu.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.util.ArrayMap;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import cn.mycommons.xiaoxiazhihu.app.ViewModelSubComponent;
import cn.mycommons.xiaoxiazhihu.ui.MainViewModel;
import cn.mycommons.xiaoxiazhihu.ui.StartViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.CommentsViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.detail.DetailViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.hot.HotNewsViewModel;
import cn.mycommons.xiaoxiazhihu.ui.home.other.OtherThemeViewModel;

/**
 * ViewModelFactory <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private ArrayMap<Class, Callable<? extends ViewModel>> creators;

    @Inject
    public ViewModelFactory(final ViewModelSubComponent component) {
        creators = new ArrayMap<>();
        creators.put(StartViewModel.class, new Callable<ViewModel>() {
            @Override
            public ViewModel call() throws Exception {
                return component.startViewModel();
            }
        });
        creators.put(MainViewModel.class, new Callable<ViewModel>() {
            @Override
            public ViewModel call() throws Exception {
                return component.mainViewModel();
            }
        });
        creators.put(HotNewsViewModel.class, new Callable<ViewModel>() {
            @Override
            public ViewModel call() throws Exception {
                return component.hotNewsViewModel();
            }
        });
        creators.put(OtherThemeViewModel.class, new Callable<ViewModel>() {
            @Override
            public ViewModel call() throws Exception {
                return component.otherThemeViewModel();
            }
        });
        creators.put(DetailViewModel.class, new Callable<ViewModel>() {
            @Override
            public ViewModel call() throws Exception {
                return component.detailViewModel();
            }
        });
        creators.put(CommentsViewModel.class, new Callable<ViewModel>() {
            @Override
            public ViewModel call() throws Exception {
                return component.commentsViewModel();
            }
        });
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Callable<? extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}