package com.example.kim.demowebapp;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by kim on 2017. 9. 25..
 */

public class CustomToast extends Activity {

    Context context;

    CustomToast(Context context) {
        this.context = context;
    }

    void makeCustomToast(String message, int length) {
        Toast.makeText(context, message, length).show();
    }

}
