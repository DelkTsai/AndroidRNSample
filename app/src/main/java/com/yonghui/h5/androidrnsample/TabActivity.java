package com.yonghui.h5.androidrnsample;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yonghui.h5.fragments.TabFragment;

public class TabActivity extends AppCompatActivity implements TabFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        this.addTabFragment();
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

    public void onFragmentInteraction(Uri uri) {

    }
}
