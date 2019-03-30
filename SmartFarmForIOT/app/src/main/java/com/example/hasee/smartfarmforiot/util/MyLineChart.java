package com.example.hasee.smartfarmforiot.util;

/**
 * Created by HASEE on 2018/9/27.
 */

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;


import java.text.DecimalFormat;



public class MyLineChart extends LineChart {
    public MyLineChart(Context context) {
        super(context);
        init(this);
    }

    public MyLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(this);
    }

    public MyLineChart(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(this);
    }
    protected  void init(MyLineChart myLineChart){
        /**
         * 设置整体属性
         */
        Description description = new Description();
        description.setText("");
        description.setTextColor(Color.RED);
        description.setTextSize(60);
        myLineChart.setDescription(description);//设置图表描述信息
        myLineChart.setNoDataText("数据正在加载中");//没有数据时显示的文字
        myLineChart.setNoDataTextColor(Color.GRAY);//没有数据时显示文字的颜色
        myLineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        myLineChart.setDrawBorders(true);//禁止绘制图表边框的线
        /**
         * 设置X轴属性
         */
        //隐藏X轴竖网格线
        myLineChart.getXAxis().setTextSize(12f);
        myLineChart.getXAxis().setTextColor(Color.parseColor("#0071da"));
        myLineChart.getXAxis().setDrawGridLines(true);
        myLineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的位置
        myLineChart.getXAxis().setDrawAxisLine(true);
        // 前面xAxis.setEnabled(false);则下面绘制的Grid不会有"竖的线"（与X轴有关）
        myLineChart.getXAxis().setDrawGridLines(false); // 效果如下图
        myLineChart.getXAxis().setAvoidFirstLastClipping(false);
        myLineChart.setExtraLeftOffset(16f);
        myLineChart.setExtraRightOffset(40f);
        myLineChart.getXAxis().setLabelCount(3,true);

        /**
         * 设置Y轴属性
         */
        YAxis axisLeft = myLineChart.getAxisLeft();
        axisLeft.setTextColor(Color.parseColor("#0071da"));
        axisLeft.setTextSize(12f);
        axisLeft.enableGridDashedLine(10f, 10f, 0f); //设置横向表格为虚线
        myLineChart.getAxisRight().setEnabled(false); // 隐藏右边 的坐标轴
        axisLeft.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                DecimalFormat decimalFormat=new DecimalFormat("######0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
                String unit=decimalFormat.format(value);//format 返回的是字符串
                return unit;
            }
        });
    }
}