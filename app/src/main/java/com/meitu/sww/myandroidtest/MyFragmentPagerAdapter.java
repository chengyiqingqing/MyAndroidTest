package com.meitu.sww.myandroidtest;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * @author ShaoWenWen
 * @date 2018/10/8
 */
//public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("viewpager_test", "MyFragmentPagerAdapter _____ getItem: "+position );
        return fragmentList.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
