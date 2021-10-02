/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.javacore.lesson7.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author SMS
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Maximum{
    @JsonProperty("Value") 
    public double value;
    @JsonProperty("Unit") 
    public String unit;
    @JsonProperty("UnitType") 
    public int unitType;
}
