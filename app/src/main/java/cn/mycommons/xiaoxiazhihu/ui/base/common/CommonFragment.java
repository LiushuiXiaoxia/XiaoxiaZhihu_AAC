package cn.mycommons.xiaoxiazhihu.ui.base.common;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.ui.base.AacFragment;


/**
 * CommonFragment <br/>
 * Created by xiaqiulei on 2015-01-24.
 */
public abstract class CommonFragment<T extends ViewDataBinding> extends AacFragment<T> implements ICommonFragment {

    protected Context context;

    private FragmentDelegate<CommonFragment, CommonExtraParam> delegate;

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

    protected FragmentDelegate<CommonFragment, CommonExtraParam> getDelegate() {
        return new FragmentDelegate<CommonFragment, CommonExtraParam>(this);
    }

    public final <R extends CommonExtraParam> R getReqExtraParam() {
        return (R) delegate.getReqExtraParam();
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