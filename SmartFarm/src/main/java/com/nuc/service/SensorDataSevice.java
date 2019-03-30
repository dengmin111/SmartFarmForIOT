package com.nuc.service;

import java.util.List;

import com.nuc.pojo.SensorData;

public interface SensorDataSevice {
	public List<SensorData> list();
	public int insert(SensorData record);
	public int insertSelective(SensorData record);
	public List<SensorData> listTemperature(int day);
	public List<SensorData> latestData();
}
