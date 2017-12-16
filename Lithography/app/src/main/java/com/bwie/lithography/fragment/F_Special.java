package com.bwie.lithography.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.lithography.R;
import com.bwie.lithography.adapter.FSpecialAdapter;
import com.bwie.lithography.bean.Mainpage;
import com.bwie.lithography.dagger.DaggerMyComponent;
import com.bwie.lithography.mvp.presenter.HPresenter;
import com.bwie.lithography.mvp.view.HView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2017/12/12.
 */

public class F_Special extends BaseFragment<HView, HPresenter> implements HView {
    @Bind(R.id.headtitle)
    TextView headtitle;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Inject
    HPresenter presenter;
    private FSpecialAdapter adapter;
    private List<Mainpage.RetBean.ListBean> list;

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().injectfl(this);

    }
    @Override
    protected void initView() {
        headtitle.setText("专题");
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        list = new ArrayList<Mainpage.RetBean.ListBean>();
        presenter.show();
    }


    @Override
    protected HPresenter getPresenter() {
        return presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.special;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void getFL(Mainpage Fdata) {
        if (Fdata == null) {
            Log.e("www", " 1 ");
        } else {
            Log.e("www", "2");
        }

      /*  for (int i = 0; i < Fdata.getRet().getList().size(); i++) {
            if(list.get(i).getList().get(i).getMoreURL()!=null){
                adapter = new FSpecialAdapter(ArrayList<Mainpage.RetBean.ListBean> list = new ArrayList<>();etContext(), Fdata.getRet());
                mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                mRecyclerView.setAdapter(adapter);
            }
        }*/

        for (int i = 0; i < Fdata.getRet().getList().size(); i++) {
            if (Fdata.getRet().getList().get(i).getMoreURL() !=  null) {
                list.add(Fdata.getRet().getList().get(i));
            }
        }

        if (adapter == null) {
            adapter = new FSpecialAdapter(getContext(), list);
            mRecyclerView.setAdapter(adapter);
        }
    }



}
