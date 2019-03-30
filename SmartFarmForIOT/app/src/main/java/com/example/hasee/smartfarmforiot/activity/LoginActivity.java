package com.example.hasee.smartfarmforiot.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hasee.smartfarmforiot.MyApplication;
import com.example.hasee.smartfarmforiot.R;
import com.example.hasee.smartfarmforiot.base.BaseActivity;
import com.example.hasee.smartfarmforiot.util.BannerAdapter;
import com.example.hasee.smartfarmforiot.util.HttpUtil;
import com.example.hasee.smartfarmforiot.util.UrlType;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Vector;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    @InjectView(R.id.ed_name)
    EditText edName;
    @InjectView(R.id.ed_pwd)
    EditText edPwd;
    @InjectView(R.id.btn_login)
    Button btnLogin;
    @InjectView(R.id.btn_register)
    Button btnReg;

    SharedPreferences preferences ;
    SharedPreferences.Editor editor;
    MyApplication application;

    @Override
    protected void setContentView() throws UnsupportedEncodingException {
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        preferences = getSharedPreferences("data",MODE_PRIVATE);
        editor = preferences.edit();
        application = MyApplication.getContext();
    }

    @Override
    protected void initViews() {
        findViewAddListener(R.id.btn_login);
        findViewAddListener(R.id.btn_register);
    }

    @Override
    protected void onViewClick(View v) {
        Log.e(TAG, "onViewClick: " );
        switch (v.getId()){
            case R.id.btn_login:
                Login();
                break;
            case R.id.btn_register:
                Register();
                break;
            default:
                break;
        }
    }

    private void Register(){
        final String userName = edName.getText().toString();
        final String userPwd = edPwd.getText().toString();
        JSONObject object = new JSONObject();
        try {
            object.put("username",userName);
            object.put("password",userPwd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = String.valueOf(object);
        HttpUtil.sendPost(UrlType.getUrl(UrlType.HOST, UrlType.REGEST), params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Log.e(TAG, "onResponse: "+data );
                if(data.equals("1")){
                    editor.putString("userName",userName);
                    editor.putString("userPwd",userPwd);
                    editor.apply();
                    application.setLogin(true);
                    application.setPassWord(userPwd);
                    application.setPassWord(userPwd);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showToast("注册成功");
                        }
                    });
                    Intent intent = new Intent(LoginActivity.this,SelectFarmActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showToast("注册失败用户名重复");
                        }
                    });

                }
            }
        });
    }
    private void Login(){
        final String userName = edName.getText().toString();
        final String userPwd = edPwd.getText().toString();
        JSONObject object = new JSONObject();
        try {
            object.put("username",userName);
            object.put("password",userPwd);
            String params = String.valueOf(object);
            HttpUtil.sendPost(UrlType.getUrl(UrlType.HOST, UrlType.LOGIN), params, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e(TAG, "onFailure: "+e.toString() );

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String data = response.body().string();
                    Log.e(TAG, "onResponse: "+data );
                    if(!data.equals("")){
                        editor.putString("userName",userName);
                        editor.putString("userPwd",userPwd);
                        editor.apply();
                        application.setLogin(true);
                        application.setPassWord(userPwd);
                        application.setPassWord(userPwd);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showToast("登陆成功");
                            }
                        });
                        Intent intent = new Intent(LoginActivity.this,SelectFarmActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showToast("账号或密码错误");
                            }
                        });
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
