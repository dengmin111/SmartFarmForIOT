package com.example.hasee.smartfarmforiot;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by HASEE on 2018/9/5.
 */

public class MyApplication extends MultiDexApplication {
    private final static String TAG = "App";
    private static MyApplication app;
    public List<Activity> unDestroyActivityList = new ArrayList<Activity>();

    private Boolean isLogin = false;
    private String userName = null;
    private String passWord = null;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initApp();

    }

    private void initApp() {
        MultiDex.install(this);

    }

    public static MyApplication getContext() {
        return app;
    }
    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 退出应用
     */
    public void quit() {
        for (Activity activity : unDestroyActivityList) {
            if (null != activity) {
                activity.finish();
            }
        }
        unDestroyActivityList.clear();
    }
}
