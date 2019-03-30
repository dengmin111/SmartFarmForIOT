package com.example.hasee.smartfarmforiot.myviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.hasee.smartfarmforiot.R;

/**
 * Created by HASEE on 2018/9/5.
 */

public class CustomDialogView extends View {

    // 加载图片资源id，存入缓存数组
    private final int[] ids = new int[] { R.mipmap.dgl,
            R.mipmap.dgm, R.mipmap.dgn, R.mipmap.dgn ,
            R.mipmap.dgo, R.mipmap.dgp, R.mipmap.dgq ,
            R.mipmap.dgr, R.mipmap.dgs, R.mipmap.dgt ,
            R.mipmap.dgu , R.mipmap.dgv, R.mipmap.dgw};

    private Bitmap[] loadingImgs ;

    private Paint loadingImagePaint ;

    private int currentIdsIndex = 0;

    public CustomDialogView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomDialogView(Context context) {
        super(context);
        init();
    }

    private void init() {

        // 实例化画笔
        loadingImagePaint = new Paint();
        // 设置抗锯齿
        loadingImagePaint.setAntiAlias(true);

        // 一次性放进缓存数组中
        loadingImgs = new Bitmap[] {
                BitmapFactory. decodeResource(getResources(), ids[0]),
                BitmapFactory. decodeResource(getResources(), ids[1]),
                BitmapFactory. decodeResource(getResources(), ids[2]),
                BitmapFactory. decodeResource(getResources(), ids[3]),
                BitmapFactory. decodeResource(getResources(), ids[4]),
                BitmapFactory. decodeResource(getResources(), ids[5]),
                BitmapFactory. decodeResource(getResources(), ids[6]),
                BitmapFactory. decodeResource(getResources(), ids[7]),
                BitmapFactory. decodeResource(getResources(), ids[8]),
                BitmapFactory. decodeResource(getResources(), ids[9]),
                BitmapFactory. decodeResource(getResources(), ids[10]) ,
                BitmapFactory. decodeResource(getResources(), ids[11]),
                BitmapFactory. decodeResource(getResources(), ids[12])};
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 循环控制每一张图片的绘制顺序，让看起来像是播放动画
        if (currentIdsIndex >= (ids .length - 1)) {
            currentIdsIndex = 0;
        }

        Bitmap currentLoadingBitmap = loadingImgs[currentIdsIndex ];
        // 绘制图片，显示在屏幕正中
        canvas.drawBitmap(currentLoadingBitmap, (getWidth() - currentLoadingBitmap.getWidth())/2,
                (getHeight() - currentLoadingBitmap.getHeight())/2, loadingImagePaint );

        currentIdsIndex++;

        super.onDraw(canvas);
    }

}
