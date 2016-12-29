package com.yonghui.h5.androidrnsample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.yonghui.h5.fragments.TabFragment;
import com.yonghui.h5.fragments.TabPageFragment;
import com.yonghui.h5.rnmanager.RNManager;

public class TabActivity extends ReactActivity implements TabFragment.OnFragmentInteractionListener,TabPageFragment.OnFragmentInteractionListener{
    private ViewPager mViewPager;
    private Fragment tabFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        RNManager.setReactInstanceManager(getReactInstanceManager());
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        this.addTabFragment();
        this.addViewPagerFragment();
    }

    private  void addTabFragment() {
        FragmentManager fm = getFragmentManager();
        tabFragment =  fm.findFragmentById(R.id.tabs_btns_fragment_holder);
        if(tabFragment == null) {
            tabFragment = TabFragment.newInstance("arr1","arr2");
            fm.beginTransaction()
                    .add(R.id.tabs_btns_fragment_holder,tabFragment)
                    .commit();
        }
    }

    private void addViewPagerFragment() {
        FragmentManager fm = getFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return TabPageFragment.newInstance("arr1","arr2");
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                System.out.println(position);
                ((TabFragment)tabFragment).activeBtn(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
