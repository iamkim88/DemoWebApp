package com.example.kim.demowebapp;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * 커스텀 토스트 생성하는 클래스
 * Created by kim on 2017. 9. 25..
 */

public class CustomToast extends Activity {
    private Context context;

    //생성자
    CustomToast(Context context) {
        this.context = context;
    }

    //토스트 노출
    void makeCustomToast(String message, int length) {
        Toast.makeText(context, message, length).show();
    }

}
