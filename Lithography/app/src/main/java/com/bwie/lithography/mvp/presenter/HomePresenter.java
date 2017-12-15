package com.bwie.lithography.mvp.presenter;

import android.util.Log;

import com.bwie.lithography.bean.HomeBean;
import com.bwie.lithography.mvp.modle.HomeModle;
import com.bwie.lithography.mvp.view.HomeView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 燕子 on 2017/12/14.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    @Inject
      public HomePresenter() {}
    @Inject
    HomeModle homeModle;

    public void setBanner() {

        homeModle.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<HomeBean>() {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        if (getView() == null){
                            Log.i("xxvvv 11", homeBean.toString());
                        }
                        getView().getBann(homeBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
