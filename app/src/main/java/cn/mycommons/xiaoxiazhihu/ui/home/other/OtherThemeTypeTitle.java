package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;

/**
 * OtherThemeTypeTitle <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class OtherThemeTypeTitle extends RecyclerView.ViewHolder {

    @BindView(R.id.text)
    TextView textView;

    OtherThemeTypeTitle(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(String text) {
        textView.setText(text);
    }
}