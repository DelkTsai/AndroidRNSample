package com.yonghui.h5.androidrnsample;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yonghui.h5.rnmanager.RNManager;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initOpenReactBtn();
        this.initOpenReactActivityBtn();
        this.initOpenLoginPageBtn();
        this.initOpenTabPageBtn();
        this.initQRCodePageBtn();
        //初始化ReactInstanceManager 单例模式
    }

    private void initOpenReactBtn() {
        Button react = (Button) this.findViewById(R.id.open_react_btn);
        react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MyReactActivity.class));
            }
        });
    }

    private void initOpenReactActivityBtn() {
        Button react = (Button) this.findViewById(R.id.open_react_activity_btn);
        react.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ReactActivityTest.class));
            }
        });
    }

    private void initOpenLoginPageBtn() {
        Button goLogin = (Button) this.findViewById(R.id.open_react_login_page);
        goLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }

    private void initOpenTabPageBtn() {
        Button goTabs = (Button) this.findViewById(R.id.tab_activity_btn);
        goTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TabActivity.class));
            }
        });

    }

    private void initQRCodePageBtn() {
        Button qrBtn = (Button) this.findViewById(R.id.qr_activity);
        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,QrcodeActivity.class));
            }
        });
    }
}
