/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.javacore.lesson6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
/**
 *
 * @author SMS
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    @JsonProperty("Headline") 
    public Headline headline;
    @JsonProperty("DailyForecasts") 
    public List<DailyForecast> dailyForecasts;
}
