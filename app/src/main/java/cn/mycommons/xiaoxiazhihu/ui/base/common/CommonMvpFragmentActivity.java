package cn.mycommons.xiaoxiazhihu.ui.base.common;

import android.os.Bundle;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.MvpActivity;

public class CommonMvpFragmentActivity extends MvpActivity {

    private ActivityDelegate<CommonMvpFragmentActivity, CommonMvpFragment> delegate;

    protected void onCreate(Bundle savedInstanceState) {
        if (delegate == null) {
            delegate = getDeledate();
        }

        delegate.beforeOnCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_common_fm);
        delegate.afterOnCreate(savedInstanceState);
    }

    protected ActivityDelegate<CommonMvpFragmentActivity, CommonMvpFragment> getDeledate() {
        return new ActivityDelegate(this);
    }

    protected final CommonExtraParam getExtraParam() {
        return delegate.getExtraParam();
    }

    protected CommonMvpFragment getCommonFragment() {
        return delegate.getCommonFragment();
    }

    public void onBackPressed() {
        if (getCommonFragment() != null) {
            if (!getCommonFragment().onActivityPressBack()) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    public boolean onSupportNavigateUp() {
        return getCommonFragment() != null
                && getCommonFragment().onActivitySupportNavigateUp()
                || super.onSupportNavigateUp();
    }
}