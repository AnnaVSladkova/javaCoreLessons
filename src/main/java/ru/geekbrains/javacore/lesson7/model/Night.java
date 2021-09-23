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
public class Night{
    @JsonProperty("Icon") 
    public int icon;
    @JsonProperty("IconPhrase") 
    public String iconPhrase;
    @JsonProperty("HasPrecipitation") 
    public boolean hasPrecipitation;
}
