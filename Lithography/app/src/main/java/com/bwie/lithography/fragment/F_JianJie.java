package com.bwie.lithography.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.lithography.R;
import com.bwie.lithography.adapter.LikesAdapter;
import com.bwie.lithography.bean.DetailBean;
import com.bwie.lithography.mvp.presenter.BasePresenter;

import java.io.Serializable;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.carbs.android.expandabletextview.library.ExpandableTextView;

/**
 * Created by Dell on 2017/12/15.
 */

public class F_JianJie extends BaseFragment {
    @Bind(R.id.jianjie_tv)
    ExpandableTextView jianjieTv;
    @Bind(R.id.look_more)
    RecyclerView lookMore;
    @Bind(R.id.director)
    TextView director;
    @Bind(R.id.actor)
    TextView actor;

    @Override
    protected int getLayoutId() {
        return R.layout.jianjiefragment;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        DetailBean detail = (DetailBean) bundle.getSerializable("detail");
        if (detail.getRet().getDirector()!= ""){
            director.setText("导演："+detail.getRet().getDirector());
        }
        if (detail.getRet().getActors() != ""){
            actor.setText("演员："+detail.getRet().getActors());
        }
        jianjieTv.setText("简介："+detail.getRet().getDescription());
        lookMore.setLayoutManager(new GridLayoutManager(getActivity(),3));
        lookMore.setAdapter(new LikesAdapter(getActivity(),detail));
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
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

    //实例fragment  传值
    public static Fragment newInstance(DetailBean detailBean) {
        //实例Bundle
        Bundle bundle = new Bundle();
        //传值
        bundle.putSerializable("detail", detailBean);
        //实例Fragment_
        F_JianJie fragment_ = new F_JianJie();
        //传值
        fragment_.setArguments(bundle);
        return fragment_;
    }
}
