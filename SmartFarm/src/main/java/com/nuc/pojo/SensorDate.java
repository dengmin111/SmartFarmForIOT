package com.nuc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SensorDate extends SensorData {

        private String  timeStr;
  
	public void setTimeStr(Date date) {
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.timeStr=dateFormat.format(date);
	
	}
    public String getTimeStr() {
    	return timeStr;
    }
}
