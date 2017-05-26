package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.os.Bundle;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeTopStory;
import cn.mycommons.xiaoxiazhihu.databinding.ItemTopItemFragmentBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.AacFragment;
import cn.mycommons.xiaoxiazhihu.ui.base.common.FragmentLauncher;
import cn.mycommons.xiaoxiazhihu.ui.home.detail.DetailFragment;

/**
 * TopItemFragment <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class TopItemFragment extends AacFragment<ItemTopItemFragmentBinding> {

    static final String EXTRA_TOP_STORY = "extra_top_story";

    public static TopItemFragment newInstance(LastThemeTopStory story) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TOP_STORY, story);
        TopItemFragment fragment = new TopItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.item_top_item_fragment;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        final LastThemeTopStory topStory = (LastThemeTopStory) getArguments().getSerializable(EXTRA_TOP_STORY);

        if (topStory != null) {
            binding.setText(topStory.getTitle());
            binding.setImage(topStory.getImage());

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DetailFragment.DetailExtraParam param = new DetailFragment.DetailExtraParam();
                    param.setFragmentClass(DetailFragment.class);
                    param.id = topStory.getId();
                    FragmentLauncher.launch(v.getContext(), param);
                }
            });
        }
    }
}