package com.nuc.pojo;

public class Setting {
    private Integer id;

    private Float temperature;

    private Float humidity;

    private Float lightIntensity;

    private Float raindrop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(Float lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public Float getRaindrop() {
        return raindrop;
    }

    public void setRaindrop(Float raindrop) {
        this.raindrop = raindrop;
    }
}