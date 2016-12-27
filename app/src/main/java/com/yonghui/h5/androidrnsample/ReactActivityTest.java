package com.yonghui.h5.androidrnsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactRootView;

public class ReactActivityTest extends ReactActivity {
    private EditText txtInput;
    private ReactActivityTest that;
    ReactRootView mReactRootView;
    ReactRootView mReactRootView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        that = this;
        setContentView(R.layout.activity_react_test);
        this.setUpReactView("RN组件1","RN组件2");
        //this.setUpTxtInput();
    }

    private void setUpTxtInput() {
        txtInput = (EditText) findViewById(R.id.txt_input);
        txtInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String input = txtInput.getText().toString();
                System.out.println(input);
                that.setUpReactView(input,input);
                return false;
            }
        });
    }

    private void setUpReactView(String txt1,String txt2) {
        Bundle initProps1 = new Bundle();
        initProps1.putString("name",txt1);
        Bundle initProps2 = new Bundle();
        initProps2.putString("name",txt2);

        mReactRootView = (ReactRootView) that.findViewById(R.id.react_root_view_1);
        mReactRootView.startReactApplication(that.getReactInstanceManager(),"TestComp",initProps1);

        mReactRootView2 = (ReactRootView) that.findViewById(R.id.react_root_view_2);
        mReactRootView2.startReactApplication(that.getReactInstanceManager(),"HelloWorld",initProps2);
    }

//    @Override
//    protected String getMainComponentName() {
//        return "HelloWorld";
//    }
}


