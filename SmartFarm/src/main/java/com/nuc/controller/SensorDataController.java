package com.nuc.controller;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuc.pojo.Data;
import com.nuc.pojo.SensorData;
import com.nuc.pojo.SensorDate;
import com.nuc.service.SensorDataSevice;

@Controller
public class SensorDataController {
	@Autowired
	SensorDataSevice sensorDataSevice;
	
	@RequestMapping("listSensorData")
	@ResponseBody
	public List<SensorDate> listSensorData(){
		
		List<SensorData> list = sensorDataSevice.list();
		
		//SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		List<SensorDate> dateList = new LinkedList<SensorDate>()  ;
		for (SensorData sensorData : list) {
			SensorDate sensorDate = new SensorDate();
			sensorDate.setId(sensorData.getId());
			sensorDate.setSensorId(sensorData.getSensorId());
			sensorDate.setTimeStr(sensorData.getTime());
			sensorDate.setData(sensorData.getData());
			dateList.add(sensorDate);
					}
		return dateList;
	}
	
	@RequestMapping("insertSensorData")
	@ResponseBody
	public int insert(@RequestBody SensorData sensorData){
		System.out.println(sensorDataSevice);
		return sensorDataSevice.insertSelective(sensorData);
	}
	
	@RequestMapping("listSensorDataByDay")
	@ResponseBody
	public Data listSensorDataByDay(int day){
		List<SensorData> list =sensorDataSevice.listTemperature(day);
		 List<SensorDate> temperature = new LinkedList<SensorDate>()  ;
		 List<SensorDate> humidity = new LinkedList<SensorDate>()  ;
		 List<SensorDate> lightIntensity = new LinkedList<SensorDate>()  ;
		 List<SensorDate> raindrop = new LinkedList<SensorDate>()  ;
		for (SensorData sensorData : list) {
			switch (sensorData.getSensorId()) {
			case 2:
				add(temperature, sensorData);
				break;
			case 3:
				add(humidity, sensorData);
				break;
			case 4:
				add(lightIntensity, sensorData);
				break;
			case 1:
				add(raindrop, sensorData);
				break;

			default:
				break;
			}
			
		}
		Data data = new Data();
		data.setTemperature(temperature);
		data.setHumidity(humidity);
		data.setLightIntensity(lightIntensity);
		data.setRaindrop(raindrop);
		return data;
	}
	@RequestMapping("latestSensorData")
	@ResponseBody
	public List<SensorDate> latestSensorData(){
		List<SensorData> listSensor= new ArrayList<SensorData>();
		List<SensorDate> listSensordate= new ArrayList<SensorDate>();
		
		listSensor=sensorDataSevice.latestData();
		for (SensorData sensorData : listSensor) {
			add(listSensordate, sensorData);
		}
		return listSensordate;
	}
	
	public static void add(List<SensorDate> dateList,SensorData sensorData){
		SensorDate sensorDate = new SensorDate();
		sensorDate.setId(sensorData.getId());
		sensorDate.setSensorId(sensorData.getSensorId());
		sensorDate.setTimeStr(sensorData.getTime());
		sensorDate.setData(sensorData.getData());
		dateList.add(sensorDate);
	}

}
