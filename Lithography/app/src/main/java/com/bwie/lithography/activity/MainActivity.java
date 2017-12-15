package com.bwie.lithography.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bwie.lithography.QQSliddingMenu;
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
    @Bind(R.id.iv_1)
    ImageView iv1;
    @Bind(R.id.iv_2)
    ImageView iv2;
    @Bind(R.id.iv_3)
    ImageView iv3;
    @Bind(R.id.iv_4)
    ImageView iv4;
    @Bind(R.id.iv_5)
    ImageView iv5;
    @Bind(R.id.qqsm)
    QQSliddingMenu qqsm;
    @Bind(R.id.sli)
    FrameLayout sli;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void toggleMenu(View view) {
        qqsm.toggleMenu();
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: dd setContentView(...) invocationa
        ButterKnife.bind(this);
    }
}
