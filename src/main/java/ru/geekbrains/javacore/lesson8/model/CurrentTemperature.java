package ru.geekbrains.javacore.lesson8.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentTemperature {
    @JsonProperty("Metric")
    public CurrentTemperatureValue metric;
    @JsonProperty("Imperial")
    public CurrentTemperatureValue imperial;
}
