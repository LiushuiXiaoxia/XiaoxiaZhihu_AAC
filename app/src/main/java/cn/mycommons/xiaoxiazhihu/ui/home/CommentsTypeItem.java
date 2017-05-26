package cn.mycommons.xiaoxiazhihu.ui.home;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.Comment;

/**
 * CommentsTypeItem <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class CommentsTypeItem extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.text)
    TextView textView;
    @BindView(R.id.text2)
    TextView textView2;
    @BindView(R.id.text3)
    TextView textView3;
    @BindView(R.id.icon)
    ImageView icon;

    private SimpleDateFormat simpleDateFormat;

    CommentsTypeItem(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        textView.setSingleLine();
    }

    void bind(Comment comment) {
        itemView.setTag(comment);
        textView.setText(comment.getAuthor());
        textView2.setText(comment.getContent());
        textView3.setText(simpleDateFormat.format(new Date(comment.getTime() * 1000L)));

        if (TextUtils.isEmpty(comment.getAvatar())) {
            icon.setImageResource(0);
        } else {
            Picasso.with(icon.getContext())
                    .load(comment.getAvatar())
                    .placeholder(R.drawable.ic_launcher)
                    .into(icon);
        }
    }

    @Override
    public void onClick(View v) {
    }
}