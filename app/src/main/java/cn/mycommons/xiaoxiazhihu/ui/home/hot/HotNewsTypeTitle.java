package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.databinding.ItemLastTitleBinding;

/**
 * HotNewsTypeTitle <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
class HotNewsTypeTitle extends RecyclerView.ViewHolder {

    private final ItemLastTitleBinding binding;

    HotNewsTypeTitle(View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
    }

    void bind(String text) {
        binding.text.setText(text);
    }
}