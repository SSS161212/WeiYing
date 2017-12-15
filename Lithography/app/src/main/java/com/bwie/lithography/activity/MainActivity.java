package com.bwie.lithography.activity;

import android.graphics.Color;

import com.bwie.lithography.R;
import com.bwie.lithography.fragment.F_Choiceness;
import com.bwie.lithography.fragment.F_Find;
import com.bwie.lithography.fragment.F_Mine;
import com.bwie.lithography.fragment.F_Special;
import com.bwie.lithography.mvp.presenter.BasePresenter;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @Bind(R.id.bottomBar)
    BottomTabBar bottomBar;

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        //  startActivity(new Intent(MainActivity.this, Main2Activity.class));
        bottomBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(8)
                .setTabBarBackgroundResource(R.mipmap.bottom_bg)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.GRAY)
                .addTabItem("精选", R.drawable.tab_02, F_Choiceness.class)
                .addTabItem("专题", R.drawable.tab_03, F_Special.class)
                .addTabItem("发现", R.drawable.tab_01, F_Find.class)
                .addTabItem("我的", R.drawable.tab_04, F_Mine.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }


    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

}
