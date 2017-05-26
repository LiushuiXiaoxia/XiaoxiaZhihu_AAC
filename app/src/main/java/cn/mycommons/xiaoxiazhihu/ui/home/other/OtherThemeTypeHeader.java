package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;
import cn.mycommons.xiaoxiazhihu.databinding.ItemTopItemFragmentBinding;

/**
 * OtherThemeTypeHeader <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class OtherThemeTypeHeader extends RecyclerView.ViewHolder {

    private final ItemTopItemFragmentBinding binding;

    OtherThemeTypeHeader(View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
    }

    void bind(GetThemeResponse response) {
        binding.setText(response.getName());
        binding.setImage(response.getImage());
    }
}