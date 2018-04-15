package com.example.acamica.recyclegrid;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acamica.recyclegrid.adapters.PagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabSelectorFragment extends Fragment {


    public TabSelectorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_selector, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewPager viewPager = getActivity().findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getActivity().getSupportFragmentManager(), getActivity()));
    }

}
