package com.example.kim.demowebapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;


/**
 * 네트워크 상태를 점검하는 객체
 * Created by kim on 2017. 9. 22..
 */

public class NetworkStatus{
    Context context;

    //네트워크 상태 생성자
    NetworkStatus(Context context){
        this.context = context;
    }

    @NonNull
    Boolean isNetworkStatus(){
        Boolean isConnect = false;

        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkState = manager.getActiveNetworkInfo();

        if(networkState != null && networkState.isConnected()){
            if(networkState.getType() == ConnectivityManager.TYPE_WIFI || networkState.getType() == ConnectivityManager.TYPE_MOBILE){
                isConnect = true;
            }
        }
        return isConnect;
    }
}
