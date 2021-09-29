/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.javacore.lesson8.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author SMS
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature{
    @JsonProperty("Minimum") 
    public Minimum minimum;
    @JsonProperty("Maximum") 
    public Maximum maximum;
}
