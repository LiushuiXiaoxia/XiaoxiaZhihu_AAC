package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;

/**
 * HotNewsTypeTitle <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
class HotNewsTypeTitle extends RecyclerView.ViewHolder {

    @BindView(R.id.text)
    TextView textView;

    HotNewsTypeTitle(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(String text) {
        textView.setText(text);
    }
}