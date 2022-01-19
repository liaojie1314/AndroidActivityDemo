package com.example.androidactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "login click... ");
                handlerLogin();
            }
        });
    }

    private void handlerLogin() {
        String accountText = mAccount.getText().toString().trim();
        if (TextUtils.isEmpty(accountText)) {
            Toast.makeText(this, "输入账号为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String passwordText = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(passwordText)) {
            Toast.makeText(this, "输入密码为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("account", accountText);
        intent.putExtra("password", passwordText);
        startActivity(intent);
    }

    private void initView() {
        mAccount = (EditText) this.findViewById(R.id.account);
        mPassword = (EditText) this.findViewById(R.id.password);
        mLogin = (Button) this.findViewById(R.id.login);
    }
}