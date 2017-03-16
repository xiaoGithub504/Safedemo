package com.example.xiao.safetydemo;

import android.text.TextUtils;

/**
 * Created by admin on 2016/11/21.
 */
//获取wifi代理
public class ProxyModule {
    public static boolean getWifi(){
        String proxyHost = System.getProperty("http.proxyHost");
        String proxyPort = System.getProperty("http.proxyPort");
        if(TextUtils.isEmpty(proxyHost)&&TextUtils.isEmpty(proxyPort)){
            return false;
        }
        return true;
    }

}
