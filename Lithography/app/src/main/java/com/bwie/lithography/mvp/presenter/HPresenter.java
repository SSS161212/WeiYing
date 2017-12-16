package com.bwie.lithography.mvp.presenter;

import android.util.Log;

import com.bwie.lithography.bean.Mainpage;
import com.bwie.lithography.mvp.modle.HModel;
import com.bwie.lithography.mvp.view.HView;

import javax.inject.Inject;

/**
 * Created by Dell on 2017/12/14.
 */

public class HPresenter extends BasePresenter<HView>{
    @Inject
    HModel hModel;
    @Inject
    public HPresenter() {
    }

    public void show(){
        hModel.getData(new HModel.SendData() {
            @Override
            public void send(Mainpage o) {
                Log.e("cc",o.toString());
                getView().getFL(o);
            }
        });
    }
}
