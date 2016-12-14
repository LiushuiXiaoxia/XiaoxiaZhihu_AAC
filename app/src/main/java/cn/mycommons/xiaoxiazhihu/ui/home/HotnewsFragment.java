package cn.mycommons.xiaoxiazhihu.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.callback.AdvancedSubscriber;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastTemeTopStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonMvpFragment;
import cn.mycommons.xiaoxiazhihu.ui.base.common.FragmentLauncher;

/**
 * HotnewsFragment <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class HotnewsFragment extends CommonMvpFragment<HotnewsPresenter, HotnewsPresenter.IHotnewsView> {

    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    MyAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_hotnews;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("今日热闻");

        adapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                doGetRequest();
            }
        });
        doGetRequest();
    }

    void doGetRequest() {
        presenter.doGetLastTheme()
                .subscribe(new AdvancedSubscriber<GetLastThemeResponse>() {
                    @Override
                    public void onHandleSuccess(GetLastThemeResponse response) {
                        super.onHandleSuccess(response);

                        update(response);
                    }
                });
    }

    void update(GetLastThemeResponse response) {
        swipeRefreshLayout.setRefreshing(false);
        adapter.notifyDataSetChanged(response);
    }

    @Override
    protected HotnewsPresenter.IHotnewsView getViewInstance() {
        return new HotnewsPresenter.IHotnewsView() {

        };
    }

    private class MyAdapter extends RecyclerView.Adapter {

        static final int TYPE_HEADER = 1;
        static final int TYPE_ITEM = 2;
        static final int TYPE_TITLE = 3;
        List<Object> data;
        List<LastTemeTopStory> tops;

        {
            data = new ArrayList<>();
            tops = new ArrayList<>();
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return TYPE_HEADER;
            } else if (data.get(position) instanceof LastThemeStory) {
                return TYPE_ITEM;
            }
            return TYPE_TITLE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (viewType == TYPE_HEADER) {
                FragmentManager manager = getFragmentManager();
                return new TypeHeader(layoutInflater.inflate(R.layout.item_last_header, parent, false), manager);
            } else if (viewType == TYPE_ITEM) {
                return new TypeItem(layoutInflater.inflate(R.layout.item_last_item, parent, false));
            } else {
                return new TypeTitle(layoutInflater.inflate(R.layout.item_last_title, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TypeHeader) {
                TypeHeader item = (TypeHeader) holder;
                item.bind(tops);
            } else if (holder instanceof TypeItem) {
                TypeItem item = (TypeItem) holder;
                item.bind((LastThemeStory) data.get(position - 1));
            } else if (holder instanceof TypeTitle) {
                TypeTitle item = (TypeTitle) holder;
                item.bind((String) data.get(position - 1));
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        void notifyDataSetChanged(GetLastThemeResponse response) {
            data.clear();
            if (response.getStories() != null) {
                data.addAll(response.getStories());
            }
            tops.clear();
            if (response.getTopStories() != null) {
                tops.addAll(response.getTopStories());
            }

            super.notifyDataSetChanged();
        }
    }


    static class TypeHeader extends RecyclerView.ViewHolder {

        @Bind(R.id.viewPager)
        ViewPager viewPager;
        FragmentManager fragmentManager;

        TypeHeader(View itemView, FragmentManager manager) {
            super(itemView);
            this.fragmentManager = manager;
            ButterKnife.bind(this, itemView);
        }

        void bind(List<LastTemeTopStory> tops) {
            List<LastTemeTopStory> topsLocal = tops;
            if (tops == null) {
                topsLocal = new ArrayList<>();
            }

            viewPager.setAdapter(new MyFragmentPagerAdapter(fragmentManager, topsLocal));
        }
    }

    private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        List<LastTemeTopStory> tops;

        MyFragmentPagerAdapter(FragmentManager fm, List<LastTemeTopStory> tops) {
            super(fm);
            this.tops = tops;
        }

        @Override
        public Fragment getItem(int position) {
            TopItemFragment fragment = new TopItemFragment();
            fragment.setTopStory(tops.get(position));
            return fragment;
        }

        @Override
        public int getCount() {
            if (tops != null) {
                return tops.size();
            }
            return 0;
        }
    }

    static class TypeTitle extends RecyclerView.ViewHolder {

        @Bind(R.id.text)
        TextView textView;

        TypeTitle(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String text) {
            textView.setText(text);
        }
    }

    static class TypeItem extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.text)
        TextView textView;
        @Bind(R.id.icon)
        ImageView icon;

        TypeItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        void bind(LastThemeStory story) {
            itemView.setTag(story);
            textView.setText(story.getTitle());
            if (story.getImages() != null && !story.getImages().isEmpty()) {
                Picasso.with(icon.getContext())
                        .load(story.getImages().get(0))
                        .placeholder(R.drawable.ic_launcher)
                        .into(icon);
            }
        }

        @Override
        public void onClick(View v) {
            LastThemeStory story = (LastThemeStory) v.getTag();
            DetailFragment.DetailExtraParam param = new DetailFragment.DetailExtraParam();
            param.setFragmentClass(DetailFragment.class);
            param.id = story.getId();
            FragmentLauncher.launch(v.getContext(), param);
        }
    }
}