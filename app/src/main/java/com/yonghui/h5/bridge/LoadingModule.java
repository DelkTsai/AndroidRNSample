package com.yonghui.h5.bridge;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by wulihong on 16/12/30.
 */

public class LoadingModule extends ReactContextBaseJavaModule {

    public LoadingModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "Loading";
    }

    @ReactMethod
    public void showLoading() {

    }

    @ReactMethod
    public void hideLoading() {

    }
}
