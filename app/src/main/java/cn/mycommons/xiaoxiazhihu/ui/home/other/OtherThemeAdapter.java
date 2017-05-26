package cn.mycommons.xiaoxiazhihu.ui.home.other;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.LastThemeStory;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;

/**
 * OtherThemeAdapter <br/>
 * Created by xiaqiulei on 2017-05-26.
 */
class OtherThemeAdapter extends RecyclerView.Adapter {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ITEM = 2;
    private static final int TYPE_TITLE = 3;

    private List<Object> data;
    private GetThemeResponse getThemeResponse;

    OtherThemeAdapter() {
        data = new ArrayList<>();
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
            return new OtherThemeTypeHeader(layoutInflater.inflate(R.layout.item_top_item_fragment, parent, false));
        } else if (viewType == TYPE_ITEM) {
            return new OtherThemeTypeItem(layoutInflater.inflate(R.layout.item_last_item, parent, false));
        } else {
            return new OtherThemeTypeTitle(layoutInflater.inflate(R.layout.item_last_title, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OtherThemeTypeHeader) {
            OtherThemeTypeHeader item = (OtherThemeTypeHeader) holder;
            item.bind(getThemeResponse);
        } else if (holder instanceof OtherThemeTypeItem) {
            OtherThemeTypeItem item = (OtherThemeTypeItem) holder;
            item.bind((LastThemeStory) data.get(position - 1));
        } else if (holder instanceof OtherThemeTypeTitle) {
            OtherThemeTypeTitle item = (OtherThemeTypeTitle) holder;
            item.bind((String) data.get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void update(GetThemeResponse response) {
        data.clear();
        if (response.getStories() != null) {
            data.addAll(response.getStories());
        }
        this.getThemeResponse = response;

        notifyDataSetChanged();
    }
}