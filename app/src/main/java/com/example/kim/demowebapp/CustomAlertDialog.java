package com.example.kim.demowebapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

/**
 * 커스텀 다이얼로그 생성 클래스
 * Created by kim on 2017. 9. 22..
 */

public class CustomAlertDialog extends Activity{
    private Context context;

    //생성자
    CustomAlertDialog(Context context){
        this.context = context;
    }

    //다이얼로그 생성 & 노출
    void makeCustomDialog(String  message, String yBtn){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(message);
            builder.setPositiveButton(yBtn, null);
            builder.create().show();
    }
}
