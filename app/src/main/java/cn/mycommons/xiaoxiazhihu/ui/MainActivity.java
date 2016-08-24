package cn.mycommons.xiaoxiazhihu.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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

import cn.mycommons.xiaoxiazhihu.R;
import cn.mycommons.xiaoxiazhihu.business.callback.AdvancedSubscriber;
import cn.mycommons.xiaoxiazhihu.business.pojo.bean.ThemeItem;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.MvpActivity;
import cn.mycommons.xiaoxiazhihu.ui.home.HotnewsFragment;
import cn.mycommons.xiaoxiazhihu.ui.home.OtherThemeFragment;

public class MainActivity extends MvpActivity<MainPresenter, MainPresenter.IMenuListView>
        implements MainPresenter.IMenuListView {

    LinearLayout llMainMenuContainer;
    ThemeItem currentThemeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        initSlideMenu();
        updateFragment();

        presenter.doGetAllThemesResponse().subscribe(new AdvancedSubscriber<GetAllThemesResponse>() {
            @Override
            public void onHandleSuccess(GetAllThemesResponse response) {
                super.onHandleSuccess(response);

                update(response.others);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int close = R.string.navigation_drawer_close;
        int open = R.string.navigation_drawer_open;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, open, close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    void initSlideMenu() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        llMainMenuContainer = (LinearLayout) navigationView.getHeaderView(0).findViewById(R.id.llMainMenuContainer);

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

    void update(ThemeItem[] themeItems) {
        while (llMainMenuContainer.getChildCount() > 1) {
            llMainMenuContainer.removeViewAt(llMainMenuContainer.getChildCount() - 1);
        }

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        for (final ThemeItem item : themeItems) {
            View view = layoutInflater.inflate(R.layout.item_main_menu, llMainMenuContainer, false);
            TextView menu = (TextView) view.findViewById(R.id.menu);
            menu.setText(item.name);
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
            fragment = new HotnewsFragment();
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