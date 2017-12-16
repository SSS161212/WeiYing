package com.bwie.lithography.inter;
import com.bwie.lithography.bean.DetailBean;

import com.bwie.lithography.bean.FindBean;
import com.bwie.lithography.bean.HomeBean;
import com.bwie.lithography.bean.VideoRes;
import com.bwie.lithography.bean.Mainpage;
import com.bwie.lithography.bean.VideoXQ;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dell on 2017/12/13.
 */

public interface ApiService {
    //http://api.svipmovie.com/front/homePageApi/homePage.do
    //主页
    @GET("homePageApi/homePage.do")
    Flowable<HomeBean> getHome();

    @GET("videoDetailApi/videoDetail.do")
    Flowable<DetailBean> getDetail(@Query("mediaId") String mediaId);


    /**
     * 获取评论列表
     * @param mediaId
     * @param pnum
     * @return
     */
    @GET("Commentary/getCommentList.do")
    Flowable<VideoRes> getCommentList(@Query("mediaId") String mediaId, @Query("pnum") String pnum);


    /**
     * 首页
     * @return
     */
    @GET("homePageApi/homePage.do")
    Flowable<Mainpage> gethomeUrl();


    //发现
    @GET("columns/getVideoList.do")
    Flowable<FindBean> getFindVideoList(@Query("catalogId") String catalogId, @Query("pnum") String pnum);


    /**
     * 影片分类列表
     * @param catalogId
     * @param information
     */
    @GET("columns/getVideoList.do")
    Flowable<VideoXQ> getVideoFL(@Query("catalogId") String catalogId, @Query("information") int information);

}
