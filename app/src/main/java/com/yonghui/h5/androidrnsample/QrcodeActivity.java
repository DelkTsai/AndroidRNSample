package com.yonghui.h5.androidrnsample;
import android.app.Activity;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.Result;
import com.yonghui.h5.constant.Constants;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrcodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mQRView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        this.setUPQRScannerView();
    }

    private void setUPQRScannerView() {
        mQRView = new ZXingScannerView(this);
        setContentView(mQRView);
        mQRView.setResultHandler(this);
        mQRView.startCamera();
    }

    public void handleResult(Result result) {
        System.out.println("=====================");
        System.out.println("====" + result.getText());
        Intent intent = new Intent();
        intent.putExtra(Constants.QR_SCANNER_RESULT,result.getText());
        setResult(Activity.RESULT_OK,intent);
        mQRView.stopCamera();
        this.finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        mQRView.stopCamera();
    }
}
