package com.sherlockshi.toast.demo;

import android.app.Application;

import com.sherlockshi.toast.ToastUtils;

public class ToastApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化吐司
        ToastUtils.init(this);
    }
}