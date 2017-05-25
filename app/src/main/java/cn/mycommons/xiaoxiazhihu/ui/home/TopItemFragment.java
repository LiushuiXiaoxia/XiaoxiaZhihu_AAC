package cn.mycommons.xiaoxiazhihu.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastTemeTopStory;
import cn.mycommons.xiaoxiazhihu.ui.base.common.FragmentLauncher;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.MvpFragment;

/**
 * TopItemFragment <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class TopItemFragment extends MvpFragment {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.icon)
    ImageView icon;

    LastTemeTopStory topStory;

    @Override
    protected int getFragmentLayout() {
        return R.layout.item_top_item_fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        if (topStory != null) {
            text.setText(topStory.getTitle());
            Picasso.with(icon.getContext())
                    .load(topStory.getImage())
                    .into(icon);
        }

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DetailFragment.DetailExtraParam param = new DetailFragment.DetailExtraParam();
                param.setFragmentClass(DetailFragment.class);
                param.id = topStory.getId();
                FragmentLauncher.launch(v.getContext(), param);
            }
        });
    }

    public void setTopStory(LastTemeTopStory topStory) {
        this.topStory = topStory;
    }
}