package com.bwie.lithography.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.lithography.R;
import com.bwie.lithography.adapter.VpAdapter;
import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.fragment.F_JianJie;
import com.bwie.lithography.fragment.F_PingLun;
import com.bwie.lithography.mvp.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoPlayerActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.palyback)
    ImageView palyback;
    @Bind(R.id.playtitle)
    TextView playtitle;
    @Bind(R.id.palycollection)
    ImageView palycollection;
    @Bind(R.id.videoPlayer)
    JZVideoPlayerStandard videoPlayer;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.video_vp)
    ViewPager videoVp;

    private String[] strings = {"简介","评论"};
    private List<Fragment> flist;

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {
        palyback.setOnClickListener(this);
        Intent intent = getIntent();
        FindBean.RetBean.ListBean video = (FindBean.RetBean.ListBean) intent.getSerializableExtra("video");
        videoPlayer.setUp(video.getLoadURL(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, video.getTitle());
        videoPlayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(this).load(video.getPic()).into(videoPlayer.thumbImageView);

        initTabVp();
    }

    private void initTabVp() {
        for (int i = 0; i < strings.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(strings[i]));
        }
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        flist = new ArrayList<>();
        flist.add(new F_JianJie());
        flist.add(new F_PingLun());
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), flist, strings);
        videoVp.setAdapter(vpAdapter);
        tablayout.setupWithViewPager(videoVp);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_video_player;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.palyback:
                finish();
                break;
        }
    }
}