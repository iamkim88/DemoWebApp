package com.example.kim.demowebapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

/**
 * 다이얼로그 커스텀 객체
 * Created by kim on 2017. 9. 22..
 */

public class CustomAlertDialog extends Activity{
    Context context;

    //생성자
    CustomAlertDialog(Context context){
        this.context = context;
    }

    //다이얼로그 객체 생성
    void makeCustomDialog(String  message, String yBtn){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(message);
            builder.setPositiveButton(yBtn, null);
            builder.create().show();
    }
}
