package cn.mycommons.xiaoxiazhihu.ui.base.common;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.MvpFragment;


/**
 * CommonMvpFragment <br/>
 * Created by xiaqiulei on 2015-01-24.
 */
public abstract class CommonMvpFragment<P extends BaseMvpPresenter<V>, V extends IMvpView>
        extends MvpFragment<P, V> implements ICommonFragment {

    protected Context context;

    private FragmentDelegate<CommonMvpFragment, CommonExtraParam> delegate;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        context = getActivity();

        if (delegate == null) {
            delegate = getDelegate();
        }

        delegate.beforeOnViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        delegate.afterOnViewCreated(view, savedInstanceState);

        init(savedInstanceState);
    }

    protected abstract void init(Bundle savedInstanceState);

    protected FragmentDelegate<CommonMvpFragment, CommonExtraParam> getDelegate() {
        return new FragmentDelegate<CommonMvpFragment, CommonExtraParam>(this);
    }

    public final <T extends CommonExtraParam> T getReqExtraParam() {
        return (T) delegate.getReqExtraParam();
    }

    protected final void setSuccessResult(CommonExtraParam extraParam) {
        delegate.setSuccessResult(extraParam);
    }

    public boolean onActivityPressBack() {
        return false;
    }

    public boolean onActivitySupportNavigateUp() {
        return false;
    }
}