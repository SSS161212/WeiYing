package com.bwie.lithography.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.lithography.R;
import com.bwie.lithography.mvp.presenter.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2017/12/12.
 */

public class F_Special extends BaseFragment {
    @Bind(R.id.headtitle)
    TextView headtitle;

    @Override
    protected void initDagger() {

    }

    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.special, container, false);
    }

    @Override
    protected void initView() {
        headtitle.setText("专题");
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
}
