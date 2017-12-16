package com.bwie.lithography.mvp.modle;

import android.util.Log;

import com.bwie.lithography.api.Api;
import com.bwie.lithography.bean.Mainpage;
import com.bwie.lithography.inter.ApiService;
import com.bwie.lithography.util.RetrofitClent;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Dell on 2017/12/14.
 */

public class HModel {
    @Inject
    public HModel() {
    }

    public void getData(final SendData sendData){

        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.HOST);
        Flowable<Mainpage> flowable = apiService.gethomeUrl();
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Mainpage>() {
                    @Override
                    public void onNext(Mainpage retBean) {
                        Log.e("ttt","111");
                        sendData.send(retBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public interface SendData{
        void send(Mainpage o);
    }
}
