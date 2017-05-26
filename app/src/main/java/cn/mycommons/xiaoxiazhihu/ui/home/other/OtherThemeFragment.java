package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.ThemeItem;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;
import cn.mycommons.xiaoxiazhihu.databinding.FragmentHomeBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.AacFragment;

/**
 * OtherThemeFragment <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class OtherThemeFragment extends AacFragment<FragmentHomeBinding> {

    private static final String EXTRA_ITEM = "themeItem";

    public static OtherThemeFragment newInstance(ThemeItem themeItem) {
        OtherThemeFragment fragment = new OtherThemeFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ITEM, themeItem);
        fragment.setArguments(args);
        return fragment;
    }

    private ThemeItem themeItem;
    private OtherThemeAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        themeItem = (ThemeItem) getArguments().getSerializable(EXTRA_ITEM);

        if (themeItem != null) {
            setTitle(themeItem.getName());

            adapter = new OtherThemeAdapter();
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerView.setAdapter(adapter);
            binding.swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
            binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    doGetRequest();
                }
            });

            doGetRequest();
        }
    }

    private void doGetRequest() {
        ViewModelProviders.of(this, viewModelFactory())
                .get(OtherThemeViewModel.class)
                .getThemeResponse(themeItem.getId())
                .observe(this, new Observer<GetThemeResponse>() {
                    @Override
                    public void onChanged(@Nullable GetThemeResponse getThemeResponse) {
                        adapter.update(getThemeResponse);
                        binding.swipeRefreshLayout.setRefreshing(false);
                    }
                });
    }
}