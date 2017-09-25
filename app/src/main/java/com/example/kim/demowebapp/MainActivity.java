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

    private long pressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //네트워크 통신 점검
        Boolean isConnect = new NetworkStatus(getApplicationContext()).isNetworkStatus();

        if (isConnect == false) {
            new CustomAlertDialog(this).makeCustomDialog("휴대폰의 인터넷 연결상태를 확인해주세요.", "확인");
        }

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

        //첫번째 노출 페이지 세팅
        demoWebView.loadUrl("file:///android_asset/index.html");
    }


    @Override
    public void onBackPressed() {

        //0 = Short, 1 = Long
        new CustomToast(this).makeCustomToast("한번더 클릭하면 종료됩니다.", 1);
        //default 0
        if (pressedTime == 0) {
            pressedTime = System.currentTimeMillis();
        } else {
            int seconds = (int) (System.currentTimeMillis() - pressedTime);

            if (seconds > 2000) {
                pressedTime = 0;
            } else {
                finish();
            }
        }
    }
}
