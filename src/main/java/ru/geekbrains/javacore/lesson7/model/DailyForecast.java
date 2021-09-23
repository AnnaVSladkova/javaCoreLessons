/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.javacore.lesson7.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * @author SMS
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast{
    @JsonProperty("Date") 
    public Date date;
    @JsonProperty("EpochDate") 
    public int epochDate;
    @JsonProperty("Temperature") 
    public Temperature temperature;
    @JsonProperty("Day") 
    public Day day;
    @JsonProperty("Night") 
    public Night night;
    @JsonProperty("Sources") 
    public List<String> sources;
    @JsonProperty("MobileLink") 
    public String mobileLink;
    @JsonProperty("Link") 
    public String link;
}