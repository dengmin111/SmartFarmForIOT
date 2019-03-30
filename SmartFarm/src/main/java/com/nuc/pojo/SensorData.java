package com.nuc.pojo;

import java.util.Date;

public class SensorData {
    @Override
	public String toString() {
		return "SensorData [id=" + id + ", data=" + data + ", sensorId=" + sensorId + ", time=" + time + "]";
	}

	private Integer id;

    private Float data;

    private Integer sensorId;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getData() {
        return data;
    }

    public void setData(Float data) {
        this.data = data;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}