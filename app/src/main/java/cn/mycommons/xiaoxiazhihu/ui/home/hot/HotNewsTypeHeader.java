package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeTopStory;
import cn.mycommons.xiaoxiazhihu.databinding.ItemLastHeaderBinding;

/**
 * HotNewsTypeHeader <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
class HotNewsTypeHeader extends RecyclerView.ViewHolder {

    private final FragmentManager fragmentManager;
    private final ItemLastHeaderBinding binding;

    HotNewsTypeHeader(View itemView, FragmentManager manager) {
        super(itemView);
        this.fragmentManager = manager;
        binding = DataBindingUtil.bind(itemView);
    }

    void bind(List<LastThemeTopStory> tops) {
        List<LastThemeTopStory> topsLocal = tops;
        if (tops == null) {
            topsLocal = new ArrayList<>();
        }

        binding.viewPager.setAdapter(new TopItemAdapter(fragmentManager, topsLocal));
    }
}