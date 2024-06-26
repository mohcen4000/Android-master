package com.uc2.dzprostatecare.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> list=new ArrayList<>();
    List<String> title=new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void addFragment(Fragment fragment,String titl)
    {
        list.add(fragment);
        title.add(titl);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

}
