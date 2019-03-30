package com.example.hasee.smartfarmforiot.Bean;

import java.util.List;

/**
 * Created by HASEE on 2018/9/27.
 */

public class SensorData {
    private List<TemperatureBean> temperature;
    private List<HumidityBean> humidity;
    private List<LightIntensityBean> lightIntensity;
    private List<RaindropBean> raindrop;

    public List<TemperatureBean> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<TemperatureBean> temperature) {
        this.temperature = temperature;
    }

    public List<HumidityBean> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<HumidityBean> humidity) {
        this.humidity = humidity;
    }

    public List<LightIntensityBean> getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(List<LightIntensityBean> lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public List<RaindropBean> getRaindrop() {
        return raindrop;
    }

    public void setRaindrop(List<RaindropBean> raindrop) {
        this.raindrop = raindrop;
    }

    public static class TemperatureBean {
        /**
         * id : 10
         * data : 324.0
         * sensorId : 2
         * time : null
         * timeStr : 2018-09-25 21:40:26
         */

        private int id;
        private float data;
        private int sensorId;
        private Object time;
        private String timeStr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getData() {
            return data;
        }

        public void setData(float data) {
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

    public static class HumidityBean {
        /**
         * id : 13
         * data : 46.82
         * sensorId : 3
         * time : null
         * timeStr : 2018-09-26 17:37:13
         */

        private int id;
        private float data;
        private int sensorId;
        private Object time;
        private String timeStr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getData() {
            return data;
        }

        public void setData(float data) {
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

    public static class LightIntensityBean {
        /**
         * id : 37
         * data : 489.0
         * sensorId : 4
         * time : null
         * timeStr : 2018-09-26 18:00:37
         */

        private int id;
        private float data;
        private int sensorId;
        private Object time;
        private String timeStr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getData() {
            return data;
        }

        public void setData(float data) {
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

    public static class RaindropBean {
        /**
         * id : 38
         * data : 0.0
         * sensorId : 1
         * time : null
         * timeStr : 2018-09-26 18:00:41
         */

        private int id;
        private float data;
        private int sensorId;
        private Object time;
        private String timeStr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getData() {
            return data;
        }

        public void setData(float data) {
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
}
