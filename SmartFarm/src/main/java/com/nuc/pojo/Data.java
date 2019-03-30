package com.nuc.pojo;

import java.util.List;

public class Data {
private List<SensorDate> temperature;
private List<SensorDate> humidity;
private List<SensorDate> lightIntensity;
private List<SensorDate> raindrop;
public List<SensorDate> getTemperature() {
	return temperature;
}
public void setTemperature(List<SensorDate> temperature) {
	this.temperature = temperature;
}
public List<SensorDate> getHumidity() {
	return humidity;
}
public void setHumidity(List<SensorDate> humidity) {
	this.humidity = humidity;
}
public List<SensorDate> getLightIntensity() {
	return lightIntensity;
}
public void setLightIntensity(List<SensorDate> lightIntensity) {
	this.lightIntensity = lightIntensity;
}
public List<SensorDate> getRaindrop() {
	return raindrop;
}
public void setRaindrop(List<SensorDate> raindrop) {
	this.raindrop = raindrop;
}
}
