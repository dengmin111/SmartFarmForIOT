package com.nuc.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.mapper.SensorDataMapper;
import com.nuc.pojo.SensorData;
import com.nuc.pojo.SensorDataExample;
import com.nuc.service.SensorDataSevice;

@Service
public class SensorDataServiceImpl implements SensorDataSevice {

	@Autowired
	SensorDataMapper sensorDataMapper;
	@Override
	public List<SensorData> list() {
		SensorDataExample example = new SensorDataExample();
		return sensorDataMapper.selectByExample(example);
	}
	@Override
	public int insert(SensorData record) {
		// TODO Auto-generated method stub
		return sensorDataMapper.insert(record);
	}

	@Override
	public List<SensorData> listTemperature(int day) {
		Date date = new Date();//获取当前时间    
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -day);//当前时间减去day天，即day天前的时间      
		SensorDataExample example = new SensorDataExample();
		example.or().andTimeGreaterThanOrEqualTo(calendar.getTime());//获取day天前的时间   
		return sensorDataMapper.selectByExample(example);
	}
	@Override
	public int insertSelective(SensorData record) {
		// TODO Auto-generated method stub
		return sensorDataMapper.insertSelective(record);
	}
	@Override
	public List<SensorData> latestData() {
		return sensorDataMapper.selectLatestBySensorId();
	}
    
}
