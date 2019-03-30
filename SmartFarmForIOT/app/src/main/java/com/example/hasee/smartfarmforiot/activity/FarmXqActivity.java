package com.example.hasee.smartfarmforiot.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.hasee.smartfarmforiot.Bean.LatestSensorData;
import com.example.hasee.smartfarmforiot.Bean.SensorData;
import com.example.hasee.smartfarmforiot.MyApplication;
import com.example.hasee.smartfarmforiot.R;

import com.example.hasee.smartfarmforiot.base.BaseActivity;
import com.example.hasee.smartfarmforiot.util.HttpUtil;
import com.example.hasee.smartfarmforiot.util.MyLineChart;
import com.example.hasee.smartfarmforiot.util.UrlType;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.LogRecord;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FarmXqActivity extends BaseActivity {


    @InjectView(R.id.id_farm)
    TextView idFarm;
    @InjectView(R.id.update_tiem)
    TextView updateTiem;
    @InjectView(R.id.temperature)
    TextView temperature;
    @InjectView(R.id.humidity)
    TextView humidity;
    @InjectView(R.id.light)
    TextView light;
    @InjectView(R.id.lamp)
    TextView lamp;
    @InjectView(R.id.ventilator)
    TextView ventilator;
    @InjectView(R.id.draw_water)
    TextView drawWater;
    @InjectView(R.id.watering)
    TextView watering;
    @InjectView(R.id.wether)
    TextView weather;
    @InjectView(R.id.chart)
    MyLineChart mMyLineChart;
    @InjectView(R.id.aaa)
    TextView one;
    @InjectView(R.id.two)
    TextView two;
    @InjectView(R.id.three)
    TextView three;
    private Boolean isLamp = false, isVentilator = false, isDrawWater = false, isWatering = false;
    private Intent intent;
    private SensorData sensorData;
    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    private List<LatestSensorData> latestSensorData = new ArrayList<>();
    String[] xTit ;
    float[] data ;
    private String controlStr;
    private Handler handler;
    private String conStr = "02071800F11F87010077";
            ;

    @Override
    protected void setContentView() throws UnsupportedEncodingException {
        setContentView(R.layout.activity_farm_xq);
        ButterKnife.inject(this);
        intent = getIntent();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                getNowData();
            }
        };
    }

    @Override
    protected void initViews() {

        findViewAddListener(R.id.lamp);
        findViewAddListener(R.id.ventilator);
        findViewAddListener(R.id.draw_water);
        findViewAddListener(R.id.watering);
        findViewAddListener(R.id.aaa);
        findViewAddListener(R.id.two);
        findViewAddListener(R.id.three);
        getNowData();
        String url = UrlType.getUrl(UrlType.HOST, UrlType.SENSORDATA) + "?day=1";
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();
                Log.e(TAG, "onResponse: "+jsonData );
                sensorData = com.alibaba.fastjson.JSON.parseObject(jsonData,SensorData.class);
                Log.e(TAG, "initViews: "+sensorData.getHumidity().size() );
                getData(1);
                addLine(xTit,data,"光照");
                mMyLineChart.setClipValuesToContent(true);
            }
        });


    }
    private void getNowData(){
        String dataUrl = UrlType.getUrl(UrlType.HOST,UrlType.LASTDATA);
        Log.e(TAG, "initViews: "+dataUrl );
        HttpUtil.sendOkHttpRequest(dataUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.e(TAG, "onResponse: "+response );
                latestSensorData = JSON.parseArray(str,LatestSensorData.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Calendar calendar = Calendar.getInstance();
                        updateTiem.setText(calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
                        for(int i = 0;i<latestSensorData.size();i++){
                            LatestSensorData res = latestSensorData.get(i);
                            switch (res.getSensorId()){
                                case 1:
                                    if(res.getData() == 0){
                                        weather.setText("晴");
                                    }else {
                                        weather.setText("雨");
                                    }
                                    break;
                                case 2:
                                    temperature.setText(String.valueOf(res.getData()));
                                    break;
                                case 3:
                                    humidity.setText(String.valueOf(res.getData()));
                                    break;
                                case 4:
                                    light.setText(String.valueOf(res.getData()));
                                    break;
                                case 5:
                                    break;

                                default:
                            }
                        }
                        handler.sendEmptyMessageDelayed(0,5000);

                    }
                });
            }
        });
    }

    @Override
    protected void onViewClick(View v) {
        int light;
        int status;
        String urlCont = UrlType.getUrl(UrlType.HOST,UrlType.CONTROLLER);
        switch (v.getId()) {
            case R.id.lamp:
                light = 1;
                if (isLamp) {
                    lamp.setBackgroundResource(R.drawable.rounded_corner_gary);
                    isLamp = false;
                    status = 0;

                } else {
                    lamp.setBackgroundResource(R.drawable.rounded_corner_yellow);
                    isLamp = true;
                    status = 1;
                }
                urlCont = urlCont+"?"+"temp="+light+"&status="+status+"&statusCode="+conStr;
                sendControl(urlCont);
                break;
            case R.id.ventilator:
                light = 2;
                if (isVentilator) {
                    ventilator.setBackgroundResource(R.drawable.rounded_corner_gary);
                    isVentilator = false;
                    status = 0;
                } else {
                    ventilator.setBackgroundResource(R.drawable.rounded_corner_yellow);
                    isVentilator = true;
                    status = 1;
                }
                urlCont = urlCont+"?"+"temp="+light+"&status="+status+"&statusCode="+conStr;
                sendControl(urlCont);
                break;
            case R.id.draw_water:
                light = 3;
                if (isDrawWater) {
                    drawWater.setBackgroundResource(R.drawable.rounded_corner_gary);
                    isDrawWater = false;
                    status = 0;
                } else {
                    drawWater.setBackgroundResource(R.drawable.rounded_corner_yellow);
                    isDrawWater = true;
                    status = 1;
                }
                urlCont = urlCont+"?"+"temp="+light+"&status="+status+"&statusCode="+conStr;
                sendControl(urlCont);
                break;
            case R.id.watering:
                light = 4;
                if (isWatering) {
                    watering.setBackgroundResource(R.drawable.rounded_corner_gary);
                    isWatering = false;
                    status = 0;
                } else {
                    watering.setBackgroundResource(R.drawable.rounded_corner_yellow);
                    isWatering = true;
                    status = 1;
                }
                urlCont = urlCont+"?"+"temp="+light+"&status="+status+"&statusCode="+conStr;
                sendControl(urlCont);
                break;
            case R.id.aaa:
                dataSets.clear();
                getData(1);
                Log.e(TAG, "onViewClick: "+"adasd" );
                addLine(xTit,data,"光照");
                one.setBackgroundResource(R.drawable.rounded_corner_yellow);
                two.setBackgroundResource(R.drawable.rounded_corner_gary);
                three.setBackgroundResource(R.drawable.rounded_corner_gary);
                break;
            case R.id.two:
                dataSets.clear();
                getData(2);
                addLine(xTit,data,"温度");
                two.setBackgroundResource(R.drawable.rounded_corner_yellow);
                one.setBackgroundResource(R.drawable.rounded_corner_gary);
                three.setBackgroundResource(R.drawable.rounded_corner_gary);
                break;
            case R.id.three:
                dataSets.clear();
                getData(3);
                addLine(xTit,data,"湿度");
                three.setBackgroundResource(R.drawable.rounded_corner_yellow);
                one.setBackgroundResource(R.drawable.rounded_corner_gary);
                two.setBackgroundResource(R.drawable.rounded_corner_gary);
                break;
            default:
                break;
        }
    }
    private void getData(int temp){
        switch (temp){
            case 1:
                List<SensorData.LightIntensityBean> a = sensorData.getLightIntensity();
                Log.e(TAG, "getData: "+a.size() );
                xTit = new String[a.size()];
                data = new float[a.size()];
                for(int i =0;i<a.size();i++){
                    xTit[i]=a.get(i).getTimeStr();
                    data[i]=a.get(i).getData();
                }
                break;
            case 2:
                List<SensorData.TemperatureBean> b = sensorData.getTemperature();
                xTit = new String[b.size()];
                data = new float[b.size()];
                for(int i =0;i<b.size();i++){
                    xTit[i]=b.get(i).getTimeStr();
                    data[i]=b.get(i).getData();
                }
                break;
            case 3:
                List<SensorData.HumidityBean> c = sensorData.getHumidity();
                xTit = new String[c.size()];
                data = new float[c.size()];
                for(int i =0;i<c.size();i++){
                    xTit[i]=c.get(i).getTimeStr();
                    data[i]=c.get(i).getData();
                }
                break;
            default:
                break;
        }
    }

    private void addLine(final String[] xTitle, float[] data,String temp) {

        mMyLineChart.getXAxis().setValueFormatter(new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                if ((int) value < xTitle.length) {
                } else {
                    return "";
                }
                return xTitle[(int) value % xTitle.length];
            }
        });
        LineDataSet selfFundSet = null;

        if (null != data) {
            final ArrayList<Entry> values1 = new ArrayList<>();
            for (int i = 0; i < data.length; i++) {
                values1.add(new Entry(i, data[i], ""));
            }

            //设置数据1  参数1：数据源 参数2：图例名称
            selfFundSet = new LineDataSet(values1, temp);
            selfFundSet.setDrawCircles(false);//设置小圆圈是否显示
            selfFundSet.setColor(Color.BLUE);
            selfFundSet.setCircleColor(Color.BLUE);
            selfFundSet.setLineWidth(2f);//设置线宽
            selfFundSet.setCircleRadius(0f);//设置焦点圆心的大小
            selfFundSet.setValueTextSize(0f);//设置显示值的文字大小
        }

        dataSets.add(selfFundSet);
        //创建LineData对象 属于LineChart折线图的数据集合
        LineData data1 = new LineData(dataSets);
        // 添加到图表中
        mMyLineChart.setData(data1);
        mMyLineChart.invalidate();
    }
//    private String getControlStr(){
//        int t = 0;
//        int s = Integer.valueOf("77",16);
//        if(isLamp){
//            t = t + 1;
//            s = s - 1;
//        }
//        if(isVentilator){
//            t = t + 2;
//            s = s - 2;
//        }
//        if(isWatering){
//            t = t + 4;
//            s = s - 4;
//        }
//        if(isDrawWater){
//            t = t + 8;
//            s = s - 8;
//        }
//        return "02071800F11F87010"+Integer.toHexString(t)+Integer.toHexString(s);
//    }
    private void sendControl(String url){
        Log.e(TAG, "sendControl: "+url );
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                conStr = response.body().string();
                Log.e(TAG, "onResponse: "+conStr );
            }
        });
    }
}
