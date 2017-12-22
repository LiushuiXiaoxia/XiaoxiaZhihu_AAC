package cn.mycommons.xiaoxiazhihu.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * AacFragment <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public abstract class AacFragment<T extends ViewDataBinding> extends BaseFragment {

    protected T binding;

    protected Context context;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        context = getActivity();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = DataBindingUtil.bind(view);

        init(savedInstanceState);
    }

    protected abstract void init(Bundle savedInstanceState);
}
