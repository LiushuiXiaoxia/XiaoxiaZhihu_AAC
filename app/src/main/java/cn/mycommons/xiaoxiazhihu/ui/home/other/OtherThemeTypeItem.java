package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.databinding.ItemLastItemBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.common.FragmentLauncher;
import cn.mycommons.xiaoxiazhihu.ui.home.detail.DetailFragment;

/**
 * OtherThemeTypeItem <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class OtherThemeTypeItem extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ItemLastItemBinding binding;

    OtherThemeTypeItem(View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
        itemView.setOnClickListener(this);
    }

    void bind(LastThemeStory story) {
        itemView.setTag(story);
        binding.setTitle(story.getTitle());

        ImageView icon = binding.icon;
        if (story.getImages() != null && !story.getImages().isEmpty()) {
            Picasso.with(icon.getContext())
                    .load(story.getImages().get(0))
                    .placeholder(R.drawable.ic_launcher)
                    .into(icon);
        } else {
            icon.setImageResource(0);
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