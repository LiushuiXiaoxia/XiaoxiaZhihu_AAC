package cn.mycommons.xiaoxiazhihu.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

/**
 * AacBaseActivity <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
public abstract class AacBaseActivity<T extends ViewDataBinding> extends BaseActivity {

    protected T binding;

    @Override
    protected void initContentView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}