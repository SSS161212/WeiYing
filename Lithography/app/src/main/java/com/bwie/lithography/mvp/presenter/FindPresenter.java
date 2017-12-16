package com.bwie.lithography.mvp.presenter;

import android.util.Log;

import com.bwie.lithography.bean.DetailBean;
import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.bean.VideoRes;
import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.mvp.modle.FindModle;
import com.bwie.lithography.mvp.view.FindView;

import javax.inject.Inject;

/**
 * Created by Dell on 2017/12/13.
 */

public class FindPresenter extends BasePresenter<FindView>{
    @Inject
    FindModle modlel;

    @Inject
    public FindPresenter() {
    }

    public void getVideoList(String catalogId, String pnum){
        modlel.getVodeoList(catalogId, pnum, new FindModle.sendData() {
            @Override
            public void send(Object o) {
                getView().getVideoList((FindBean) o);
            }
        });
    }

    public void getDetail(String mediaId){
        modlel.getDetail(mediaId, new FindModle.sendData() {
            @Override
            public void send(Object o) {
                getView().getDetail((DetailBean) o);
            }
        });
    }

    public void getComment(String mediaId,String pnum){
        modlel.getComment(mediaId, pnum, new FindModle.sendData() {
            @Override
            public void send(Object o) {
                getView().getComment((VideoRes) o);
            }
        });
    }
}
