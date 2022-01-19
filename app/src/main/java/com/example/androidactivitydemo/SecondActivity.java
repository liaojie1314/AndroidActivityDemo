package com.example.androidactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    private static final String TAG = "SecondActivity";
    private TextView mInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mInfo = (TextView) this.findViewById(R.id.info);
        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");
        Log.d(TAG, "account == " + account);
        Log.d(TAG, "password == " + password);

        mInfo.setText("账号：" + account + ",密码：" + password);
    }
}
