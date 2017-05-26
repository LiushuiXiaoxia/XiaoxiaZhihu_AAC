package cn.mycommons.xiaoxiazhihu.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.biz.pojo.bean.ThemeItem;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.databinding.ActivityMainBinding;
import cn.mycommons.xiaoxiazhihu.ui.base.AacBaseActivity;
import cn.mycommons.xiaoxiazhihu.ui.home.hot.HotNewsFragment;
import cn.mycommons.xiaoxiazhihu.ui.home.other.OtherThemeFragment;

public class MainActivity extends AacBaseActivity<ActivityMainBinding> {

    LinearLayout llMainMenuContainer;
    ThemeItem currentThemeItem;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        initSlideMenu();
        updateFragment();
        loadData();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int close = R.string.navigation_drawer_close;
        int open = R.string.navigation_drawer_open;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, open, close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    void initSlideMenu() {
        llMainMenuContainer = (LinearLayout) binding.navView.getHeaderView(0).findViewById(R.id.llMainMenuContainer);

        llMainMenuContainer.findViewById(R.id.tvHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentThemeItem != null) {
                    currentThemeItem = null;
                    updateFragment();
                }
                clearBackground(v);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    private void loadData() {
        MainViewModel mainViewModel = ViewModelProviders.of(this, viewModelFactory()).get(MainViewModel.class);
        mainViewModel.getAllThemeResponse().observe(this, new Observer<GetAllThemesResponse>() {
            @Override
            public void onChanged(@Nullable GetAllThemesResponse getAllThemesResponse) {
                if (getAllThemesResponse != null) {
                    update(getAllThemesResponse.getOthers());
                }
            }
        });
        mainViewModel.loadAllTheme();
    }

    void update(List<ThemeItem> themeItems) {
        while (llMainMenuContainer.getChildCount() > 1) {
            llMainMenuContainer.removeViewAt(llMainMenuContainer.getChildCount() - 1);
        }

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        for (final ThemeItem item : themeItems) {
            View view = layoutInflater.inflate(R.layout.item_main_menu, llMainMenuContainer, false);
            TextView menu = (TextView) view.findViewById(R.id.menu);
            menu.setText(item.getName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentThemeItem != item) {
                        currentThemeItem = item;
                        updateFragment();
                        clearBackground(v);
                    }
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
            });
            llMainMenuContainer.addView(view);
        }
    }

    void updateFragment() {
        String tag = "content_fragment";
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        if (currentThemeItem != null) {
            fragment = OtherThemeFragment.newInstance(currentThemeItem);
        } else {
            fragment = new HotNewsFragment();
        }
        transaction.replace(R.id.flFragmentContainer, fragment, tag).commitAllowingStateLoss();
    }

    void clearBackground(View selectView) {
        for (int i = llMainMenuContainer.getChildCount() - 1; i >= 0; i--) {
            View view = llMainMenuContainer.getChildAt(i);
            view.setBackgroundColor(Color.TRANSPARENT);
        }
        selectView.setBackgroundColor(Color.parseColor("#cccccc"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}