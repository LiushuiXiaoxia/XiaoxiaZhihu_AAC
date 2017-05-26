package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.databinding.FragmentHotnewsBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.AacFragment;

/**
 * HotNewsFragment <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class HotNewsFragment extends AacFragment<FragmentHotnewsBinding> {

    private HotNewsAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_hotnews;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("今日热闻");

        init();
        loadLastTheme();
    }

    private void init() {
        adapter = new HotNewsAdapter(getFragmentManager());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        binding.swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadLastTheme();
            }
        });
    }

    private void loadLastTheme() {
        ViewModelProviders.of(this, viewModelFactory())
                .get(HotNewsViewModel.class)
                .getLastThemeResponse()
                .observe(this, new Observer<GetLastThemeResponse>() {
                    @Override
                    public void onChanged(@Nullable GetLastThemeResponse getLastThemeResponse) {
                        update(getLastThemeResponse);
                    }
                });
    }

    private void update(GetLastThemeResponse response) {
        binding.swipeRefreshLayout.setRefreshing(false);
        adapter.notifyDataSetChanged(response);
    }
}