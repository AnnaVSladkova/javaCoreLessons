/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.javacore.lesson6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
/**
 *
 * @author SMS
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline{
    @JsonProperty("EffectiveDate") 
    public Date effectiveDate;
    @JsonProperty("EffectiveEpochDate") 
    public int effectiveEpochDate;
    @JsonProperty("Severity") 
    public int severity;
    @JsonProperty("Text") 
    public String text;
    @JsonProperty("Category") 
    public String category;
    @JsonProperty("EndDate") 
    public Date endDate;
    @JsonProperty("EndEpochDate") 
    public int endEpochDate;
    @JsonProperty("MobileLink") 
    public String mobileLink;
    @JsonProperty("Link") 
    public String link;
}
