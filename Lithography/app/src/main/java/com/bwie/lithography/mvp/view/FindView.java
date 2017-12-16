package com.bwie.lithography.mvp.view;
import com.bwie.lithography.bean.DetailBean;
import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.bean.VideoRes;


import com.bwie.lithography.bean.FindBean;

/**
 * Created by Dell on 2017/12/13.
 */

public interface FindView {
    void getVideoList(FindBean findBean);
    void getDetail(DetailBean detailBean);
    void getComment(VideoRes videoRes);
}
