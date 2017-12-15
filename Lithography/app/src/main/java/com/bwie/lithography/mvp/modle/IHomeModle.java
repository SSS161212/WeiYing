package com.bwie.lithography.mvp.modle;

import com.bwie.lithography.bean.HomeBean;

import io.reactivex.Flowable;

/**
 * Created by 燕子 on 2017/12/14.
 */

public interface IHomeModle {
    Flowable<HomeBean> getBanner();
}
