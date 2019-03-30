package com.nuc.service;

import java.util.List;

import com.nuc.pojo.Sensor;

public interface SensorService {
	List<Sensor> list();
	int insert(Sensor record);
	int deleteByPrimaryKey(Integer id);

}
