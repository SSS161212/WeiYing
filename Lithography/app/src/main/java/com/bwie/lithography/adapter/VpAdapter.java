package com.bwie.lithography.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by Dell on 2017/12/15.
 */

public class VpAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;
    private String[] strings;

    public VpAdapter(FragmentManager fm, List<Fragment> list, String[] strings) {
        super(fm);
        this.list = list;
        this.strings = strings;
    }

    public VpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
