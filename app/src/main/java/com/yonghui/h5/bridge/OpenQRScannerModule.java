package com.yonghui.h5.bridge;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.yonghui.h5.androidrnsample.QrcodeActivity;
import com.yonghui.h5.constant.Constants;

/**
 * Created by wulihong on 16/12/29.
 */

public class OpenQRScannerModule extends ReactContextBaseJavaModule {
    private Promise qrscannerPromise;
    public OpenQRScannerModule(ReactApplicationContext context) {
        super(context);
        context.addActivityEventListener(qrcodeActivityEventListener);
    }

    private final ActivityEventListener qrcodeActivityEventListener = new BaseActivityEventListener(){
        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            if(requestCode == Constants.SCANNER_ACTIVITY_REQUEST_CODE) {
                if(qrscannerPromise != null) {
                    if(resultCode == Activity.RESULT_CANCELED) {
                        qrscannerPromise.reject(Constants.QR_SCANNER_CANCELED,"QR Scanner was canceled");
                    }else if(resultCode == Activity.RESULT_OK) {
                        String qrresult = data.getStringExtra(Constants.QR_SCANNER_RESULT);
                        qrscannerPromise.resolve(qrresult);
                    }
                }
                qrscannerPromise = null;
            }
        }
    };

    @Override
    public String getName() {
        return "OpenQRScanner";
    }

    @ReactMethod
    public void openQRScanner(final Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if(currentActivity == null) {
            promise.reject(Constants.ERROR_ACTIVITY_DOESNT_EXIST,"Activity doesn't exist");
            return;
        }
        qrscannerPromise = promise;
        try {
            final Intent intent = new Intent(currentActivity, QrcodeActivity.class);
            currentActivity.startActivityForResult(intent,Constants.SCANNER_ACTIVITY_REQUEST_CODE);
        }catch (Exception e) {
            qrscannerPromise.reject(Constants.ERROR_ACTIVITY_INIT_FAILURE,e);
            qrscannerPromise = null;
        }
    }

}
