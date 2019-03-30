package com.example.hasee.smartfarmforiot.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hasee.smartfarmforiot.R;
import com.example.hasee.smartfarmforiot.activity.FarmXqActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HASEE on 2018/9/7.
 */

public class BannerAdapter extends FragmentPagerAdapter {

    private Context context;

    private List<Fragment> views;
    String a;

    @Override
    public int getCount() {
        return 5;
    }

    public BannerAdapter(FragmentManager manager,  Context context) {
        super(manager);
        this.context = context;

        views = new ArrayList<Fragment>();
        for (int i = 0; i < 5; i++) {
            PicFragment frg = new PicFragment();
            frg.setUrl(context,i,"这是第"+i+"个");
            a = "这是第"+i+"个";
            views.add(frg);
        }
    }


    @Override
    public Fragment getItem(int arg0) {
        return views.get(arg0);
    }

    public static class PicFragment extends Fragment {

        int position;
        Context context;
        private String s;

        public PicFragment() {
        }

        public void setUrl(Context context,int position,String s) {
            this.position = position;
            this.context = context;
            this.s = s;

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.item_banner_pic, null);
            FrameLayout itemFarm = view.findViewById(R.id.item_farm);
            TextView text = view.findViewById(R.id.text);
            int temp = position+1;
            text.setText("这是第"+temp+"个农场");

            itemFarm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FarmXqActivity.class);
                    startActivity(intent);
                }
            });
            return view;
        }

        protected void onViewClick(View v) {

        }

    }
}