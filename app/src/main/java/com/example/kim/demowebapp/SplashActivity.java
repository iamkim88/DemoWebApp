package com.example.kim.demowebapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by kim on 2017. 9. 26..
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        //네트워크 통신 점검
        Boolean isConnect = new NetworkStatus().isNetworkStatus(this);
        if (isConnect == false) {
            new CustomAlertDialog().makeCustomDialog(this, "휴대폰의 인터넷 연결상태를 확인해주세요.", "확인");
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    finish();
                }
            }, 1200);
        }

    }
}
