package com.bwie.lithography.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lithography.mvp.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * 1:类的用途
 * 2：@author Dell
 * 3：@date 2017/12/5
 */

public abstract class BaseFragment<V,P extends BasePresenter> extends Fragment{
    public P presenter;
    private int layoutId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initDagger();
        //绑定ButterKnife
        ButterKnife.bind(getActivity());
        presenter = getPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initDagger();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    protected abstract void initView();

    protected abstract P getPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.removeCompositeDisposable();
            presenter.detachView();
        }
        ButterKnife.unbind(this);
    }

}
