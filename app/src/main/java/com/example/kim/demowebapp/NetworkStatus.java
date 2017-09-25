package com.example.kim.demowebapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;


/**
 * 장치 네트워크 상태 점검 클래스
 * Created by kim on 2017. 9. 22..
 */

public class NetworkStatus{
    private Context context;

    //네트워크 상태 생성자
    NetworkStatus(Context context){
        this.context = context;
    }

    @NonNull
        //리턴 값 Null 허용금지
    Boolean isNetworkStatus(){
        Boolean isConnect = false;

        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkState = manager.getActiveNetworkInfo();

        //모바일의 네트워크 상태가 null이 아니고 연결상태일경우만
        if(networkState != null && networkState.isConnected()){

            //WIFI 또는 LTE 연결중이면
            if(networkState.getType() == ConnectivityManager.TYPE_WIFI || networkState.getType() == ConnectivityManager.TYPE_MOBILE){
                isConnect = true;
            }
        }
        return isConnect;
    }
}
