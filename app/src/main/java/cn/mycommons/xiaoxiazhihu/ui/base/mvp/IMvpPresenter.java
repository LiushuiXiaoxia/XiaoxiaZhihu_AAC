package cn.mycommons.xiaoxiazhihu.ui.base.mvp;

import android.os.Bundle;

/**
 * 基础Presenter
 * <p/>
 * Created by RemexHuang on 12/30/14.
 */
public interface IMvpPresenter {

    /**
     * Activity.onCreate <br/>
     * Fragment.onViewCreated
     */
    void create(Bundle savedInstanceState);

    /**
     * Activity.onStart <br/>
     * Fragment.onStart
     */
    void start();

    /**
     * Activity.onResume <br/>
     * Fragment.onResume
     */
    void resume();

    /**
     * Activity.onPause <br/>
     * Fragment.onPause
     */
    void pause();

    /**
     * Activity.onStop <br/>
     * Fragment.onStop
     */
    void stop();

    /**
     * Activity.onDestory <br/>
     * Fragment.onDestory
     */
    void destory();

}
