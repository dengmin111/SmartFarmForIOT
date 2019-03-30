package com.example.hasee.smartfarmforiot.util;

/**
 * Created by HASEE on 2018/9/17.
 */

public class UrlType {
    public final static String LOGIN = "SmartFarm/login";
    public final static String ADDSENSOR = "SmartFarm/ addSensor";
    public final static String SENSORDATA = "SmartFarm/listSensorDataByDay";
    public final static String LASTDATA = "SmartFarm/latestSensorData";
    public final static String CONTROLLER = "SmartFarm/controller";
    public final static String REGEST = "SmartFarm/regist";

    public final static String HOST = "http://192.168.137.37:8080/";

    public static String getUrl(String host,String api){
        String url;
        url = host  + api;
        return url;
    }
}
