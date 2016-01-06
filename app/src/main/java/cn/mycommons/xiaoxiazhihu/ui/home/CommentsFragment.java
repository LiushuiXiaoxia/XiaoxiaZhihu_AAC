package cn.mycommons.xiaoxiazhihu.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.business.callback.AdvancedSubscriber;
import cn.mycommons.xiaoxiazhihu.business.pojo.bean.Comment;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonExtraParam;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonMvpFragment;

/**
 * CommentFragment <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
public class CommentsFragment extends CommonMvpFragment<CommentsPresenter, CommentsPresenter.ICommentsView> {

    public static class CommentsExtraParam extends CommonExtraParam {

        public int id;
        public GetStoryExtraResponse storyExtraResponse;

        @Override
        public String toString() {
            return "CommentsExtraParam{" +
                    "id=" + id +
                    ", storyExtraResponse=" + storyExtraResponse +
                    "} " + super.toString();
        }
    }

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    CommentsExtraParam commentsExtraParam;
    List<Object> data;
    MyAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_comments;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        commentsExtraParam = getReqExtraParam();

        data = new ArrayList<>();
        data.add(commentsExtraParam.storyExtraResponse.longComments);
        adapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        doGetRequest();
    }

    void doGetRequest() {
        presenter.doGetLongCommentsById(commentsExtraParam.id)
                .subscribe(new AdvancedSubscriber<GetLongCommentsResponse>() {
                    @Override
                    public void onHandleSuccess(GetLongCommentsResponse response) {
                        super.onHandleSuccess(response);

                        adapter.notifLong(response);
                    }
                });
    }

    class MyAdapter extends RecyclerView.Adapter {

        static final int TYPE_TITLE = 1;
        static final int TYPE_ITEM = 2;

        @Override
        public int getItemViewType(int position) {
            if (data.get(position) instanceof Integer) {
                return TYPE_TITLE;
            }
            return TYPE_ITEM;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (viewType == TYPE_ITEM) {
                return new TypeItem(layoutInflater.inflate(R.layout.item_last_comment, parent, false));
            } else {
                return new TypeTitle(layoutInflater.inflate(R.layout.item_last_title, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TypeItem) {
                TypeItem item = (TypeItem) holder;
                item.bind((Comment) data.get(position));
            } else if (holder instanceof TypeTitle) {
                TypeTitle item = (TypeTitle) holder;
                item.bind((Integer) data.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        void notifLong(GetLongCommentsResponse response) {
            data.clear();
            data.add(commentsExtraParam.storyExtraResponse.longComments);
            data.addAll(Arrays.asList(response.comments));
            data.add(commentsExtraParam.storyExtraResponse.shortComments);

            super.notifyDataSetChanged();
        }

        void notifShort(GetShortCommentsResponse response) {
            data.addAll(Arrays.asList(response.comments));

            super.notifyDataSetChanged();
        }
    }

    class TypeTitle extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.text)
        TextView textView;

        public TypeTitle(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        void bind(Integer count) {
            if (getAdapterPosition() == 0) {
                textView.setText(String.format("%d条长评论", count));
            } else {
                textView.setText(String.format("%d条短评论", count));
            }
        }

        @Override
        public void onClick(View v) {
            // 不是第一个
            if (getAdapterPosition() != 0 && !presenter.isLoadShort()) {
                presenter.doGetShortComments(commentsExtraParam.id)
                        .subscribe(new AdvancedSubscriber<GetShortCommentsResponse>() {
                            @Override
                            public void onHandleSuccess(GetShortCommentsResponse response) {
                                super.onHandleSuccess(response);

                                adapter.notifShort(response);

                                int top = itemView.getTop();
                                recyclerView.scrollBy(0, top);
                            }
                        });
            }
        }
    }

    static class TypeItem extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.text)
        TextView textView;
        @Bind(R.id.text2)
        TextView textView2;
        @Bind(R.id.text3)
        TextView textView3;
        @Bind(R.id.icon)
        ImageView icon;

        SimpleDateFormat simpleDateFormat;

        public TypeItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            textView.setSingleLine();
        }

        void bind(Comment comment) {
            itemView.setTag(comment);
            textView.setText(comment.author);
            textView2.setText(comment.content);
            textView3.setText(simpleDateFormat.format(new Date(comment.time * 1000L)));

            if (TextUtils.isEmpty(comment.avatar)) {
                icon.setImageResource(0);
            } else {
                Picasso.with(icon.getContext())
                        .load(comment.avatar)
                        .placeholder(R.drawable.ic_launcher)
                        .into(icon);
            }
        }

        @Override
        public void onClick(View v) {
        }
    }

    @Override
    protected CommentsPresenter.ICommentsView getViewInstance() {
        return new CommentsPresenter.ICommentsView() {

        };
    }
}