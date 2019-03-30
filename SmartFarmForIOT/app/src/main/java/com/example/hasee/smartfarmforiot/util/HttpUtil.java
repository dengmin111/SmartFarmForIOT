package com.example.hasee.smartfarmforiot.util;

import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by HASEE on 2018/9/5.
 */

public class HttpUtil {
    private static final String TAG = "HttpUtil";
    public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
    public static void sendPost(String address,String json,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON,json);
        Log.e(TAG, "sendPost: "+address );
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}