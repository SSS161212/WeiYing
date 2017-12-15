package com.bwie.lithography.mvp.modle;

import android.util.Log;

import com.bwie.lithography.api.Api;
import com.bwie.lithography.bean.DetailBean;
import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.bean.VideoRes;
import com.bwie.lithography.inter.ApiService;
import com.bwie.lithography.util.RetrofitClent;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Dell on 2017/12/13.
 */

public class FindModle implements IFindModle{
    @Inject
    public FindModle() {
    }

    @Override
    public void getVodeoList(String catalogId, String pnum, final sendData sendData) {
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.HOST);
        Flowable<FindBean> flowable = apiService.getFindVideoList(catalogId, pnum);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<FindBean>() {
                    @Override
                    public void onNext(FindBean findBean) {
                        sendData.send(findBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDetail(String mediaId, final sendData sendData) {
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.HOST);
        Flowable<DetailBean> flowable = apiService.getDetail(mediaId);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DetailBean>() {
                    @Override
                    public void onNext(DetailBean detailBean) {
                        sendData.send(detailBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getComment(String mediaId, String pnum, final sendData sendData) {
        ApiService apiService = RetrofitClent.getRetrofitClientInstance().getApiService(ApiService.class, Api.HOST);
        Flowable<VideoRes> flowable = apiService.getCommentList(mediaId,pnum);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<VideoRes>() {
                    @Override
                    public void onNext(VideoRes videoRes) {
                        sendData.send(videoRes);
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
        void send(Object o);
    }
}
