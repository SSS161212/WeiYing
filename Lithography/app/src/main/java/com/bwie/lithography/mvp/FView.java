package com.bwie.lithography.mvp;

import com.bwie.lithography.bean.VideoXQ;

import java.util.List;

/**
 * Created by Dell on 2017/12/13.
 */

public interface FView {
    void onSuccess(List<VideoXQ.RetBean.ListBean> data);
}
