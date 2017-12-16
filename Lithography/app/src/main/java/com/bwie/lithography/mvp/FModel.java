package com.bwie.lithography.mvp;

import android.util.Log;

import com.bwie.lithography.api.Api;
import com.bwie.lithography.bean.VideoXQ;
import com.bwie.lithography.inter.ApiService;
import com.bwie.lithography.util.RetrofitClent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by Dell on 2017/12/14.
 */

public class FModel {

    @Inject
    public FModel() {
    }

    public void getDta(String catalogId,int  infomation ,final sendData sendData ){
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.HOST);
        Flowable<VideoXQ> videoFL = apiService.getVideoFL(catalogId, infomation);
        videoFL.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DefaultSubscriber<VideoXQ>() {

                    @Override
                    public void onNext(VideoXQ videoFL) {
                        Log.e("xxxx" , String.valueOf(videoFL));
                        sendData.send(videoFL.getRet().getList());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface sendData{
        void send(List<VideoXQ.RetBean.ListBean> list);
    }
}
