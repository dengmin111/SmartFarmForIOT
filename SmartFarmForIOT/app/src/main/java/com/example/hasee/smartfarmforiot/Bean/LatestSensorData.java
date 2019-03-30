package com.example.hasee.smartfarmforiot.Bean;

/**
 * Created by HASEE on 2018/9/28.
 */

public class LatestSensorData {
    /**
     * id : 1260
     * data : 0.0
     * sensorId : 6
     * time : null
     * timeStr : 2018-09-27 20:49:13
     */

    private int id;
    private double data;
    private int sensorId;
    private Object time;
    private String timeStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}
