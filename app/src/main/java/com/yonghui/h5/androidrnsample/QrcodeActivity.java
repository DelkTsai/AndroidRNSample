package com.yonghui.h5.androidrnsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrcodeActivity extends AppCompatActivity {
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
        mQRView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mQRView.stopCamera();
    }
}
