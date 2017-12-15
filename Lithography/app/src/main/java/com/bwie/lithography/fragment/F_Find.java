package com.bwie.lithography.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.lithography.R;
import com.bwie.lithography.api.Api;
import com.bwie.lithography.app.FindBean;
import com.bwie.lithography.dagger.DaggerMyComponent;
import com.bwie.lithography.mvp.presenter.FindPresenter;
import com.bwie.lithography.mvp.view.FindView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2017/12/12.
 */

public class F_Find extends BaseFragment<FindView, FindPresenter> implements FindView {

    @Inject
    FindPresenter presenter;
    @Bind(R.id.headtitle)
    TextView headtitle;

    private FindBean findData;

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().inject(this);
}


    @Override
    protected void initView() {
        headtitle.setText("发现");
        presenter.getVideoList(Api.CATALOGID, 10 + "");
    }

    @Override
    protected FindPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void getVideoList(FindBean findBean) {
        findData = findBean;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.find;
    }
}
