package com.yonghui.h5.androidrnsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactRootView;

public class LoginActivity extends ReactActivity {

    private ReactRootView mReactRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setupReactLoginView();
    }

    private void setupReactLoginView() {
        mReactRootView = (ReactRootView) this.findViewById(R.id.react_login_page);
        mReactRootView.startReactApplication(this.getReactInstanceManager(),"Login");
    }
}
