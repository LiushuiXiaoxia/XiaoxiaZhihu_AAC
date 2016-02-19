package cn.mycommons.xiaoxiazhihu.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.business.callback.AdvancedSubscriber;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonExtraParam;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonMvpFragment;
import cn.mycommons.xiaoxiazhihu.ui.base.common.FragmentLauncher;

/**
 * DetailFragment <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class DetailFragment extends CommonMvpFragment<DetailPresenter, DetailPresenter.IDetailView> {

    public static class DetailExtraParam extends CommonExtraParam {

        public int id;

        @Override
        public String toString() {
            return "DetailExtraParam{" +
                    "id='" + id + '\'' +
                    "} " + super.toString();
        }
    }

    @Bind(R.id.rlDetailTop)
    RelativeLayout rlDetailTop;
    @Bind(R.id.icon)
    ImageView icon;
    @Bind(R.id.webview)
    WebView webView;
    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.tvSource)
    TextView tvSource;

    DetailExtraParam extraParam;
    GetStoryExtraResponse storyExtraResponse;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        extraParam = getReqExtraParam();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //启用支持javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");

        setHasOptionsMenu(true);

        doGetRequest();
    }

    private void doGetRequest() {
        presenter.doGetNewsResponse(extraParam.id)
                .subscribe(new AdvancedSubscriber<GetNewsResponse>(mvpActivity) {
                    @Override
                    public void onHandleSuccess(GetNewsResponse response) {
                        super.onHandleSuccess(response);

                        update(response);
                    }
                });

        presenter.doGetStoryExtra(extraParam.id)
                .subscribe(new AdvancedSubscriber<GetStoryExtraResponse>() {
                    @Override
                    public void onHandleSuccess(GetStoryExtraResponse response) {
                        super.onHandleSuccess(response);
                        storyExtraResponse = response;

                        getActivity().invalidateOptionsMenu();
                        getSupportActionBar().invalidateOptionsMenu();
                    }
                });
    }


    void update(GetNewsResponse response) {
        if (response != null) {
            tvTitle.setText(response.title);
            tvSource.setText(response.imageSource);

            if (TextUtils.isEmpty(response.image)) {
                rlDetailTop.setVisibility(View.GONE);
            } else {
                Picasso.with(icon.getContext())
                        .load(response.image)
                        .into(icon);
            }
            webView.loadDataWithBaseURL(null, response.body, "text/html", "utf8", null);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail, menu);
        super.onCreateOptionsMenu(menu, inflater);

        if (storyExtraResponse != null) {
            if (storyExtraResponse.comments > 0) {
                String title = String.format("评论(%d)", storyExtraResponse.comments);
                menu.findItem(R.id.menu_comments).setTitle(title);
            }
            if (storyExtraResponse.popularity > 0) {
                String title = String.format("赞(%d)", storyExtraResponse.popularity);
                menu.findItem(R.id.menu_popularity).setTitle(title);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_comments && storyExtraResponse != null) {
            CommentsFragment.CommentsExtraParam param = new CommentsFragment.CommentsExtraParam();
            param.id = extraParam.id;
            param.storyExtraResponse = storyExtraResponse;
            param.setFragmentClass(CommentsFragment.class);
            FragmentLauncher.launch(this, param, 0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected DetailPresenter.IDetailView getViewInstance() {
        return new DetailPresenter.IDetailView() {

        };
    }
}