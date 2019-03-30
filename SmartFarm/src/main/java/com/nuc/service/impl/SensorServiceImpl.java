package com.nuc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuc.mapper.SensorMapper;
import com.nuc.pojo.Sensor;
import com.nuc.pojo.SensorExample;
import com.nuc.service.SensorService;

@Service
public class SensorServiceImpl implements SensorService{
	
	@Autowired
	SensorMapper sensorMapper;

	@Override
	public List<Sensor> list() {
		SensorExample sensorExample =new SensorExample();
		   
		return  sensorMapper.selectByExample(sensorExample);
	}

	@Override
	public int insert(Sensor record) {
		
		return sensorMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sensorMapper.deleteByPrimaryKey(id);
	}
	

}
