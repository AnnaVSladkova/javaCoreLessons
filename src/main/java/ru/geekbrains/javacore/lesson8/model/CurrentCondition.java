package ru.geekbrains.javacore.lesson8.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentCondition {
    @JsonProperty("LocalObservationDateTime")
    public Date localObservationDateTime;
    @JsonProperty("EpochTime")
    public Long epochTime;
    @JsonProperty("WeatherText")
    public String weatherText;
    @JsonProperty("WeatherIcon")
    public Integer weatherIcon;
    @JsonProperty("HasPrecipitation")
    public Boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    public String precipitationType;
    @JsonProperty("IsDayTime")
    public Boolean isDayTime;
    @JsonProperty("Temperature")
    public CurrentTemperature temperature;

}
