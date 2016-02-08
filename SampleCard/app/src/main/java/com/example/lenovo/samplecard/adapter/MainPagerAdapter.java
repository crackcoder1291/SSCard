package com.example.lenovo.samplecard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by ddvlslyr on 10/1/16.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabs;
    private ArrayList<Fragment> fragments;

    public MainPagerAdapter(FragmentManager fm, String[] tabs, ArrayList<Fragment> fragments) {
        super(fm);
        this.tabs = tabs;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

