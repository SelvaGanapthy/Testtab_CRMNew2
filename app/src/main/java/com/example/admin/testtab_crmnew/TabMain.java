package com.example.admin.testtab_crmnew;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 10/3/2017.
 */

public class TabMain extends Fragment {
    ViewPager view_Pager;
    TabLayout tab_Layout;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tabmain_design, container, false);
        view_Pager = (ViewPager) view.findViewById(R.id.view_pager);
        tab_Layout = (TabLayout) view.findViewById(R.id.tab_layout);
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        view_Pager.setAdapter(pagerAdapter);
       tab_Layout.post(new Runnable() {
           @Override
           public void run() {
               tab_Layout.setupWithViewPager(view_Pager);
           }
       });


        return view;
    }
    class PagerAdapter extends FragmentPagerAdapter {
        Context context;
        String[] titles_tab = {"TO DO", "HOT CASES", "LOGS"};

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return titles_tab.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1 tab1=new Tab1();
                    return tab1;
                case 1:
                    return new Tab1();
                case 2:
                    return new Tab1();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles_tab[position];
        }


    }

}
