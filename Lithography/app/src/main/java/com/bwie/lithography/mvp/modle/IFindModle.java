package com.bwie.lithography.mvp.modle;

/**
 * Created by Dell on 2017/12/13.
 */

public interface IFindModle {
    void getVodeoList(String catalogId, String pnum, FindModle.sendData sendData);
    void getDetail(String mediaId, FindModle.sendData sendData);
    void getComment(String mediaId,String pnum,FindModle.sendData sendData);
}
