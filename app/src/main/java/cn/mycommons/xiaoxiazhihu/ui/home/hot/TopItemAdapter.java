package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeTopStory;

/**
 * TopItemAdapter <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
class TopItemAdapter extends FragmentPagerAdapter {

    private List<LastThemeTopStory> tops;

    TopItemAdapter(FragmentManager fm, List<LastThemeTopStory> tops) {
        super(fm);
        this.tops = tops;
    }

    @Override
    public Fragment getItem(int position) {
        return TopItemFragment.newInstance(tops.get(position));
    }

    @Override
    public int getCount() {
        return tops != null ? tops.size() : 0;
    }
}