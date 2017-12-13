package com.bwie.lithography.adapter;

import android.view.View;

/**
 * Created by Dell on 2017/12/13.
 */

public abstract class BaseCardAdapter<T> {
    /**
     * 获取卡片的数量
     *
     * @return
     */
    public abstract int getCount();


    /**
     * 获取卡片view的layout id
     *
     * @return
     */
    public abstract int getCardLayoutId();

    /**
     * 将卡片和数据绑定在一起
     *
     * @param position 数据在数据集中的位置
     * @param cardview 要绑定数据的卡片
     * @param data     数据集中对应位置的数据
     */
    public abstract void onBindData(int position, View cardview, T data);

    /**
     * 获取可见的cardview的数目，默认是3
     * @return
     */
    public int getVisibleCardCount() {
        return 5;
    }
}
