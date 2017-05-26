package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeTopStory;

/**
 * HotNewsTypeHeader <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
class HotNewsTypeHeader extends RecyclerView.ViewHolder {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private FragmentManager fragmentManager;

    HotNewsTypeHeader(View itemView, FragmentManager manager) {
        super(itemView);
        this.fragmentManager = manager;
        ButterKnife.bind(this, itemView);
    }

    void bind(List<LastThemeTopStory> tops) {
        List<LastThemeTopStory> topsLocal = tops;
        if (tops == null) {
            topsLocal = new ArrayList<>();
        }

        viewPager.setAdapter(new TopItemAdapter(fragmentManager, topsLocal));
    }
}