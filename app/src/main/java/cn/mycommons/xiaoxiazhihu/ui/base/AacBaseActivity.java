package cn.mycommons.xiaoxiazhihu.ui.base;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

/**
 * AacBaseActivity <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public abstract class AacBaseActivity<T extends ViewDataBinding> extends BaseActivity
        implements LifecycleRegistryOwner {

    protected T binding;

    @Override
    protected void initContentView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //// arch
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final LifecycleRegistry registry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }
}