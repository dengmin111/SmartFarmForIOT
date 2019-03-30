package com.nuc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuc.pojo.Sensor;
import com.nuc.service.SensorService;


@Controller
public class SensorController {
 @Autowired
 SensorService sensorService;
 
 @RequestMapping("listSensor")
 @ResponseBody
 public List<Sensor> listSensor(){
	 return sensorService.list();
 }
@RequestMapping(value="addSensor",method=RequestMethod.POST)
@ResponseBody
public int insert(@RequestBody Sensor sensor){
return	sensorService.insert(sensor);
	
}

@RequestMapping(value="deleteSensor",method=RequestMethod.GET)
@ResponseBody
public int delete( int id){
	return sensorService.deleteByPrimaryKey(id);
}
}
