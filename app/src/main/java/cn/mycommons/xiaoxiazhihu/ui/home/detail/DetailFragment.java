package cn.mycommons.xiaoxiazhihu.ui.home.detail;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.databinding.FragmentDetailBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonExtraParam;
import cn.mycommons.xiaoxiazhihu.ui.base.common.CommonFragment;
import cn.mycommons.xiaoxiazhihu.ui.base.common.FragmentLauncher;
import cn.mycommons.xiaoxiazhihu.ui.home.CommentsFragment;

/**
 * DetailFragment <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class DetailFragment extends CommonFragment<FragmentDetailBinding> {

    public static class DetailExtraParam extends CommonExtraParam {

        public int id;

        @Override
        public String toString() {
            return "DetailExtraParam{" +
                    "id='" + id + '\'' +
                    "} " + super.toString();
        }
    }

    private DetailExtraParam extraParam;
    private GetStoryExtraResponse storyExtraResponse;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        extraParam = getReqExtraParam();

        binding.webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //启用支持javascript
        WebSettings settings = binding.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");

        setHasOptionsMenu(true);

        doGetRequest();
    }

    private void doGetRequest() {
        DetailViewModel viewModel = ViewModelProviders.of(this, viewModelFactory()).get(DetailViewModel.class);

        viewModel.getGetNewsResponse(extraParam.id)
                .observe(this, new Observer<GetNewsResponse>() {
                    @Override
                    public void onChanged(@Nullable GetNewsResponse response) {
                        update(response);
                    }
                });

        viewModel.getGetStoryExtra(extraParam.id)
                .observe(this, new Observer<GetStoryExtraResponse>() {
                    @Override
                    public void onChanged(@Nullable GetStoryExtraResponse response) {
                        storyExtraResponse = response;
                        getActivity().invalidateOptionsMenu();
                    }
                });
    }


    void update(GetNewsResponse response) {
        if (response != null) {
            binding.tvTitle.setText(response.getTitle());
            binding.tvSource.setText(response.getImageSource());

            binding.setNews(response);
            binding.webView.loadDataWithBaseURL(null, response.getBody(), "text/html", "utf8", null);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail, menu);
        super.onCreateOptionsMenu(menu, inflater);

        if (storyExtraResponse != null) {
            if (storyExtraResponse.getComments() > 0) {
                String title = String.format("评论(%s)", storyExtraResponse.getComments());
                menu.findItem(R.id.menu_comments).setTitle(title);
            }
            if (storyExtraResponse.getPopularity() > 0) {
                String title = String.format("赞(%s)", storyExtraResponse.getPopularity());
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
}