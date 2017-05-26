package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.databinding.ItemLastItemBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.common.FragmentLauncher;
import cn.mycommons.xiaoxiazhihu.ui.home.detail.DetailFragment;

/**
 * HotNewsTypeItem <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
class HotNewsTypeItem extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ItemLastItemBinding binding;

    HotNewsTypeItem(View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
        itemView.setOnClickListener(this);
    }

    void bind(LastThemeStory story) {
        itemView.setTag(story);

        binding.setTitle(story.getTitle());
        if (story.getImages() != null && !story.getImages().isEmpty()) {
            binding.setImageUrl(story.getImages().get(0));
        }
    }

    @Override
    public void onClick(View v) {
        LastThemeStory story = (LastThemeStory) v.getTag();
        DetailFragment.DetailExtraParam param = new DetailFragment.DetailExtraParam();
        param.setFragmentClass(DetailFragment.class);
        param.id = story.getId();
        FragmentLauncher.launch(v.getContext(), param);
    }
}