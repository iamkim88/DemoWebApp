package com.example.kim.demowebapp;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.demoWebView) WebView demoWebView;
    private Long pressedTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //크롬 웹뷰 디버깅 세팅
        WebView.setWebContentsDebuggingEnabled(true);

        WebSettings webSettings = demoWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //OS 버전 체크 16이하의 버전은 화면 로딩이 안됨
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            //file://URL이면 어느 오리진에 대해서도 Ajax로 요청을 보낼 수 있다.
            //API 16 부터 이용가능
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }

        demoWebView.setWebViewClient(new WebViewClient());
        demoWebView.loadUrl("file:///android_asset/index.html");

    }

    @Override
    public void onBackPressed() {
        new CustomToast().showToast(this, "한번 더 클릭하면 종료됩니다.", 1);

        //default 0L
        if (pressedTime == 0L) {
            pressedTime = System.currentTimeMillis();
        } else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);

            if (seconds > 2000) {
                pressedTime = 0L;
            } else {
                finish();
                new CustomToast().noShowToast();
            }
        }
    }

}
