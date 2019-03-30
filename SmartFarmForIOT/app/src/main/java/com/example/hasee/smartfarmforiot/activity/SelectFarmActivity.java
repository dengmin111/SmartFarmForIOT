package com.example.hasee.smartfarmforiot.activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.hasee.smartfarmforiot.R;
import com.example.hasee.smartfarmforiot.base.BaseActivity;
import com.example.hasee.smartfarmforiot.myviews.CirclePageIndicator;
import com.example.hasee.smartfarmforiot.util.BannerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SelectFarmActivity extends BaseActivity {
    @InjectView(R.id.vp_banner)
    ViewPager vpBanner;
    @InjectView(R.id.indicator)
    CirclePageIndicator indicator;
    List<String> res = new ArrayList<>();

    private int currentItem;
    private Handler handler = new Handler();

    @Override
    protected void setContentView() throws UnsupportedEncodingException {
        setContentView(R.layout.activity_select_farm);
        ButterKnife.inject(this);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initViews() {
        BannerAdapter adapter = new BannerAdapter(getSupportFragmentManager(),this);
        vpBanner.setAdapter(adapter);
        indicator.setViewPager(vpBanner);
        //autoChange();

        vpBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int item) {
                currentItem = item;
                showToast(""+currentItem);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        vpBanner.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                vpBanner.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    @Override
    protected void onViewClick(View v) {

    }

}
