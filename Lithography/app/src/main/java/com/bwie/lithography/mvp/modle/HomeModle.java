package com.bwie.lithography.mvp.modle;

import com.bwie.lithography.api.Api;
import com.bwie.lithography.bean.HomeBean;
import com.bwie.lithography.inter.ApiService;
import com.bwie.lithography.util.RetrofitClent;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by 燕子 on 2017/12/14.
 */

public class HomeModle implements IHomeModle{
    @Inject
    public HomeModle() {}

    @Override
    public Flowable<HomeBean> getBanner() {
        return RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.HOST).getHome();
    }
}
