package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.mycommons.xiaoxiazhihu.databinding.ItemLastTitleBinding;

/**
 * OtherThemeTypeTitle <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class OtherThemeTypeTitle extends RecyclerView.ViewHolder {

    private final ItemLastTitleBinding titleBinding;

    OtherThemeTypeTitle(View itemView) {
        super(itemView);

        titleBinding = DataBindingUtil.bind(itemView);
    }

    void bind(String text) {
        titleBinding.text.setText(text);
    }
}