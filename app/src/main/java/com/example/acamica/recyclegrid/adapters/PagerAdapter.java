package com.example.acamica.recyclegrid.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.acamica.recyclegrid.PageFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    public static final int PAGE_COUNT = 4;
    private Context context;

    public PagerAdapter(FragmentManager fragmentManager, Context context){
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
