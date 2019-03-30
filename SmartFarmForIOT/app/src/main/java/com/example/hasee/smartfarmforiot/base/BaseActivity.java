package com.example.hasee.smartfarmforiot.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasee.smartfarmforiot.MyApplication;
import com.example.hasee.smartfarmforiot.R;
import com.example.hasee.smartfarmforiot.myviews.CustomDialogView;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;


/**
 * Activity基类
 *
 * @author Bruce.Wang
 *
 */
public abstract class BaseActivity extends FragmentActivity implements
        OnClickListener {

    public ProgressDialog progressDialog;
    RedrawCustomDialogViewThread redrawCdvRunnable;
    private CustomDialogView customDialogView;
    private TextView jiazai;
    Dialog dialog;
    private View headerView;
    private MyApplication app;
    public final static int REQUEST_LOGIN = 1001;
    public String TAG = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.scaledDensity = displayMetrics.density;
        app = MyApplication.getContext();
        app.unDestroyActivityList.add(this);
        setFullScreen(false);
        try {
            setContentView();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        initViews();
    }

    /**
     * 设置内容显示
     */
    protected abstract void setContentView() throws UnsupportedEncodingException;

    /**
     * 初始化控件
     */
    protected abstract void initViews();

    /**
     * 子类实现响应监听
     */
    protected abstract void onViewClick(View v);

    @Override
    public void onClick(View v) {
        onViewClick(v);
    }

    /**
     * 是否全屏和显示标题，true为全屏和无标题，false为无标题，请在setContentView()方法前调用
     *
     * @param fullScreen
     */
    public void setFullScreen(boolean fullScreen) {
        if (fullScreen) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

    }

    /**
     * 找到控件并添加监听
     *
     * @param id
     * @return
     */
    public View findViewAddListener(int id) {
        View view = findViewById(id);
        view.setOnClickListener(this);
        return view;
    }

    /**
     * 找到控件并添加监听
     *
     * @param id
     * @return
     */
    public View findViewAddListener(View parent, int id) {
        View view = parent.findViewById(id);
        view.setOnClickListener(this);
        return view;
    }

    Toast toast;

    /**
     * 短时间显示Toast
     *
     * @param info
     *            显示的内容
     */
    public void showToast(String info) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, info, Toast.LENGTH_SHORT);
        toast.setText(info);
        toast.show();
    }
public int result(int[] a){
        int i = 0;
        int res = 0;
        int temp = 0;
        for (i = 0;i < a.length;i++){
            temp = a[0] + i;
            if(a[i] - temp != 0){
                res = temp;
                break;
            }
        }
        return res;
}
    /**
     * 长时间显示Toast
     *
     * @param info
     *            显示的内容
     */
    public void showToastLong(String info) {
        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
    }



    public void showProgressDialog(String msg) {

        View view = LayoutInflater.from(this).inflate(
                R.layout.dialog_withwait, null);

        dialog = new AlertDialog.Builder(this).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        dialog.getWindow().setContentView(view);

        customDialogView = (CustomDialogView) view
                .findViewById(R.id.view_customdialog);
        jiazai = (TextView) view
                .findViewById(R.id.jiazai);
        jiazai.setText(msg);
        redrawCdvRunnable = new RedrawCustomDialogViewThread();
        new Thread(redrawCdvRunnable).start();

    }

    /**
     * 取消对话框显示
     */
    public void disMissDialog() {
//		if (progressDialog != null && progressDialog.isShowing()) {
//			progressDialog.dismiss();
//			progressDialog = null;
//		}
        if (dialog != null && dialog.isShowing()) {
            redrawCdvRunnable.setRun(false);
            dialog.dismiss();
        }
    }

    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getContext().unDestroyActivityList.remove(this);
    }




    /**
     * 执行图片的转动线程
     *
     * @author ygq
     *
     */
    final class RedrawCustomDialogViewThread implements Runnable {

        private boolean isRun = true;

        @Override
        public void run() {

            while (isRun && dialog != null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 通知重绘
                customDialogView.postInvalidate();
            }

        }

        public boolean isRun() {
            return isRun;
        }

        public void setRun(boolean isRun) {
            this.isRun = isRun;
        }

    }
    @Override
    protected void onRestart() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.scaledDensity = displayMetrics.density;
        super.onRestart();
    }
}
