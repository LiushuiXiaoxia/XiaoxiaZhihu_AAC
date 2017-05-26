package cn.mycommons.xiaoxiazhihu.ui.home;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.Comment;
import cn.mycommons.xiaoxiazhihu.databinding.ItemLastCommentBinding;

/**
 * CommentsTypeItem <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class CommentsTypeItem extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ItemLastCommentBinding binding;
    private final SimpleDateFormat simpleDateFormat;

    CommentsTypeItem(View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());

        itemView.setOnClickListener(this);
        binding.text.setSingleLine();
    }

    void bind(Comment comment) {
        binding.setDate(simpleDateFormat.format(new Date(comment.getTime() * 1000L)));
        binding.setComment(comment);

        if (TextUtils.isEmpty(comment.getAvatar())) {
            binding.icon.setImageResource(0);
        } else {
            Picasso.with(binding.icon.getContext())
                    .load(comment.getAvatar())
                    .placeholder(R.drawable.ic_launcher)
                    .into(binding.icon);
        }
    }

    @Override
    public void onClick(View v) {
    }
}