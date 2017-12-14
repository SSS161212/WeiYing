package com.bwie.lithography.inter;

import com.bwie.lithography.bean.FindBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dell on 2017/12/13.
 */

public interface ApiService {
    //发现
    @GET("columns/getVideoList.do")
    Flowable<FindBean> getFindVideoList(@Query("catalogId") String catalogId ,@Query("pnum") String pnum);
}
