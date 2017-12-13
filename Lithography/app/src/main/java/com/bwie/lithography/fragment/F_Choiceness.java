package com.bwie.lithography.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lithography.R;
import com.bwie.lithography.mvp.presenter.BasePresenter;

/**
 * Created by Dell on 2017/12/12.
 */

public class F_Choiceness extends BaseFragment{
    @Override
    protected void initDagger() {

    }

    @Override
    protected View getLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.choiceness,container,false);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }
}
