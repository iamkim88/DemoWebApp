package com.example.kim.demowebapp;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.demoWebView) WebView demoWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        demoWebView.getSettings().setJavaScriptEnabled(true);
        demoWebView.setWebViewClient(new WebViewClient());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            demoWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
            demoWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        }

        demoWebView.loadUrl("file:///android_asset/index.html");

        Boolean isConnect = new  NetworkStatus(getApplicationContext()).isNetworkStatus();


        if (isConnect == false) {
            new CustomAlertDialog(this).makeCustomDialog("휴대폰의 인터넷 연결상태를 확인해주세요.", "확인");

        }
    }




}
