package com.cardinalskerrt.cultureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class SellerScreenActivity extends AppCompatActivity implements SellerHomeFragment.OnFragmentInteractionListener
        , SellerMyProductFragment.OnFragmentInteractionListener
        , VpPostsFragment.OnFragmentInteractionListener {

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    ViewPager sellerViewPager;
    PagerAdapter sellerPageAdapter;
    TabLayout sellerTabLayout;
    TabItem sellerHomeTab;
    TabItem sellerMarketTab;
    TabItem sellerProfileTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_screen);


        sellerViewPager = findViewById(R.id.sellerViewPager);
        sellerTabLayout = findViewById(R.id.sellerTabLayout);
        sellerHomeTab = findViewById(R.id.sellerHomeTab);
        sellerMarketTab = findViewById(R.id.sellerMarketTab);
        sellerProfileTab = findViewById(R.id.sellerProfileTab);


        sellerPageAdapter = new PageAdapter(getSupportFragmentManager(), sellerTabLayout.getTabCount());
        sellerViewPager.setAdapter(sellerPageAdapter);

        sellerTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                sellerViewPager.setCurrentItem(tab.getPosition());
                sellerPageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        sellerViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(sellerTabLayout));





    }

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
                case 0 :
                    return SellerHomeFragment.newInstance("param1","param2");
                case 1:
                    return SellerMyProductFragment.newInstance("","");
                case 2:
                    return VpPostsFragment.newInstance("","");

                default:
                            break;

            }

            return null;
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
