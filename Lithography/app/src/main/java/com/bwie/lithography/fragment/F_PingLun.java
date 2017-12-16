package com.bwie.lithography.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.lithography.R;
import com.bwie.lithography.adapter.CommentAdapter;
import com.bwie.lithography.bean.VideoRes;

import com.bwie.lithography.mvp.presenter.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2017/12/15.
 */

public class F_PingLun extends BaseFragment {
    @Bind(R.id.comment_rv)
    RecyclerView commentRv;
    @Bind(R.id.no_pl)
    TextView noPl;

    @Override
    protected int getLayoutId() {
        return R.layout.commentfragment;
    }


    @Override
    protected void initDagger() {

    }


    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        VideoRes detail = (VideoRes) bundle.getSerializable("videoRes");
        if (detail.getRet().getList().size() == 0) {
            noPl.setVisibility(View.VISIBLE);
            commentRv.setVisibility(View.GONE);
        } else {
            noPl.setVisibility(View.GONE);
            commentRv.setVisibility(View.VISIBLE);
            commentRv.setLayoutManager(new LinearLayoutManager(getActivity()));
            commentRv.setAdapter(new CommentAdapter(getActivity(), detail));
        }
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    //实例fragment  传值
    public static Fragment newInstance(VideoRes videoRes) {
        //实例Bundle
        Bundle bundle = new Bundle();
        //传值
        bundle.putSerializable("videoRes", videoRes);
        //实例Fragment_
        F_PingLun fragment_ = new F_PingLun();
        //传值
        fragment_.setArguments(bundle);
        return fragment_;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
