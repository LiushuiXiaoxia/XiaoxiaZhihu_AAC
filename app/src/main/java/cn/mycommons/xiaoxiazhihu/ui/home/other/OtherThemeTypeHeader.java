package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;

/**
 * OtherThemeTypeHeader <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class OtherThemeTypeHeader extends RecyclerView.ViewHolder {

    @BindView(R.id.text)
    TextView textView;

    @BindView(R.id.icon)
    ImageView icon;

    OtherThemeTypeHeader(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(GetThemeResponse response) {
        textView.setText(response.getName());
        Picasso.with(icon.getContext())
                .load(response.getImage())
                .into(icon);
    }
}