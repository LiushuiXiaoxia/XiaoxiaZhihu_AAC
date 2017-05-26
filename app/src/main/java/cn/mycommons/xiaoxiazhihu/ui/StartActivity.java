package cn.mycommons.xiaoxiazhihu.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.databinding.ActivityStartBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.AacBaseActivity;

public class StartActivity extends AacBaseActivity<ActivityStartBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        gotoNext();
    }

    private void init() {
        StartViewModel viewModel = ViewModelProviders.of(this, viewModelFactory()).get(StartViewModel.class);
        viewModel.getStartInfo().observe(this, new Observer<GetStartInfoResponse>() {
            @Override
            public void onChanged(@Nullable GetStartInfoResponse response) {
                if (response != null) {
                    binding.setInfo(response);
                    binding.executePendingBindings();
                }
            }
        });
    }

    private void gotoNext() {
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getContext(), MainActivity.class));
                finish();
            }
        }, 3000);
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }
}