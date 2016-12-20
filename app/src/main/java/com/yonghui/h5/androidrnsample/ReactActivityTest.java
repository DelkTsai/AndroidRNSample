package com.yonghui.h5.androidrnsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactRootView;

public class ReactActivityTest extends ReactActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_react_test);
        this.setUpReactView();
    }

    private void setUpReactView() {
        ReactRootView mReactRootView = (ReactRootView) findViewById(R.id.react_root_view_1);
        mReactRootView.startReactApplication(this.getReactInstanceManager(),"TestComp",null);

        ReactRootView mReactRootView2 = (ReactRootView) findViewById(R.id.react_root_view_2);
        mReactRootView2.startReactApplication(this.getReactInstanceManager(),"HelloWorld",null);
    }

//    @Override
//    protected String getMainComponentName() {
//        return "HelloWorld";
//    }
}
