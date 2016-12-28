package com.yonghui.h5.rnmanager;

import android.app.Application;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManager.Builder;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.yonghui.h5.androidrnsample.BuildConfig;
import com.yonghui.h5.bridge.AddReactPackage;

/**
 * Created by wulihong on 16/12/28.
 */
public class RNManager {
    private static ReactInstanceManager reactInstanceManager = null;
    private static ReactInstanceManager _reactInstanceManager = null;

    public static ReactInstanceManager getReactInstanceManager(Application application) {
        if(reactInstanceManager == null) {
            reactInstanceManager = ReactInstanceManager.builder()
                    .setApplication(application)
                    .setBundleAssetName("index.android.bundle")
                    .setJSMainModuleName("index.android")
                    .addPackage(new MainReactPackage())
                    .addPackage(new AddReactPackage())
                    .setUseDeveloperSupport(true)
                    .setUseDeveloperSupport(BuildConfig.DEBUG)
                    .setInitialLifecycleState(LifecycleState.RESUMED)
                    .build();
        }
        return reactInstanceManager;
    }

    public static void setReactInstanceManager(ReactInstanceManager rim) {
        _reactInstanceManager = rim;
    }

    public static ReactInstanceManager _getReactInstanceManager() {
        return _reactInstanceManager;
    }
}
