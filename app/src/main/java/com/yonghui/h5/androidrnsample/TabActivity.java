package com.yonghui.h5.androidrnsample;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yonghui.h5.fragments.TabFragment;
import com.yonghui.h5.fragments.TabPageFragment;

public class TabActivity extends AppCompatActivity implements TabFragment.OnFragmentInteractionListener,TabPageFragment.OnFragmentInteractionListener{
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        this.addTabFragment();
        this.addViewPagerFragment();
    }

    private  void addTabFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment tabFragment =  fm.findFragmentById(R.id.tabs_btns_fragment_holder);
        if(tabFragment == null) {
            tabFragment = TabFragment.newInstance("arr1","arr2");
            fm.beginTransaction()
                    .add(R.id.tabs_btns_fragment_holder,tabFragment)
                    .commit();
        }
    }

    private void addViewPagerFragment() {
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return TabPageFragment.newInstance("arr1","arr2");
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    public void onTabFragmentInteraction(int index) {
        if(mViewPager != null) {
            mViewPager.setCurrentItem(index);
        }
    }

    public void onTabPageFragmentInteraction(Uri uri) {

    }
}
