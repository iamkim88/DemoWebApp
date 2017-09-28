package com.example.kim.demowebapp;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * 커스텀 토스트 생성하는 클래스
 * Created by kim on 2017. 9. 25..
 */

public class CustomToast extends Activity {
    static private Toast toast;

    /**
     * 토스트 생성 메소드
     *
     * @param message
     * @param duration
     */
    void showToast(Context context, String message, int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, message, duration);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    void noShowToast() {
        toast.cancel();
    }
}
