package com.example.kim.demowebapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

/**
 * 커스텀 다이얼로그 생성 클래스
 * Created by kim on 2017. 9. 22..
 */

public class CustomAlertDialog extends Activity{

    /**
     * 알러트 다이얼로그 생성 메소드
     *
     * @param message
     * @param okBtn
     */
    void makeCustomDialog(Context context, String message, String okBtn) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton(okBtn, null);
        builder.create().show();
    }

}
