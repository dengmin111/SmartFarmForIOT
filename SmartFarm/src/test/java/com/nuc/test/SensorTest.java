package com.nuc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nuc.controller.SettingController;
import com.nuc.pojo.SensorData;
import com.nuc.pojo.SensorDate;
import com.nuc.pojo.Setting;
import com.nuc.service.SensorDataSevice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class SensorTest<E> {
	@Autowired
	SensorDataSevice sensorDataSevice;
@Test
public void dsf(){
List<SensorData> list= sensorDataSevice.list();
List<SensorDate> dateList =new ArrayList<SensorDate>();
for (SensorData sensorData : list) {
	
		SensorDate sensorDate = new SensorDate();
		sensorDate.setId(sensorData.getId());
		sensorDate.setSensorId(sensorData.getSensorId());
		sensorDate.setTimeStr(sensorData.getTime());
		sensorDate.setData(sensorData.getData());
		dateList.add(sensorDate);
				}
for (SensorDate sensorDate : dateList) {
	System.out.println(sensorDate.getTimeStr());
}
}

@Test
public void testSet(){
	SettingController settingController =new SettingController();
	Setting setting = new Setting();
	setting.setHumidity((float) 6666.00);
	System.out.println(settingController.set(setting));
}
}

