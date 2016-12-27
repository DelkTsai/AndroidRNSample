package com.yonghui.h5.bridge;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.yonghui.h5.androidrnsample.ReactActivityTest;
import com.yonghui.h5.constant.Constants;

/**
 * Created by wulihong on 16/12/27.
 */

public class OpenLoginModule extends ReactContextBaseJavaModule {

    private Promise mPromise;

    public OpenLoginModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "OpenLoginPage";
    }

    @ReactMethod
    public  void openLoginPage() throws Exception{
        Activity currentActivity = getCurrentActivity();
        if(currentActivity == null) {
            throw new Exception(Constants.ERROR_ACTIVITY_DOESNT_EXIST);
        }
        final Intent loginPageIntent = new Intent(currentActivity, ReactActivityTest.class);
        currentActivity.startActivity(loginPageIntent);
    }

}
