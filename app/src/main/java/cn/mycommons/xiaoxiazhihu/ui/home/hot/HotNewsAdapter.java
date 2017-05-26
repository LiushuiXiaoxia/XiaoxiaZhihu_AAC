package cn.mycommons.xiaoxiazhihu.ui.home.hot;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeTopStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetLastThemeResponse;

/**
 * HotNewsAdapter <br/>
 * Created by xiaqiulei on 2017-05-25.
 */
class HotNewsAdapter extends RecyclerView.Adapter {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ITEM = 2;
    private static final int TYPE_TITLE = 3;

    private FragmentManager manager;

    private List<Object> data = new ArrayList<>();
    private List<LastThemeTopStory> tops = new ArrayList<>();

    HotNewsAdapter(FragmentManager fragmentManager) {
        this.manager = fragmentManager;
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
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (viewType == TYPE_HEADER) {
            return new HotNewsTypeHeader(layoutInflater.inflate(R.layout.item_last_header, parent, false), manager);
        } else if (viewType == TYPE_ITEM) {
            return new HotNewsTypeItem(layoutInflater.inflate(R.layout.item_last_item, parent, false));
        } else {
            return new HotNewsTypeTitle(layoutInflater.inflate(R.layout.item_last_title, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HotNewsTypeHeader) {
            HotNewsTypeHeader item = (HotNewsTypeHeader) holder;
            item.bind(tops);
        } else if (holder instanceof HotNewsTypeItem) {
            HotNewsTypeItem item = (HotNewsTypeItem) holder;
            item.bind((LastThemeStory) data.get(position - 1));
        } else if (holder instanceof HotNewsTypeTitle) {
            HotNewsTypeTitle item = (HotNewsTypeTitle) holder;
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