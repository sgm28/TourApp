package com.vogella.android.done;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    //List to store the fragments & their titles
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentTitle = new ArrayList<>();


    //Constructor to called the FragementPagerAdapter
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    //Function to add Fragment and their titles.
    public void addFragment(Fragment Fragment, String title) {
        fragments.add(Fragment);
        fragmentTitle.add(title);
    }


    //FragmentPager Adapter is an interface so getItem and getCount had to be implemented
    //Returns the Fragment position.
    //Use when swiping across the screen
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    //Return the number of fragments
    @Override
    public int getCount() {

        return fragments.size();

    }

    //Returns the title of the fragment.
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
