package com.bwie.lithography.inter;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Dell on 2017/12/13.
 */

public interface ApiService {
    //发现
    @GET("columns/getVideoList.do")
    Flowable getFindVideoList();
}
