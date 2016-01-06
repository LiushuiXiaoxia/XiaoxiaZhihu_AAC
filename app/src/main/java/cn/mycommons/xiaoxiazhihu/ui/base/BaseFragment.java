package cn.mycommons.xiaoxiazhihu.ui.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import roboguice.activity.RoboActionBarActivity;
import roboguice.fragment.RoboFragment;

public abstract class BaseFragment extends RoboFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutRes = getFragmentLayout();
        return inflater.inflate(layoutRes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    protected ActionBar getSupportActionBar() {
        return ((RoboActionBarActivity) getActivity()).getSupportActionBar();
    }

    protected void setTitle(int resId) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(resId);
        }
    }

    protected void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    /**
     * 每个Fragment自己的布局
     */
    protected abstract int getFragmentLayout();
}