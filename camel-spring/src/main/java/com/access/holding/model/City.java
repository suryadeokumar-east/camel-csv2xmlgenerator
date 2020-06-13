package com.access.holding.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "city")
@XmlType(propOrder = { "name", "population" })
public class City implements Serializable{

	private String name;
	private String population;
    private String country;
    
	@XmlTransient
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	@XmlAttribute(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	public String getPopulation() {
		return population;
	}
	@XmlElement(name = "population")
	public void setPopulation(String population) {
		this.population = population;
	}


}
