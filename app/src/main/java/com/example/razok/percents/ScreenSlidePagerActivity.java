package com.example.razok.percents;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class ScreenSlidePagerActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(1);
    }
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 1) {
            super.onBackPressed();
        } else if(mPager.getCurrentItem() == 0) {
            mPager.setCurrentItem(mPager.getCurrentItem() + 1);
        }
        else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new Fragment531();
                case 1: return new FragmentCustom();
                case 2: return new FragmentDeload();
                default: return new FragmentCustom();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
