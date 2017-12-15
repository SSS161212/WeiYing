package com.bwie.lithography.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lithography.adapter.HomeVideoAdapter;
import com.bwie.lithography.R;
import com.bwie.lithography.bean.HomeBean;
import com.bwie.lithography.dagger.DaggerMyComponent;
import com.bwie.lithography.mvp.presenter.HomePresenter;
import com.bwie.lithography.mvp.view.HomeView;
import com.bwie.lithography.util.MyImageLoader;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.transformer.CubeOutTransformer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dell on 2017/12/12.
 */

public class F_Choiceness extends BaseFragment<HomeView, HomePresenter> implements HomeView {

    @Inject
    HomePresenter homePresenter;

    @Bind(R.id.recy)
    XRecyclerView recy;
   private Banner banner;


    @Override
    protected int getLayoutId() {
        return R.layout.choiceness;
    }

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().inject(this);

    }


    @Override
    protected void initView() {
        View view = View.inflate(getActivity(), R.layout.bann, null);
        banner =(Banner) view.findViewById(R.id.play);
        recy.addHeaderView(view);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        homePresenter.setBanner();

    }

    @Override
    protected HomePresenter getPresenter() {
        return homePresenter;
    }


    @Override
    public void getBann(HomeBean bean) {

       banne(bean);

        HomeVideoAdapter homeVideoAdapter = new HomeVideoAdapter(bean, getActivity());
        recy.setAdapter(homeVideoAdapter);

    }

    private void banne(HomeBean bean) {
        List bannerList=new ArrayList<String>();
        for (int i = 0; i < bean.getRet().getList().get(0).getChildList().size(); i++) {
            String pic = bean.getRet().getList().get(0).getChildList().get(i).getPic();
            bannerList.add(pic);
            Log.i("ll",bannerList.toString());
        }
        banner.setImages(bannerList).setBannerAnimation(CubeOutTransformer.class)
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new MyImageLoader()).start();
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
