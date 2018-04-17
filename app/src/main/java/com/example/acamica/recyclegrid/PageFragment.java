package com.example.acamica.recyclegrid;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acamica.recyclegrid.adapters.PagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    public static final String PAGE_NUMBER_INPUT = "PageNumberInput";
    private int pageNumber;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(PAGE_NUMBER_INPUT, page);

        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        pageNumber = bundle.getInt(PAGE_NUMBER_INPUT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.fragment_page_text);
        textView.setText("Page " + pageNumber);
    }
}
