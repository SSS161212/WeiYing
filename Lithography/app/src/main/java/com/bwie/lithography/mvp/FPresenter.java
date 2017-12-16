package com.bwie.lithography.mvp;

import com.bwie.lithography.bean.VideoXQ;
import com.bwie.lithography.mvp.presenter.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dell on 2017/12/13.
 */

public class FPresenter extends BasePresenter<FView> {
    @Inject
    FModel fModel;


    @Inject
    public FPresenter() {
    }

    public void getPageHomeInfo(String modelurl , final int page){


        fModel.getDta(modelurl ,page,new FModel.sendData(){
            @Override
            public void send(List<VideoXQ.RetBean.ListBean> data) {
                getView().onSuccess(data);

            }
        });
    }
}
