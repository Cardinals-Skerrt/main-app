package com.cardinalskerrt.cultureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class UserScreen extends AppCompatActivity implements UserMarketplaceFragment.OnFragmentInteractionListener {

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    ViewPager userViewPager;
    PageAdapter userPageAdapter;
    TabLayout userTablayout;
    TabItem userNewsFeedTab;
    TabItem userMarketTab;
    TabItem userProfileTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        //hey comment
        userViewPager = findViewById(R.id.userViewPager);
        userTablayout = findViewById(R.id.userTabLayout);
        userNewsFeedTab = findViewById(R.id.userNewsfeedTab);
        userMarketTab = findViewById(R.id.userMarketTab);
        userProfileTab = findViewById(R.id.userProfileTab);

        userPageAdapter = new PageAdapter(getSupportFragmentManager(), 3);
        userViewPager.setAdapter(userPageAdapter);

        userTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                userViewPager.setCurrentItem(tab.getPosition());
                userPageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        userViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(userTablayout));

    }

    //page adapter for this activity
    private static class PageAdapter extends FragmentPagerAdapter {
        int numOfTabs;

        public PageAdapter(FragmentManager fn, int numOfTabs){
            super(fn);
            this.numOfTabs = numOfTabs;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //TODO return the fragments
            switch (position){
                case 0:
                    return UserMarketplaceFragment.newInstance();
                case 1:
                    return UserMarketplaceFragment.newInstance();
                case 2:
                    return UserMarketplaceFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numOfTabs;
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return super.getItemPosition(object);
        }
    }

}
