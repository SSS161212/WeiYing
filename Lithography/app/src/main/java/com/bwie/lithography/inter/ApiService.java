package com.bwie.lithography.inter;

import com.bwie.lithography.app.FindBean;
import com.bwie.lithography.bean.HomeBean;

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

    //发现
    @GET("columns/getVideoList.do")
    Flowable<FindBean> getFindVideoList(@Query("catalogId") String catalogId ,@Query("pnum") String pnum);

}
