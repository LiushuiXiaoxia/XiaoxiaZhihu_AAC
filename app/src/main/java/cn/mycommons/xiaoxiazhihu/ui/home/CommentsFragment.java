package cn.mycommons.xiaoxiazhihu.ui.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.Comment;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.databinding.FragmentCommentsBinding;
import cn.mycommons.xiaoxiazhihu.databinding.ItemLastTitleBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonExtraParam;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonFragment;

/**
 * CommentFragment <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
public class CommentsFragment extends CommonFragment<FragmentCommentsBinding> {

    private CommentsViewModel commentsViewModel;

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


    private CommentsExtraParam commentsExtraParam;
    private List<Object> data;
    private CommentsAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_comments;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        commentsExtraParam = getReqExtraParam();

        data = new ArrayList<>();
        data.add(commentsExtraParam.storyExtraResponse.getLongComments());

        adapter = new CommentsAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        doGetRequest();
    }

    void doGetRequest() {
        commentsViewModel = ViewModelProviders.of(this, viewModelFactory()).get(CommentsViewModel.class);
        commentsViewModel.getLongCommentsResponse(commentsExtraParam.id)
                .observe(this, new Observer<GetLongCommentsResponse>() {
                    @Override
                    public void onChanged(@Nullable GetLongCommentsResponse response) {
                        adapter.notifyLong(response);
                    }
                });
    }

    private class CommentsAdapter extends RecyclerView.Adapter {

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
            LayoutInflater inflater = LayoutInflater.from(context);
            if (viewType == TYPE_ITEM) {
                return new CommentsTypeItem(inflater.inflate(R.layout.item_last_comment, parent, false));
            } else {
                return new CommentsTypeTitle(inflater.inflate(R.layout.item_last_title, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof CommentsTypeItem) {
                CommentsTypeItem item = (CommentsTypeItem) holder;
                item.bind((Comment) data.get(position));
            } else if (holder instanceof CommentsTypeTitle) {
                CommentsTypeTitle item = (CommentsTypeTitle) holder;
                item.bind((Integer) data.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        void notifyLong(GetLongCommentsResponse response) {
            data.clear();
            data.add(commentsExtraParam.storyExtraResponse.getLongComments());
            if (response.getComments() != null) {
                data.addAll(response.getComments());
            }
            data.add(commentsExtraParam.storyExtraResponse.getShortComments());

            super.notifyDataSetChanged();
        }

        void notifyShort(GetShortCommentsResponse response) {
            List<Comment> comments = response.getComments();
            if (comments != null) {
                data.addAll(comments);
            }

            super.notifyDataSetChanged();
        }
    }

    class CommentsTypeTitle extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ItemLastTitleBinding titleBinding;

        CommentsTypeTitle(View itemView) {
            super(itemView);

            titleBinding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        void bind(Integer count) {
            if (getAdapterPosition() == 0) {
                titleBinding.text.setText(String.format("%s条长评论", count));
            } else {
                titleBinding.text.setText(String.format("%s条短评论", count));
            }
        }

        @Override
        public void onClick(View v) {
            // 不是第一个
            if (getAdapterPosition() != 0 && !commentsViewModel.isLoadShort()) {
                commentsViewModel.getShortCommentsResponse(commentsExtraParam.id)
                        .observe(CommentsFragment.this, new Observer<GetShortCommentsResponse>() {
                            @Override
                            public void onChanged(@Nullable GetShortCommentsResponse response) {
                                adapter.notifyShort(response);

                                int top = itemView.getTop();
                                binding.recyclerView.scrollBy(0, top);
                            }
                        });
            }
        }
    }
}